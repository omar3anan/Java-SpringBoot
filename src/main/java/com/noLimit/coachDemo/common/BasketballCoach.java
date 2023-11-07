package com.noLimit.coachDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Lazy  //==> you can call me only when you need me
//@Primary

public class BasketballCoach implements Coach{

    //getClass() > build in function ba2olo hat el class el ana wa2ef 3leh
    public BasketballCoach(){
        System.out.println("In Constructor" + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout(){
        return "BASKET BALL SAY RUNNNNN";
    }

}
