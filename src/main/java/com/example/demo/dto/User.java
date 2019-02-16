package com.example.demo.dto;

import com.example.demo.validator.constraints.Forbidden;
import com.example.demo.validator.groups.ValidGroups;
import com.zcy.validator.constraints.IsMobile;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

/**
 * @author liyangdan
 * @date 2018/12/9 9:50 PM
 */
//@GroupSequence({ ValidGroups.First.class, ValidGroups.Second.class, User.class})
@Data
@NoArgsConstructor
public class User {

    public User(Person person){
        System.out.println(person.hashCode());
    }
//    @Size(min = 2, max = 10,message = "{name.size}")
////    @Length(max = 3,message = "{name.length}")
    @NotNull(groups = ValidGroups.First.class)
        @Forbidden(fieldName = "姓名",keyWord = {"main","admin"})
    String name;

    @Max(value = 150, message = "{age.no.more.than}")
    String age;

    @IsMobile(groups = ValidGroups.Second.class)
    String phoneNumber;


//    @Pattern.List({@Pattern(regexp = RegexConstant.NOT_CONTAIN_SPECIAL_SYMBOLS, message = "{context.special.symbols}"),
//            @Pattern(regexp = RegexConstant.NON_PURE_NUMBER_PATTERN, message = "{inquiry.item.unit}")})
    @Forbidden(fieldName = "个人信息" , keyWord = {"zcy"})
    String information;


}