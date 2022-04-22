package com.example.demo121.readfromyml;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class Testing {
    private final CommonConfigurationProperties commonConfigurationProperties;

    public Testing(CommonConfigurationProperties commonConfigurationProperties) {
        this.commonConfigurationProperties = commonConfigurationProperties;
    }

    @Bean
    public void init123() {
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
