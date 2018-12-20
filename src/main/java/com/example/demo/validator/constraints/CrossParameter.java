package com.example.demo.validator.constraints;

import com.example.demo.validator.constarintvalidation.CrossObjectValidator;
import com.example.demo.validator.constarintvalidation.CrossParameterValidator;

import javax.validation.Constraint;
import javax.validation.ConstraintTarget;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author liyangdan
 * @date 2018/12/19 9:20 PM
 */
@Constraint(validatedBy = {CrossParameterValidator.class, CrossObjectValidator.class})
@Target({ TYPE, FIELD, PARAMETER, METHOD, CONSTRUCTOR, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface CrossParameter {

    String message() default "{password.confirmation.error}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    ConstraintTarget validationAppliesTo() default ConstraintTarget.IMPLICIT;

}
