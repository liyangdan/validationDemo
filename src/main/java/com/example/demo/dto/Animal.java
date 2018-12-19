package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;

/**
 * @author liyangdan
 * @date 2018/12/19 11:38 AM
 */
public interface Animal {
    @NotEmpty
    String getName();
    @NotEmpty
    String getOwnerName();
}
