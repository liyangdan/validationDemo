package com.example.demo.dto;

import javax.validation.constraints.NotNull;

/**
 * @author liyangdan
 * @date 2018/12/16 8:22 PM
 */

public class Address {
    @NotNull(message = "城市不能为空!")
    private String city;
    public String getCity() { return city;
    }
    public void setCity(String city) { this.city = city;
    } }

