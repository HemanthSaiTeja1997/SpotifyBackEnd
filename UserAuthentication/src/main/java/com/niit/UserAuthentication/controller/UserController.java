package com.niit.UserAuthentication.controller;

import com.niit.UserAuthentication.domain.UserModel;
import com.niit.UserAuthentication.exception.UserAlreadyExistException;
import com.niit.UserAuthentication.exception.UserNotFoundException;
import com.niit.UserAuthentication.service.SecurityTokenGenerator;
import com.niit.UserAuthentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/api/v2")
public class UserController
{
    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService , SecurityTokenGenerator securityTokenGenerator)
    {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }


    @PostMapping("/register")
    public ResponseEntity<?>  saveUser(@RequestBody UserModel userModel) throws UserAlreadyExistException {
        return  new ResponseEntity<>(userService.addUser(userModel), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody UserModel user ) throws UserNotFoundException {
        Map<String, String> map = null;
        try{
            UserModel result = userService.loginCheck(user.getEmail(),user.getPassword());
            if(result.getEmail().equals(user.getEmail())) {
                map = securityTokenGenerator.generateToken(result);
            }
            return new ResponseEntity<>(map,HttpStatus.OK);
        }
        catch(UserNotFoundException ex){
            throw new UserNotFoundException();
        }
        catch(Exception ex){
            return new ResponseEntity<>("Other exception",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



    }
