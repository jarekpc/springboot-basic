package com.example.springbootbasic.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "roles")
@Data
public class RoleComponent {

//    @Value("${input.name}")
//    private String name;
//
//    @Value("${input.age}")
//    private Integer age;

    private HashMap<String, Integer> map;

    private HashMap<Integer, String> nowemapy;

}
