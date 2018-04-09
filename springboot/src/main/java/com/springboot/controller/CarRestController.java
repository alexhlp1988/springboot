package com.springboot.controller;

import com.springboot.domain.Car;
import com.springboot.domain.CustomType;
import com.springboot.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarRestController {
    @Autowired
    private CarService carService;

    @RequestMapping(value = "/cars",method = RequestMethod.GET)
    public ResponseEntity<?> list(){
        List<Car> cars = carService.list();
        if (cars.isEmpty()){
            return new ResponseEntity<>(new CustomType(400,"没有匹配的结果!"),HttpStatus.OK);
        }
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @RequestMapping(value = "/cars/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getCar(@PathVariable("id") Integer id){
        Car car = carService.find(id);
        if (car == null) {
            return new ResponseEntity<>(new CustomType(400,id+"没有匹配的结果!"),HttpStatus.OK);
        }
        return new ResponseEntity<>(car,HttpStatus.OK);
    }

    @RequestMapping(value = "/cars",method = RequestMethod.POST)
    public ResponseEntity<?> addCar(@RequestBody Car car){
//        Car car = new Car(0,name,price,createDate);
        int count = carService.add(car);
        CustomType customType = new CustomType(400,"添加失败");
        if (count > 0){
            customType.setCode(200);
            customType.setMessage("添加成功");
        }
        return new ResponseEntity<>(customType,HttpStatus.OK);
    }

    @RequestMapping(value = "/cars",method = RequestMethod.PUT)
    public ResponseEntity<?> modifyCar(@RequestBody Car car){
//        Car car = new Car(id,name,price,createDate);
        int count = carService.modify(car);
        CustomType customType = new CustomType(400,"更新失败");
        if (count > 0){
            customType.setCode(200);
            customType.setMessage("更新成功");
        }
        return new ResponseEntity<>(customType,HttpStatus.OK);
    }

    @RequestMapping(value = "/cars/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delCar(@PathVariable("id") Integer id){
        int count = carService.remove(id);
        CustomType customType = new CustomType(400,"删除失败");
        if (count > 0){
            customType.setCode(200);
            customType.setMessage("删除成功");
        }
        return new ResponseEntity<>(customType,HttpStatus.OK);
    }
}
