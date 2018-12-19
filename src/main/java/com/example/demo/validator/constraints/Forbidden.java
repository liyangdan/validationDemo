package com.example.demo.validator.constraints;
import com.example.demo.validator.constarintvalidation.ForbiddenValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author liyangdan
 * @date 2018/12/10 12:04 AM
 */
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
//指定验证器
@Constraint(validatedBy = {ForbiddenValidator.class})
@Documented
public @interface Forbidden {

    String[] keyWord() default {};
    //默认错误消息
    String message() default "{forbidden.word}";

    //分组
    Class<?>[] groups() default { };

    //负载
    Class<? extends Payload>[] payload() default { };

    //指定多个时使用
    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        Forbidden[] value();
    }
}