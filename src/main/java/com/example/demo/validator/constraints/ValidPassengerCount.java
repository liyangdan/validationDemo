package com.example.demo.validator.constraints;

import com.example.demo.validator.constarintvalidation.ValidPassengerCountValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author liyangdan
 * @date 2018/12/9 8:55 PM
 */
@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { ValidPassengerCountValidator.class })
@Documented
public @interface ValidPassengerCount {

    String message() default "参数校验失败";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}