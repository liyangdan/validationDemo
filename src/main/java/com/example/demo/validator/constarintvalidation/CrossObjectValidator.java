package com.example.demo.validator.constarintvalidation;

import com.example.demo.validator.constraints.CrossParameter;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

/**
 * @author liyangdan
 * @date 2018/12/20 12:09 AM
 */

public class CrossObjectValidator implements ConstraintValidator<CrossParameter, String> {
    @Override
    public void initialize(CrossParameter constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.length()<5) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("校验方法返回值")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
