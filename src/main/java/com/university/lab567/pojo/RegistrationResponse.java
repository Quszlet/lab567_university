package com.university.lab567.pojo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class RegistrationResponse {
    private final boolean success;
    private final String message;
}
