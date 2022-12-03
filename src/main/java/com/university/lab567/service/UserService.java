package com.university.lab567.service;

import com.university.lab567.exception.UserAlreadyExistException;
import com.university.lab567.model.User;
import com.university.lab567.pojo.RegistrationRequest;
import com.university.lab567.pojo.RegistrationResponse;
import com.university.lab567.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import java.util.Optional;

@Validated
@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RegistrationResponse registration(@NonNull @Valid RegistrationRequest request) throws UserAlreadyExistException {
        if (userRepository.findByLogin(request.getLogin()).isPresent()){
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        User user = request.generateUser();
        user.setPassword(passwordEncode(user.getPassword()));
        userRepository.save(user);
        return new RegistrationResponse(true, "");
    }

    public String passwordEncode(String password){
        return new BCryptPasswordEncoder(12).encode(password);
    }

    public Integer loginCount(){
        final String currentLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepository.findByLogin(currentLogin);
        return user.get().getCount();
    }
}
