package com.example.demo.dto;

import com.example.demo.validator.groups.ValidGroups;

import javax.validation.constraints.NotEmpty;

/**
 * @author liyangdan
 * @date 2018/12/19 11:39 AM
 */

public class Dog implements Animal{
    private String name;
    private String ownername;

    private String type;

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getOwnerName() {
        return null;
    }

    @NotEmpty(message = "type of the dog may be empty", groups = ValidGroups.First.class)
    public String getType() {
        return type;
    }
}
