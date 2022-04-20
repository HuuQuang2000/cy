package com.example.demo.service;

import com.example.demo.entity.ProductEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.IProductRepository;
import com.example.demo.repository.IUserRepository;
import graphql.GraphQL;
import graphql.schema.DataFetchingEnvironment;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class ProductDataFetcher implements BaseService<ProductEntity>{
    @Value("classpath:Products.graphql")
    Resource resource;

    private GraphQL graphQL;

    @Autowired
    IProductRepository iProductRepository;
    @Autowired
    IUserRepository iUserRepository;

    @PostConstruct
    private void loadSchema() throws IOException {

        File schemaFile = resource.getFile();
        // parse schema
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }
    public GraphQL getGraphQL() {
        return graphQL;
    }
    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("save", this :: save)
                        .dataFetcher("delete", this :: delete)
                        .dataFetcher("update", this :: update)
                        .dataFetcher("findById", this :: findByid)
                        .dataFetcher("getAll", this :: getAll)
                        .dataFetcher("getAllPage", this :: getAllPage)
                        .dataFetcher("findPage", this :: findPage)
                ).build();
    }

    @Override
    public List<ProductEntity> getAll(DataFetchingEnvironment dataFetchingEnvironment) {
        List<ProductEntity> list = (List<ProductEntity>) iProductRepository.findAll();

        return list;
    }

    @Override
    public Boolean delete(DataFetchingEnvironment environment) {
        try{
            Long id = environment.getArgument("id");
            iProductRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    @Override
    public ProductEntity findByid(DataFetchingEnvironment dataFetchingEnvironment) {
        Long id = dataFetchingEnvironment.getArgument("id");
        ProductEntity productEntity = iProductRepository.findById(id).get();
        return productEntity;
    }
    @Override
    public ProductEntity update(DataFetchingEnvironment environment) {

            Long id = environment.getArgument("id");
            String name = environment.getArgument("name");
            Long idUser =environment.getArgument("idUser");
            int  price = environment.getArgument("price");
            int total = environment.getArgument("total");
            UserEntity user = iUserRepository.findById(idUser).get();

            ProductEntity  productEntity = iProductRepository.findById(id).get();
            productEntity.setPrice(price);
            productEntity.setTotal(total);
            productEntity.setName(name);
            productEntity.setUserEntity(user);
            iProductRepository.save(productEntity);
            return productEntity;
    }

    @Override
    public Boolean save(DataFetchingEnvironment environment) {
        try{
            Long id = environment.getArgument("id");
            String name = environment.getArgument("name");
            Long idUser =environment.getArgument("idUser");
            int  price = environment.getArgument("price");
            int total = environment.getArgument("total");
            UserEntity user = iUserRepository.findById(idUser).get();

            ProductEntity  productEntity = ProductEntity.builder()
                    .id(id)
                    .name(name)
                    .price(price)
                    .total(total)
                    .userEntity(user)
                    .build();

            iProductRepository.save(productEntity);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    @Override
    public Page<ProductEntity> getAllPage(DataFetchingEnvironment dataFetchingEnvironment) {
        Integer pageIndex = dataFetchingEnvironment.getArgument("pageIndex");
        Integer pageSize= dataFetchingEnvironment.getArgument("pageSize");
        Pageable pageable = PageRequest.of(pageIndex,pageSize);
        Page<ProductEntity> pageStudent = iProductRepository.findAll(pageable);
        return pageStudent;
    }

    @Override
    public Page<ProductEntity> findPage(DataFetchingEnvironment dataFetchingEnvironment) {
        String fieldSearch = dataFetchingEnvironment.getArgument("fieldSearch");
        Integer pageIndex = 0;
        Integer pageSize= 2;
        Pageable pageable = PageRequest.of(pageIndex,pageSize);
        Page<ProductEntity> pageFindStudent = iProductRepository.findAllByfiledSearch(fieldSearch,pageable);
        return pageFindStudent;
    }
    @Override
    public ProductEntity get(DataFetchingEnvironment dataFetchingEnvironment) {
        return null;
    }
}
