package com.example.demo.dto;

import com.example.demo.validator.constraints.Forbidden;
import com.example.demo.validator.groups.ValidGroups;
import com.zcy.validator.constraints.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

/**
 * @author liyangdan
 * @date 2018/12/9 9:50 PM
 */
//@GroupSequence({ ValidGroups.First.class, ValidGroups.Second.class, User.class})
@Data
public class User {
//    @Size(min = 2, max = 10,message = "{name.size}")
////    @Length(max = 3,message = "{name.length}")
    @NotNull(groups = ValidGroups.First.class)
    String name;

    @Max(value = 150, message = "{age.no.more.than}")
    String age;

    @IsMobile(groups = ValidGroups.Second.class)
    String phoneNumber;


}