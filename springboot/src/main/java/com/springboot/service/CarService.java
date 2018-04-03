package com.springboot.service;

import com.springboot.domain.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    public List<Car> list(){
        List<Car> list = new ArrayList<>();
        Car car1 = new Car("法拉利",8888d);
        Car car2 = new Car("保时捷",7777d);
        list.add(car1);
        list.add(car2);
        return list;
    }
}
