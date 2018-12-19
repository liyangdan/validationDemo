package com.example.demo.validator.constraints;

import java.lang.annotation.*;

/**
 * @author liyangdan
 * @date 2018/12/18 9:44 PM
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ZcyValidated {
    Class<?>[] value() default {};
}
