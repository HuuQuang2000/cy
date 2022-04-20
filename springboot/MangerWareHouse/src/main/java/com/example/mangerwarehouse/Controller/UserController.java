package com.example.mangerwarehouse.Controller;

import com.example.mangerwarehouse.Config.Response;
import com.example.mangerwarehouse.DTO.UserDTO;
import com.example.mangerwarehouse.Modal.UserModal;
import com.example.mangerwarehouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    UserService userService;


    @PostMapping(value = "/add" ,produces="application/json")
    public Response<UserDTO> save(@RequestBody UserDTO dto ){
        boolean result = this.userService.save(UserModal.toModel(dto));
        return Response.ofSucceeded(dto);
    }

    @PostMapping(value = "/update" ,produces="application/json")
    public Response<UserDTO> update(@RequestBody UserDTO dto ){
        UserModal result = this.userService.update(UserModal.toModel(dto));
        return Response.ofSucceeded(dto);
    }
    @GetMapping(value = "/getAll/{pageIndex}/{pageSize}" ,produces="application/json")
    public Response<List<UserModal>> findByPage(@PathVariable("pageIndex") int pageIndex ,@PathVariable("pageSize") int pageSize){
        Page<UserModal> page = userService.findByPage(pageIndex,pageIndex);
        return Response.ofSucceeded(page);
    }

}
