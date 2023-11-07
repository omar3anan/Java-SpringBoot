package com.noLimit.coachDemo.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//change scope from Singleton to prototype
@Scope("prototype")
public class TennisCoach implements Coach{
    public TennisCoach(){
        System.out.println("In Constructor" + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout(){
        return "TENNIS SAY RUN";
    }
}
