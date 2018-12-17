package com.example.demo.validator;

/**
 * Hibernate Validator配置类
 * 需要我们声明一个Bean，注入校验器到Spring Boot的运行环境
 *
 * @author liyangdan
 * @date 2018/12/16 1:55 PM
 */

import com.example.demo.exception.ServiceResponseException;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Configuration
@EnableAutoConfiguration
public class HibernateValidatorConfiguration {

    /**
     * JSR和Hibernate validator的校验只能对Object的属性进行校验
     * 不能对单个的参数进行校验
     * spring 在此基础上进行了扩展
     * 添加了MethodValidationPostProcessor拦截器
     * 可以实现对方法参数的校验
     *
     * @return
     */
    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor processor = new MethodValidationPostProcessor();
        // 默认是普通模式，会返回所有的验证不通过信息集合
        // 这里设置validator模式为快速失败返回
        processor.setValidator(validator());
        return processor;
    }

    @Bean
    public static Validator validator() {
        return Validation
                .byProvider(HibernateValidator.class)
                .configure()
                //自定义message名称，否则只会读取默认配置下的ValidationMessage这个文件                .messageInterpolator(new ResourceBundleMessageInterpolator( new AggregateResourceBundleLocator(Arrays.asList("MyMessages1","MyMessages2","MyMessages3"))))
                .messageInterpolator(new ResourceBundleMessageInterpolator(new PlatformResourceBundleLocator("myValidationMessages" )))
                //快速返回模式，有一个验证失败立即返回错误信息
                .failFast(true)
                .buildValidatorFactory()
                .getValidator();




    }

//    public static <T> void validate(T obj) {
//        Set<ConstraintViolation<T>> constraintViolations = validator().validate(obj);
//        if (constraintViolations.size() > 0) {
//            throw new ServiceResponseException(constraintViolations.iterator().next().getMessage());
//        }
//    }
}

