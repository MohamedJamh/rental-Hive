package com.rentalhive.web.rest;

import com.rentalhive.domain.User;
import com.rentalhive.dto.request.RequestUserDto;
import com.rentalhive.dto.response.ResponseUserDto;
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
    public ResponseEntity<Response<ResponseUserDto>> save(@RequestBody @Valid RequestUserDto userDto){
        Response<ResponseUserDto> userResponse = new Response<>();
        User user = userService.save(UserDtoMapper.toEntity(userDto));
        userResponse.setResult(UserDtoMapper.toDto(user));
        userResponse.setMessage("User saved successfully");
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}
