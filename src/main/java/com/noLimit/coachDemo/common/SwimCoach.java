package com.noLimit.coachDemo.common;
//NO USE FOR @COMPONENT
//instead use @BEAN in SportConfig
public class SwimCoach implements Coach{
    public SwimCoach(){
        System.out.println("IN "+getClass().getSimpleName()+" Constructor");
    }
    @Override
    public String getDailyWorkout() {
        return "SWIM 1000 KM";
    }
}
