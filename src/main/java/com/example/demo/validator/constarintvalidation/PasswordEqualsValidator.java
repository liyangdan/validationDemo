package com.example.demo.validator.constarintvalidation;

import com.example.demo.dto.RegisterForm;
import com.example.demo.validator.constraints.PasswordEquals;
import org.springframework.util.StringUtils;

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
        if(form == null) {
            return true;
        }

        //没有填密码
        if(!StringUtils.hasText(form.getPassword())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{password.null}")
                    .addPropertyNode("password")
                    .addConstraintViolation();
            return false;
        }

        if(!StringUtils.hasText(form.getPasswordConfirm())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{password.confirmation.null}")
                    .addPropertyNode("passwordConfirm")
                    .addConstraintViolation();
            return false;
        }

        //两次密码不一样
        if (!form.getPassword().trim().equals(form.getPasswordConfirm().trim())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{password.confirmation.error}")
                    .addPropertyNode("psswordConfirm")
                    .addConstraintViolation();
            return false;
        }
        return true;






//        String password = form.getPassword();
//        boolean match = passwordConfirm != null ? passwordConfirm.equals(password) : false;
//        if (match) {
//            return true;
//        }
//        String messageTemplate = context.getDefaultConstraintMessageTemplate();
//
//
//
//    // disable default violation rule
//        context.disableDefaultConstraintViolation();
//
//    // assign error on password Confirm field
//
//        context.buildConstraintViolationWithTemplate(messageTemplate).addPropertyNode("passwordConfirm")
//                .addConstraintViolation();
//        return false;
    }
}
