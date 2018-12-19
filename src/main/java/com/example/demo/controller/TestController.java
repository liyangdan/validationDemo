package com.example.demo.controller;

import com.example.demo.dto.*;

import com.example.demo.services.api.RequireWriteService;
import com.example.demo.util.ValidList;
import com.example.demo.validator.aop.Inspect;

import com.example.demo.validator.constraints.ZcyValidated;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


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
    public void testQuery(@RequestBody(required = false) @Validated Car car, BindingResult bindingResult){
        if (bindingResult.hasErrors()){

        }
        System.out.println(car);
        //return happinessService.selectService("北京");
    }

    /**
     * 只有开启了MethodValidationPostProcessor，才会在方法参数上校验
     * 否则spring默认的只是拦截
     *
     * @param user
     * @param bindingResult
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void testInsert(@RequestBody(required = false)  List<@Valid User> user, BindingResult bindingResult) {
        if (bindingResult.getErrorCount() > 0) {
            // getFieldErrors() : 获取所有错误 Field
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors) {
                System.out.println(error.getDefaultMessage());
            }
        }

        System.out.println("kkk");
    }

    @RequestMapping(value = "/insert2", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void testInsert2(@RequestBody(required = false)  @Validated ValidList<User> user, BindingResult bindingResult) {
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
    public void test3(@RequestBody(required = false) @ZcyValidated RegisterForm registerForm) {
        System.out.println("kkk");
    }


    /**
     * 校验对象存在继承,这样在对类 Dog 的实例进行验证的时候，如果使用默认的组别（Default.class），
     * 则 name，ownername 和 type 都将进行验证；
     * 如果使用 Animal 的组别，则只会对 name 和 ownername 属性进行验证。
     *
     * @param dog
     * @param bindingResult
     */
    @RequestMapping(value = "/test4", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void test4(@RequestBody(required = false) @Validated Dog dog, BindingResult bindingResult) {
        if (bindingResult.getErrorCount() > 0) {
            // getFieldErrors() : 获取所有错误 Field
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors) {
                System.out.println(error.getDefaultMessage());
            }
        }
        //System.out.println("method_test4");
    }


    /**
     * 方法级别的校验
     *
     * @param name
     * @return
     */

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    //@Validated
    public String paramCheck( @Length(min = 3, max = 5) @RequestParam String name) {

        //自定义切面
        //requireWriteService.createRequire(new User());
        //使用工具类ValidationUtil校验
        //requireWriteService.updateRequire(new User());
        //spring提供的
        User user = new User();
        user.setName("1999999999");
      //  requireWriteService2.deleteRequire(new User();
       //requireWriteService.deleteRequire(user);
        requireWriteService.submitRequire(user);
        return null;
    }

    /**
     * 跨参数校验
     *
     * @param oldPassWord
     * @param newPassWord
     * @return
     */
    @RequestMapping("/test5")
    public void  changePassword(
            @RequestParam("oldPassWord") String oldPassWord,
            @RequestParam("newPassWord") String newPassWord) {
        requireWriteService.changePassword(oldPassWord, newPassWord);
        System.out.println("test5 success");
    }
}
