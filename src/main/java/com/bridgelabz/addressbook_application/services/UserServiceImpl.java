package com.bridgelabz.addressbook_application.services;
import com.bridgelabz.addressbook_application.dto.UserDto;
import com.bridgelabz.addressbook_application.entities.Users;
import com.bridgelabz.addressbook_application.repositary.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements IEService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public String CreateUser(Users users) {
        userRepo.save(users);
        return "Employee Created in DataBase";
    }

    @Override
    public UserDto UpdateUser(UserDto userDto, Integer userId) {
        Users users = this.userRepo.findById(userId).orElse(null);
        users.setFirstName(userDto.getFirstName());
//        users.setLastName(userDto.getLastName());
        users.setEmail(userDto.getEmail());
        users.setPhoneNumber(userDto.getPhoneNumber());
        Users updateUsers = this.userRepo.save(users);
        UserDto userDto1 = this.userToDto(updateUsers);
        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        Users users = this.userRepo.findById(userId).orElse(null);
//        UserDto userDto= this.userToDto(users);
        return this.userToDto(users);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<Users> users = this.userRepo.findAll();
        List<UserDto> usersDtos=  users.stream().map(this::userToDto).collect(Collectors.toList());
        return usersDtos ;
    }

    @Override
    public String deletesUser(Integer userId) {
            userRepo.deleteById(userId);
            return "Employee Deleted Successfully";
    }

    private Users dtoToUser(UserDto userDto) {
        Users users = new Users();
        users.setId(userDto.getId());
        users.setFirstName(userDto.getFirstName());
//        users.setLastName(userDto.getLastName());
        users.setEmail(userDto.getEmail());
        users.setPhoneNumber(userDto.getPhoneNumber());
        return users;
    }

//    private UserDto userToDto(Users users) {
//        UserDto usersDto = new UserDto();
//        usersDto.setId(users.getId());
//        usersDto.setFirstName(users.getFirstName());
//        usersDto.setLastName(users.getLastName());
//        usersDto.setEmail(users.getEmail());
//        usersDto.setPhoneNumber(users.getPhoneNumber());
//        return usersDto;
//    }
    private UserDto userToDto(Users users) {
        UserDto usersDto = new UserDto();
        usersDto = modelMapper.map(users, UserDto.class);
        return usersDto;
    }
}
