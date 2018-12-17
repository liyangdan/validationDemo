package com.example.demo.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * @author liyangdan
 * @date 2018/12/15 3:10 PM
 */
@Data
public class RegisterForm {

    @NotEmpty
    @Length(min = 5, max = 30,message = "{name.size}")
    private
    String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String passwordConfirm;
}
