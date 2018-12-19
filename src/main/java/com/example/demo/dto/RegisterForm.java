package com.example.demo.dto;

import com.example.demo.validator.constraints.PasswordEquals;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author liyangdan
 * @date 2018/12/15 3:10 PM
 */
@Data
@PasswordEquals//校验对象
public class RegisterForm {

    @NotEmpty
    @Length(min = 3, max = 30,message = "{name.size}")
    private
    String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String passwordConfirm;

    @Min(5)
    @Max(99)
    private int age;

    @Email
    private String email;
}
