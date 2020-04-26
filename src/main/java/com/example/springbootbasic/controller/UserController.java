package com.example.springbootbasic.controller;

import com.example.springbootbasic.config.RoleComponent;
import com.example.springbootbasic.entity.User;
import com.example.springbootbasic.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserRepository userRepository;
    private final RoleComponent roleComponent;

    public UserController(UserRepository userRepository, RoleComponent roleComponent) {
        this.userRepository = userRepository;
        this.roleComponent = roleComponent;
    }

    @GetMapping("/findEmail/{email}")
    public User findEmail(@PathVariable String email) {
        System.out.println("findEmail " + email);
        return userRepository.findByEmail(email);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/roles/{role}")
    public void getRoles(@PathVariable String role) {
        HashMap<String, Integer> roles = roleComponent.getMap();
//        roles.forEach((k,v) -> {
//            if(k.equals("bcbd"))
//                System.out.println(v);
//        });
        roles.entrySet().stream().filter(s -> s.getKey().equals(role)).map(Map.Entry::getValue).forEach(b -> System.out.println(b));
        OptionalInt optionalInt = roles.entrySet().stream().filter(s -> s.getKey().equals(role)).map(Map.Entry::getValue).mapToInt(Integer::new).findFirst();
        System.out.println("a " + optionalInt.getAsInt());

        HashMap<Integer, String> noweMapy = roleComponent.getNowemapy();
        String wartosc = noweMapy.entrySet().stream().filter(k -> k.getKey().equals(2)).map(Map.Entry::getValue).collect(Collectors.joining());
        System.out.println("wartosc " + wartosc);
//        roles.forEach((k,v) -> System.out.println("k " + k + " v " + v));
    }
}
