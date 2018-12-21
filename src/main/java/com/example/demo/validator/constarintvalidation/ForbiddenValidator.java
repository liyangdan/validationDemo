package com.example.demo.validator.constarintvalidation;
import com.example.demo.validator.constraints.Forbidden;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

/**
 * @author liyangdan
 * @date 2018/12/10 12:04 AM
 */

public class ForbiddenValidator implements ConstraintValidator<Forbidden, String> {

    private String[] forbiddenWords = null;
    private String fieldName="";

    @Override
    public void initialize(Forbidden constraintAnnotation) {
        //初始化，得到注解数据
        forbiddenWords = constraintAnnotation.keyWord();
        fieldName = constraintAnnotation.fieldName();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(StringUtils.isEmpty(value) || forbiddenWords == null) {
            return true;
        }
        HibernateConstraintValidatorContext hibernateContext = context.unwrap(
                HibernateConstraintValidatorContext.class
        );

        //使用HibernateConstraintValidatorContext#addExpressionVariable(String, Object)
        // 或通过表达式语言消息插值工具设置用于插值的任意参数
        // HibernateConstraintValidatorContext#addMessageParameter(String, Object)
        for(String word : forbiddenWords) {
            if(value.contains(word)) {
                //方法一：注入表达式变量,这个在消息取值时用${}
                hibernateContext.addExpressionVariable( "word", word );

                //方法二：注入消息参数, 这个在消息取值时用{}
                hibernateContext.addMessageParameter( "word", word );
                hibernateContext.addMessageParameter("fieldName", fieldName);
                //验证失败
                return false;
            }
        }
        return true;
    }
}
