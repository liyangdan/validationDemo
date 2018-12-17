package com.example.demo.dto;

import com.example.demo.validator.constraints.Forbidden;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author liyangdan
 * @date 2018/12/9 9:50 PM
 */
@Data
public class User {
    @Size(min = 2, max = 10,message = "{name.size}")
//    @Length(max = 3,message = "{name.length}")
    @NotNull
    String name;

    @Max(value = 150, message = "{age.no.more.than}")
    String age;


}