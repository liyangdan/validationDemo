package com.example.demo.services;

import com.example.demo.validator.aop.Inspect;
import com.zcy.validator.constraints.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author liyangdan
 * @date 2018/12/20 9:22 PM
 */
@Validated
public class ValidateParamService {
    //校验参数
    public void update(@NotNull String userId,
                       @NotNull @Range(min = 0, max = 5) Integer status){
    }
    //校验构造函数
    @Inspect
    public ValidateParamService(@IsMobile String message) {
    }
    //校验返回值
    public @NotBlank(message = "不能为空的字符串")String ValidateReturn(){
        return "";
    }

    public ValidateParamService() {
    }
}
