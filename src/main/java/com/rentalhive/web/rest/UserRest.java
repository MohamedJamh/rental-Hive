package com.rentalhive.web.rest;

import com.rentalhive.domain.User;
import com.rentalhive.dto.UserDto;
import com.rentalhive.mapper.UserDtoMapper;
import com.rentalhive.service.impl.UserServiceImpl;
import com.rentalhive.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
public class UserRest {

    private final UserServiceImpl userService;
    @Autowired
    public UserRest(UserServiceImpl userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid UserDto userDto){
        Response<User> userResponse = new Response<>();
        User user = UserDtoMapper.toEntity(userDto);
        userResponse.setMessage("User saved successfully");
        userResponse.setResult(userService.save(UserDtoMapper.toEntity(userDto)));
        return new ResponseEntity<>(userResponse.toString(), HttpStatus.OK);
    }
}
