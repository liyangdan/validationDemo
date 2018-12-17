package com.example.demo.validator.aop;

import java.lang.annotation.*;

/**
 * @author liyangdan
 * @date 2018/12/9 8:33 PM
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.METHOD})
public @interface Inspect {

}
