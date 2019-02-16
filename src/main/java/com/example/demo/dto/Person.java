package com.example.demo.dto;

import org.springframework.stereotype.Service;

/**
 * @author liyangdan
 * @date 2018/12/30 11:32 AM
 */
public class Person {
    static int count=0;
    public void drive() {

        System.out.println("开QQ车"+(count++)+"次数");
    }
}
