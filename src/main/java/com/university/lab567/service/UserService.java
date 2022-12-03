package com.university.lab567.service;

import com.university.lab567.exception.UserAlreadyExistException;
import com.university.lab567.model.User;
import com.university.lab567.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registration(User user) throws UserAlreadyExistException {
        if (userRepository.findByLogin(user.getLogin()).isPresent()){
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
        user.setPassword(passwordEncode(user.getPassword()));
        return userRepository.save(user);
    }

    public String passwordEncode(String password){
        return new BCryptPasswordEncoder(12).encode(password);
    }
}
