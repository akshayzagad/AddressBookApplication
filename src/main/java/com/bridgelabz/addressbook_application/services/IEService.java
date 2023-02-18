package com.bridgelabz.addressbook_application.services;

import com.bridgelabz.addressbook_application.dto.UserDto;
import com.bridgelabz.addressbook_application.entities.Users;

import java.util.List;

public interface IEService {

    String CreateUser(Users user);
    UserDto UpdateUser(UserDto userDto , Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    String deletesUser (Integer userId);
}
