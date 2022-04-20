package com.example.demo.service;

import com.example.demo.entity.ProductEntity;
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
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class UserDataFetcher implements BaseService<ProductEntity>{
    @Value("classpath:Users.graphql")
    Resource resource;

    private GraphQL graphQL;

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
                ).build();
    }

    @Override
    public List<ProductEntity> getAll(DataFetchingEnvironment dataFetchingEnvironment) {
        return null;
    }

    @Override
    public Boolean delete(DataFetchingEnvironment environment) {
        return null;
    }

    @Override
    public ProductEntity findByid(DataFetchingEnvironment dataFetchingEnvironment) {
        return null;
    }

    @Override
    public ProductEntity update(DataFetchingEnvironment environment) {
        return null;
    }

    @Override
    public Boolean save(DataFetchingEnvironment environment) {
        return null;
    }

    @Override
    public Page<ProductEntity> getAllPage(DataFetchingEnvironment dataFetchingEnvironment) {
        return null;
    }

    @Override
    public Page<ProductEntity> findPage(DataFetchingEnvironment dataFetchingEnvironment) {
        return null;
    }

    @Override
    public ProductEntity get(DataFetchingEnvironment dataFetchingEnvironment) {
        return null;
    }
}
