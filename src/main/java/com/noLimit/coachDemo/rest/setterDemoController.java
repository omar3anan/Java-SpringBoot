package com.noLimit.coachDemo.rest;

import com.noLimit.coachDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class setterDemoController {
    private Coach anee;

    //Setter Injection ==> OPTIONAL Dependencies
    @Autowired
    public void setCoach(@Qualifier("basketballCoach") Coach theCoach){
        anee=theCoach;
        System.out.println("In Constructor" + getClass().getSimpleName());
    }

    //Primary
//    @Autowired
//    public void setCoach(Coach theCoach){
//        anee=theCoach;
//    }
    @GetMapping ("/setter")
    public String getDailyWorkout(){
        return anee.getDailyWorkout();

    }


}
