package com.example.demo.services;

import com.example.demo.dto.User;
import com.example.demo.services.api.RequireWriteService;
import com.example.demo.util.ValidationUtil;
import com.example.demo.validator.aop.Inspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;


/**
 * @author liyangdan
 * @date 2018/12/15 1:49 PM
 */

@Validated //告诉MethodValidationPostProcessor此Bean需要开启方法级别验证支持
@Service
public class RequireWriteServiceImpl implements RequireWriteService {


    @Override
    @Inspect
    public void createRequire(@Validated User user) {

        System.out.println("method_createRequire");
    }

    /**
     * 修改需求单
     * @param user
     * @return
     */
    @Override
    public void updateRequire(User user){
        ValidationUtil.validate(user);
    }

    /**
     * 删除序曲单
     * @param user
     * @return
     */

    @Override
    public void deleteRequire(@Valid User user){

        System.out.println("method_deleteRequire");
    }

    /**
     * 提交需求单
     * @param user
     * @return
     */
    @Override
    public void submitRequire( User user){

    }
}
