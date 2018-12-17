package com.example.demo.dto;

import com.example.demo.validator.constraints.ValidPassengerCount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author liyangdan
 * @date 2018/12/9 8:58 PM
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ValidPassengerCount
public class Car {
    private String manufacturer;

    private String licensePlate;

    private int seatCount;

    private List<String> passengers;

}

