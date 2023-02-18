package com.bridgelabz.addressbook_application.repositary;

import com.bridgelabz.addressbook_application.entities.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {


}
