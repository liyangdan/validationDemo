package com.example.demo.controller;

import com.example.demo.damain.Happiness;
import com.example.demo.dto.Car;

import com.example.demo.dto.RegisterForm;
import com.example.demo.dto.User;
import com.example.demo.services.HappinessService;
import com.example.demo.services.api.RequireWriteService;
import com.example.demo.util.ValidList;
import com.example.demo.validator.aop.Inspect;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.List;
import java.util.Locale;


/**
 * http://localhost:8080/demo/query?car=%221%22
 *
 * @author liyangdan
 * @date 2018/12/9 7:56 PM
 */

@RestController
@RequestMapping("/demo")
@Validated
public class TestController {

    @Autowired
    @Qualifier("requireWriteServiceImpl")
    private RequireWriteService requireWriteService;

    @Autowired
    @Qualifier("requireWriteServiceImpl2")
    private RequireWriteService requireWriteService2;



    @RequestMapping(value = "/query", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void testQuery(@RequestBody(required = false) @Max(value = 2,message = "最大不能超过2") String car, BindingResult bindingResult){
        if (bindingResult.hasErrors()){

        }
        System.out.println(car);
        //return happinessService.selectService("北京");
    }


    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void testInsert(@RequestBody(required = false) @Validated ValidList<User> user, BindingResult bindingResult) {
        if (bindingResult.getErrorCount() > 0) {
            // getFieldErrors() : 获取所有错误 Field
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors) {
                System.out.println(error.getDefaultMessage());
            }
        }

        System.out.println("kkk");
    }

    @Inspect
    @RequestMapping(value = "/test3", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void test3(@RequestBody(required = false) @Validated RegisterForm registerForm) {
        System.out.println("kkk");
    }

    /**
     * 测试
     *
     * @param name
     * @return
     */

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    //@Validated
    public String paramCheck( @Length(min = 3) @RequestParam String name) {

        //自定义切面
//        requireWriteService.createRequire(new User());
        //使用工具类ValidationUtil校验
        //requireWriteService.updateRequire(new User());
        //spring提供的
        requireWriteService2.deleteRequire(new User());
        requireWriteService.deleteRequire(new User());
        return null;
    }
}
