package com.noLimit.coachDemo.common;
import org.springframework.stereotype.Component;

//@Component ==> Dependency injection (SPRING BEAN)
@Component  //take input as ___.getDailyWorkout()
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("In Constructor" + getClass().getSimpleName());
    }
    @Override //override from interface
    public String getDailyWorkout(){
        return "RUN YO ASS FAT from CRICKET";
    }


}
