package com.example.demo.validator;

import com.example.demo.dto.Person;
import com.example.demo.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liyangdan
 * @date 2018/12/30 11:41 AM
 */
@Configuration
public class PersonConfig {

    @Bean
    public Person getPerson(){
        System.out.println("方法调用");
        return new Person();
    }

    @Bean
    public User getUser(){
        return new User(getPerson());
    }
}
