package com.bridgelabz.addressbook_application.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@jakarta.persistence.Entity
@NoArgsConstructor
@Table(name = "users")
public @Data class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String LastName;
    private String phoneNumber;
    private String Email;
}
