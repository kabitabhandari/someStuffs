package com.example.demo121.readfromyml;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties(prefix = "kabita.common")
@Data
public class CommonConfigurationProperties{
// map from application.yml kabita.common (format : smallcase, hi-phen, snakecase)
private String best_food;
    private String bestdrink;
    private String bestAcharPickle;
    private String bestcountryworld;
    private String best_color_rainbow;

}
