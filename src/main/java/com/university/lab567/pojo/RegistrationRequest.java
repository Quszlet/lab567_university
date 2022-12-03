package com.university.lab567.pojo;

import com.university.lab567.model.Role;
import com.university.lab567.model.Status;
import com.university.lab567.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {
    @NotEmpty(message = "Пустой логин")
    @Pattern(regexp = "^[0-9A-Za-z]{5,20}$", message = "От 5 до 20 символов, только латинские буквы, цифры и _")
    private String login;
    @NotEmpty(message = "Пустой email")
    @Email(message = "Недопустимый email адрес")
    private String email;
    @NotEmpty(message = "Пустое имя пользователя")
    private String first_name;
    @NotEmpty(message = "Пустая фамиля пользователя")
    private String last_name;
    @NotEmpty(message = "Пустой пароль")
    private String password;
    private Role role;
    private Status status;
    private int loginCount;


    public User generateUser(){
        return new User(null, login, email, first_name, last_name, password, role, status, loginCount);
    }
}
