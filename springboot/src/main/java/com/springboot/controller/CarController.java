package com.springboot.controller;

import com.springboot.domain.Car;
import com.springboot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

//@RestController
@SessionAttributes(names = {"car"},types = {String.class})
@Controller
public class CarController {
    @Autowired
    private CarService carService;



    @RequestMapping("hithymeleaf")
    public String hiThymeleaf(
            @RequestParam(value = "name",required = false,defaultValue = "world") String name,
            Model model){
        model.addAttribute("name",name);
        //视图(resources 下的模板中的html:hello.html)
        return "hello";
    }

    @RequestMapping(value = "carlist",method = RequestMethod.GET)
    public ModelAndView list(){
        List<Car> list = carService.list();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("carlist");
        mv.addObject("cars",list);
        Car car1 = new Car(3,"沃尔沃",8888d,new Date());
        mv.addObject("car",car1);
        return mv;
    }
}
