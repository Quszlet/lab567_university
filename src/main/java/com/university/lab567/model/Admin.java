package com.university.lab567.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Admin {
    private Long id;
    private String firstName;
    private String lastName;
}
