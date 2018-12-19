package com.example.demo.validator.constarintvalidation;

import com.example.demo.dto.RegisterForm;
import com.example.demo.validator.constraints.PasswordEquals;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author liyangdan
 * @date 2018/12/15 3:10 PM
 */

public class PasswordEqualsValidator implements ConstraintValidator<PasswordEquals, RegisterForm> {

    @Override
    public void initialize(PasswordEquals anno)
    {


    }



    @Override
    public boolean isValid(RegisterForm form, ConstraintValidatorContext context)
    { String passwordConfirm = form.getPasswordConfirm();
        String password = form.getPassword();
        boolean match = passwordConfirm != null ? passwordConfirm.equals(password) : false;
        if (match) {
            return true;
        }
        String messageTemplate = context.getDefaultConstraintMessageTemplate();



    // disable default violation rule
        context.disableDefaultConstraintViolation();

    // assign error on password Confirm field

        context.buildConstraintViolationWithTemplate(messageTemplate).addPropertyNode("passwordConfirm")
                .addConstraintViolation();
        return false;
    }
}
