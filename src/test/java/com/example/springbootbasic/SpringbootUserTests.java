package com.example.springbootbasic;

import com.example.springbootbasic.entity.User;
import com.example.springbootbasic.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SpringbootUserTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAllUsers(){
        List<User> userList = userRepository.findAll();
        assertNotNull(userList);
        assertEquals(2, userList.size());
    }
}
