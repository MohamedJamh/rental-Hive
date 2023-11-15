package com.rentalhive.web.rest;

import com.rentalhive.domain.User;
import com.rentalhive.service.impl.UserServiceImpl;
import com.rentalhive.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserRest {

    private final UserServiceImpl userService;
    @Autowired
    public UserRest(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Response<User>> save(@RequestParam String firstName){
        Response<User> userResponse = new Response<>();
        userResponse.setMessage("yest");
        userResponse.setResult(
                User.builder()
                        .firstName(firstName)
                        .build()
        );
        return new ResponseEntity<>(
                userResponse,HttpStatus.OK
        );
    }
}
