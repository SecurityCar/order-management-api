package br.com.vitorcarvalho.order_management_api.modules.user.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitorcarvalho.order_management_api.modules.user.UserEntity;
import br.com.vitorcarvalho.order_management_api.modules.user.dto.CreateUserRequest;
import br.com.vitorcarvalho.order_management_api.modules.user.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }
    
    @PostMapping("/")
    public ResponseEntity<UserEntity> create(@Valid @RequestBody CreateUserRequest dto){
        UserEntity user = this.userService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
