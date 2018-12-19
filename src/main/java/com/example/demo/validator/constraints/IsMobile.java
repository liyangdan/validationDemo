package com.example.demo.validator.constraints;

//import com.example.demo.validator.constarintvalidation.IsMobileValiadator;

import com.example.demo.validator.constarintvalidation.IsMobileValiadator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 约束注解
 *
 * @author liyangdan
 * @date 2018/12/4 9:20 PM
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER}) //表示@IsMobile 可以被用在方法, 字段或者annotation声明上.
@Retention(RUNTIME) ////表示这个标注信息是在运行期通过反射被读取的.
@Documented // 表示在对使用了@IsMobile的类进行javadoc操作到时候, 这个标注会被添加到javadoc当中.
@Constraint(validatedBy = {IsMobileValiadator.class}) //指明使用那个校验器(类) 去校验使用了此标注的元素.

public @interface IsMobile {

    //true:参数必须有,进行格式校验      false:参数可以为空,不为空时也要进行进行格式校验
    boolean requried() default true; //这个可有可无
    //提示信息
    String message() default "手机号码格式错误";//通过注解后输出的信息,可以自定义
    Class<?>[] groups() default{};
    Class<?extends Payload>[] payload() default{};//有效负载
}
