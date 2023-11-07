package com.noLimit.coachDemo.config;

import com.noLimit.coachDemo.common.Coach;
import com.noLimit.coachDemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//instead of @Component
@Configuration
public class SportConfig {
    //give if for the bean name
    @Bean("swimcoachID")  //inject the bean with the name swimCoach
    //public return_dataType
    public Coach swimCoach(){
        return new SwimCoach();
    }

}

//Diffrenece between Componen and bean ?
    //bean can be external component as AWAZON-S3
