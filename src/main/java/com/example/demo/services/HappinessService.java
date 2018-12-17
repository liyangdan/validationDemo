package com.example.demo.services;

import com.example.demo.damain.Happiness;
import com.example.demo.dao.HappinessDao;
import com.example.demo.dto.Car;
import com.example.demo.dto.User;
import com.example.demo.services.api.RequireWriteService;
import com.example.demo.validator.constraints.Forbidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liyangdan
 * @date 2018/12/9 7:59 PM
 */

@Service
public class HappinessService {
    @Autowired
    private HappinessDao happinessDao;

    @Autowired
    @Qualifier("requireWriteServiceImpl")
    RequireWriteService requireWriteService;

    public Happiness selectService(String city){
        return happinessDao.findHappinessByCity(city);
    }

    @Transactional
    public void insertService(){
        happinessDao.insertHappiness("西安", 9421);
        int a = 1 / 0; //模拟故障
        happinessDao.insertHappiness("长安", 1294);
    }

    public static void main(String[] args) {
        RequireWriteServiceImpl requireWriteService  = new RequireWriteServiceImpl();
        requireWriteService.deleteRequire(new User());
        System.out.println("直接调用测试");
    }
}
