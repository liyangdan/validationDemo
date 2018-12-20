package com.example.demo.services.api;

/**
 * @author liyangdan
 * @date 2018/12/15 1:46 PM
 */

import com.example.demo.dtotest.Car;
import com.example.demo.dto.User;
import com.example.demo.validator.constraints.CrossParameter;

import javax.validation.ConstraintTarget;
import javax.validation.Valid;

public interface RequireWriteService {

    /**
     * 创建需求单
     * @param user
     * @return
     */
    void createRequire(User user);

    /**
     * 修改需求单
     * @param user
     * @return
     */
    void updateRequire( User user);

    /**
     * 删除序曲单
     * @param user
     * @return
     */
   void deleteRequire( @Valid User user);

    /**
     * 提交需求单
     * @param user
     * @return
     */
    void submitRequire(@Valid Car user);

    /**
     * 跨参数校验
     *
     * @param oldPassWord 旧密码
     * @param newPassWord 新密码
     * @return
     */
    @CrossParameter(validationAppliesTo = ConstraintTarget.PARAMETERS)
    String changePassword(String oldPassWord, String newPassWord);
}
