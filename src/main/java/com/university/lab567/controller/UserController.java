package com.university.lab567.controller;

import com.university.lab567.exception.UserAlreadyExistException;
import com.university.lab567.pojo.RegistrationRequest;
import com.university.lab567.pojo.RegistrationResponse;
import com.university.lab567.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/auth/registration",
            consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<RegistrationResponse> registration(@RequestBody RegistrationRequest request) throws
            UserAlreadyExistException{
            try{
                RegistrationResponse ds = userService.registration(request);
                return ResponseEntity.ok(ds);
            } catch (Exception e){
                return ResponseEntity.badRequest().body(new RegistrationResponse(false,  e.getMessage()));
            }
    }

    @GetMapping("/api/countLogin")
    public ResponseEntity<Integer> registratio22n(){
        Integer ds = userService.loginCount();
        return ResponseEntity.ok(ds);
    }
}
