package com.example.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * @author liyangdan
 * @date 2018/12/13 9:17 PM
 */
@RestControllerAdvice
@Slf4j
@Component
public class GlobalExceptionHandler {

    /**
     * 拦截所有的异常
     *
     * @param e 异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public void handleValidationException(ConstraintViolationException e){
        for(ConstraintViolation<?> s:e.getConstraintViolations()){
           // return s.getInvalidValue()+": "+s.getMessage();
            String message = ((ConstraintViolationException) e).getConstraintViolations().iterator().next().getMessage();

            System.out.println(message);
        }
        //return "请求参数不合法";
    }


    /**
     * 拦截所有异常
     *
     * @param e 异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public void logicExceptionHandler(Exception e) {

        //如果是业务逻辑异常，返回具体的错误码与提示信息
        if (e instanceof ServiceResponseException) {
            ServiceResponseException logicException = (ServiceResponseException) e;

            //Validator验证框架抛出的业务逻辑异常
        } else if (e instanceof ConstraintViolationException) {
            String message = ((ConstraintViolationException) e).getConstraintViolations().iterator().next().getMessage();

        } else {
            //对系统级异常进行日志记录
            log.error("系统异常:" + e.getMessage(), e);
        }
        return ;
    }
}
