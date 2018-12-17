package com.example.demo.validator.constarintvalidation;
import com.example.demo.validator.constraints.Forbidden;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author liyangdan
 * @date 2018/12/10 12:04 AM
 */

public class ForbiddenValidator implements ConstraintValidator<Forbidden, String> {

    private String[] forbiddenWords = {"admin"};

    @Override
    public void initialize(Forbidden constraintAnnotation) {
        //初始化，得到注解数据
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(StringUtils.isEmpty(value)) {
            return true;
        }

        for(String word : forbiddenWords) {
            if(value.contains(word)) {
                return false;//验证失败
            }
        }
        return true;
    }
}
