package com.example.demo.services;

import com.example.demo.dto.User;
import com.example.demo.services.api.RequireWriteService;
import com.example.demo.util.ValidationUtil;
import com.example.demo.validator.aop.Inspect;
import com.example.demo.validator.constraints.CrossParameter;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * @author liyangdan
 * @date 2018/12/16 3:55 PM
 */
@Service
public class RequireWriteServiceImpl2 implements RequireWriteService {

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
     * @param user
     * @return
     */
    @Override
    public void submitRequire( User user){

    }

    @Override
    public void changePassword(String oldPassWord, String newPassWord){

    }
}
