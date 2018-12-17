package com.example.demo.validator.aop;

import com.example.demo.exception.ServiceResponseException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.aspectj.lang.reflect.MethodSignature;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author liyangdan
 * @date 2018/12/9 8:33 PM
 */
@Aspect
@Component
@Slf4j
public class ValidatorAspect {
    static int count;

    @Autowired
    private Validator validator;

//    /**
//     *  定义拦截规则：拦截  com.service  包下面的所有类中，。
//     */
//    @Pointcut(value = "execution(public * cn.gov.zcy.athena.controller.*.*(..))")
//    public void controllerMethodPointcut() {
//        // Do nothing just pointcut
//    }
//
//    //@Around(value = "@annotation(cn.gov.zcy.athena.common.aop.Inspect)", argNames = "joinPoint")
//    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        BindingResult result = null;
//        Object[] args = joinPoint.getArgs();
//        if (args != null && args.length != 0) {
//            for (Object object : args) {
//                if (object instanceof BindingResult) {
//                    result = (BindingResult) object;
//                    break;
//                }
//            }
//        }
//        if (result != null && result.hasErrors()) {
//            FieldError fieldError = result.getFieldError();
//            log.info("参数验证失败.控制器:{}, 方法:{}, 属性:{}, 错误编码:{} >>> 消息:{}", joinPoint.getTarget().getClass().getSimpleName(), joinPoint.getSignature().getName(), fieldError.getField(), fieldError.getCode(),fieldError.getDefaultMessage());
//
//            throw new ServiceResponseException(fieldError.getDefaultMessage());
//        }
//        return true;
//    }
//
//    /**
//     * 拦截器具体实现
//     * 指定拦截器规则；也可以直接把 “execution(.........)” 写进这里
//     */
//    //@Around("controllerMethodPointcut()")
//    @Before(value = "@annotation(cn.gov.zcy.athena.common.aop.Inspect)", argNames = "pjp")
//    public Object Interceptor(JoinPoint pjp) {
//        //返回目标方法的签名
//        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
//        //获取方法
//        Method method = methodSignature.getMethod();
//        //获取注解
//        Annotation[][] argAnnotations = method.getParameterAnnotations();
//        //返回目标方法的签名
//        Object[] args = pjp.getArgs();
//
//        for (int i = 0; i < args.length; i++) {
//            for (Annotation annotation : argAnnotations[i]) {
//                if (Validated.class.isInstance(annotation)) {
//                    Validated validated = (Validated) annotation;
//                    Class<?>[] groups = validated.value();
//                    this.validAndReturnFirstErrorTips(pjp, args[i], groups);
//                }
//            }
//        }
////        try {
////            return
////        } catch (Throwable throwable) {
////            throwable.printStackTrace();
////        }
//        return true;
//    }
//
//    /**
//     * 校验参数，并返回第一个错误提示(ValidatorAspect切面调用)
//     *
//     * @param t   验证的对象
//     * @param groups 验证的组别
//     * @param <T>  对象擦除前原类型
//     * @return 第一个错误提示
//     */
//    private <T> void validAndReturnFirstErrorTips(JoinPoint pjp, T t, Class<?>... groups) {
//        Set<ConstraintViolation<T>> validate = validator.validate(t, groups);
//        if (validate.size() > 0) {
//            ConstraintViolation<T> next = validate.iterator().next();
//            //你就可以通过调用ConstraintViolation.getConstraintDescriptor().getPayload()来得到之前指定到错误级别了,
//            // 并且可以根据这个信息来决定接下来到行为.
//            //next.getConstraintDescriptor().getPayload();
//            log.error("业务出错的方法定义:{}, object: {}, field: {}, 入参：{}",pjp.toLongString(),
//                    next.getRootBeanClass().getName(), next.getPropertyPath(), next.getLeafBean());
//            throw new ServiceResponseException(next.getMessage());
//        }
//    }


    /**
     * 拦截器具体实现
     * 指定拦截器规则；也可以直接把 “execution(.........)” 写进这里
     */
    //@Around("controllerMethodPointcut()")
    @Around(value = "@annotation(com.example.demo.validator.aop.Inspect)", argNames = "pjp")
    public Object Interceptor(ProceedingJoinPoint pjp) {
        //返回目标方法的签名
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        //获取方法
        Method method = methodSignature.getMethod();
        //获取注解
        Annotation[][] argAnnotations = method.getParameterAnnotations();
        //返回目标方法的签名
        Object[] args = pjp.getArgs();

        for (int i = 0; i < args.length; i++) {
            for (Annotation annotation : argAnnotations[i]) {
                if (Validated.class.isInstance(annotation)) {
                    Validated validated = (Validated) annotation;
                    Class<?>[] groups = validated.value();
                    this.validAndReturnFirstErrorTips(pjp, args[i], groups);
                }
            }
        }
        try {
            return pjp.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return true;
    }

    /**
     * 校验参数，并返回第一个错误提示(ValidatorAspect切面调用)
     *
     * @param t   验证的对象
     * @param groups 验证的组别
     * @param <T>  对象擦除前原类型
     * @return 第一个错误提示
     */
    private <T> void validAndReturnFirstErrorTips(ProceedingJoinPoint pjp, T t, Class<?>... groups) {
        Set<ConstraintViolation<T>> validate = validator.validate(t, groups);
        if (validate.size() > 0) {
            ConstraintViolation<T> next = validate.iterator().next();
            //你就可以通过调用ConstraintViolation.getConstraintDescriptor().getPayload()来得到之前指定到错误级别了,
            // 并且可以根据这个信息来决定接下来到行为.
            //next.getConstraintDescriptor().getPayload();
            log.error("业务出错的方法定义:{}, 对象: {}, 字段: {}, 入参：{}",pjp.toLongString(),
                    next.getRootBeanClass().getName(), next.getPropertyPath(), next.getLeafBean());
            //throw new ServiceResponseException(next.getMessage());
            throw new ServiceResponseException("service层参数异常");
        }
    }




}



