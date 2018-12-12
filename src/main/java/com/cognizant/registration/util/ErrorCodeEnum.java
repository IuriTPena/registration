package com.cognizant.registration.util;

public enum ErrorCodeEnum {
    SUCCESS("Success"),
    USER_ALREADY_EXISTS("User_Already_Exists");

    private String value;

    ErrorCodeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
