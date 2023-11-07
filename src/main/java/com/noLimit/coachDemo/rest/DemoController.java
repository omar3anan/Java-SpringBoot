package com.noLimit.coachDemo.rest;

import com.noLimit.coachDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach anan;  //anan object with Coach datatype INTERFACE
     private Coach anee;

                //Constructor Injection ==> Required Dependencies
    //define the constructor to pass anan as dependency
    //Bean Scope ==> Singleton (default) ==> 1 object  for all requests and will be the same
    //Bean Scope ==> Prototype ==> new object for each request and will be different
//    @Autowired
//    public DemoController(
//            @Qualifier("tennisCoach") Coach theCoach,
//            @Qualifier("tennisCoach") Coach theCoach2){
//        anee=theCoach;
//        anan=theCoach2;
//        System.out.println("In Constructor" + getClass().getSimpleName());
//    }


    @Autowired
    public DemoController(@Qualifier("swimcoachID") Coach theCoach){
        anee=theCoach;
        System.out.println("In " + getClass().getSimpleName()+"Constructor");
    }


    //primary
//    @Autowired  //Constructor
//    public DemoController( Coach theCoach){
//        anan=theCoach;
//    }


    @GetMapping("/construct")
    public String getDailyWorkout(){   //same name as interface
        return anee.getDailyWorkout();
               //interface.function

    }


    //True ==> Singleton
    //False ==> Prototype
    @GetMapping("/check")
    public String check(){
        return "Comparing Beans "+(anan ==anee);
    }


}


//@Qualfier ==> badelo esm el calss el yegeb mno (FIRST CHAR LowerCase)
//               ba2olo hat el method el mawgoda fyl compnenent dah
//
// @Primary ==>SINGLE ONLYYY PRIMARY bakon 7ato ta7t el Component Bean fyl class nafso
// wihich one is better Qualfier or Primary ? ==> Qualfier
