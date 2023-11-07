package com.noLimit.coachDemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component //==> THIS IS A SPRING BEAN
public class BeanLifecycle implements Coach{
    public BeanLifecycle(){
        System.out.println("In " + getClass().getSimpleName()+" Constructor");
    }

    @PostConstruct //when i start to run my app
    public void doMyStartupStuff(){
        System.out.println("In " + getClass().getSimpleName()+" doMyStartupStuff");
    }
    @PreDestroy //after stop or KILL app
    public void doMyCleanupStuff(){
        System.out.println("In " + getClass().getSimpleName()+" doMyCleanupStuff");
    }

    @Override
    public String getDailyWorkout(){
        return "BeanLifecycle";
    }
}
