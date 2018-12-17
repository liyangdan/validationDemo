package com.example.demo;

import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author liyangdan
 */
@SpringBootApplication
public class DemoApplication {
    /**
     * 方法级别参数校验
     *
     * @return
     */
//    @Bean
//    public MethodValidationPostProcessor methodValidationPostProcessor() {
//        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
//        /**设置validator模式为快速失败返回*/
//        postProcessor.setValidator(validator());
//        return postProcessor;
//    }
//    @Bean
//    public Validator validator(){
//        ValidatorFactory validatorFactory = Validation.byProvider( HibernateValidator.class )
//                .configure()
//                .addProperty( "hibernate.validator.fail_fast", "true" )
//                .buildValidatorFactory();
//        Validator validator = validatorFactory.getValidator();
//
//        return validator;
//    }

//    @Bean
//    public MethodValidationPostProcessor methodValidationPostProcessor() {
//        /**默认是普通模式，会返回所有的验证不通过信息集合*/
//        return new MethodValidationPostProcessor();
//    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
