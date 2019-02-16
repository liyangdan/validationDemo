package com.example.demo.services;


import com.example.demo.dtotest.Car;
import com.example.demo.dto.User;
import com.example.demo.services.api.RequireWriteService;
import com.example.demo.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.Validator;

/**
 * @author liyangdan
 * @date 2018/12/16 3:55 PM
 */
@Validated
@Service
public class RequireWriteServiceImpl2 implements RequireWriteService {

    @Autowired
    private Validator validator;

    @Autowired
    private ValidateParamService validateParamService;

    @Override
    public void createRequire(User user) {

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
    public void deleteRequire(User user){

        System.out.println("test : method_deleteRequire");
    }

    /**
     * 提交需求单
     * @param car
     * @return
     */
    @Override
    public void submitRequire( @Valid Car car){

        System.out.println("test5 success");


    }

    @Override
    public String changePassword(String oldPassWord, String newPassWord){
        validateParamService.getString();
        System.out.println("test测试");
        return "123";
    }
}
