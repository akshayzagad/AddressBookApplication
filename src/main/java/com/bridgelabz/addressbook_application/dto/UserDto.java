package com.bridgelabz.addressbook_application.dto;

import lombok.Data;

public @Data class UserDto {
    private int id;
    private String firstName;
//    private String LastName;
    private String phoneNumber;
    private String Email;
}
