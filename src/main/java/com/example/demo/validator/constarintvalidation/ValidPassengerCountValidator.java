package com.example.demo.validator.constarintvalidation;

import com.example.demo.dto.Car;
import com.example.demo.validator.constraints.ValidPassengerCount;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;

/**
 * @author liyangdan
 * @date 2018/12/9 8:57 PM
 */

public class ValidPassengerCountValidator
        implements ConstraintValidator<ValidPassengerCount, Car> {

    @Override
    public void initialize(ValidPassengerCount constraintAnnotation) {
    }

    @Override
    public boolean isValid(Car car, ConstraintValidatorContext constraintValidatorContext) {
        if ( car == null ) {
            return true;
        }
        car.setPassengers(new ArrayList<>());
        boolean isValid = car.getPassengers().size() >= car.getSeatCount();

        if ( !isValid ) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate( "参数校验失败" )
                    .addPropertyNode( "passengers" ).addConstraintViolation();
        }
        if (car.getLicensePlate()==null) {
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate( "参数校验失败" )
                    .addPropertyNode( "seatCount" ).addConstraintViolation();
        }

        return isValid;
    }
}

