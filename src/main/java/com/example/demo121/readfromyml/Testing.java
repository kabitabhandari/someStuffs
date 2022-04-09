package com.example.demo121.readfromyml;

import com.example.demo121.readfromyml.CommonConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Testing {
    @Autowired
    private CommonConfigurationProperties commonConfigurationProperties;

    @PostConstruct
    public void init() {
        System.out.println(commonConfigurationProperties);
        String s2 = commonConfigurationProperties.getBest_food();
        String s1 = commonConfigurationProperties.getBestdrink();
        String s3 = commonConfigurationProperties.getBestAcharPickle();
        String s4 = commonConfigurationProperties.getBestcountryworld();
        String s5 = commonConfigurationProperties.getBest_color_rainbow();


        System.out.println("food : >>> " + s2) ;
        System.out.println("drink : >>> " + s1) ;
        System.out.println("achar : >>> " + s3) ;
        System.out.println("country : >>> " + s4) ;
        System.out.println("color : >>> " + s5) ;
    }
}
