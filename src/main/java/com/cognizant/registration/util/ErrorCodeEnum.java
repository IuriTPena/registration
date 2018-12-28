package com.cognizant.registration.util;

public enum ErrorCodeEnum {
    SUCCESS("Successfully inserted into USER."),
    USER_ALREADY_EXISTS("User already exists, try a different email.");

    private String value;

    ErrorCodeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
