package week3.day1example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import week3.day1example.dto.CarDTO;
import week3.day1example.dto.CarDTOManyToOne;
import week3.day1example.dtomapper.CarMapper;
import week3.day1example.dtomapper.CarMapper2;
import week3.day1example.model.Car;
import week3.day1example.service.CarService;

import java.util.List;

/**
 * Created by Trong Phu on 19/08/2024 09:48:31
 *
 * @author Trong Phu
 */
@RestController
//@RequiredArgsConstructor
@RequestMapping("week3-day1")
public class CarController {

    private final CarService carService;

    private final CarMapper carMapper;

    @Autowired
    public CarController(
            CarMapper carMapper
            , CarService carService
    ){
        this.carService  = carService;
        this.carMapper = carMapper;
    }

    @GetMapping("get-all")
    public List<Car> getAll(){
        return carService.getAll();
    }

    @GetMapping("get-by-model/{model}")
    public Car getByModel(
            @PathVariable String model
    ){
        return carService.getByModel(model);
    }

    @GetMapping("get-dto-by-model/{model}")
    public CarDTO getCarDTOByModel(
            @PathVariable String model
    ){
        return carMapper.toDto(carService.getByModel(model));
    }

    @GetMapping("get-all-dto")
    public List<CarDTO> getAllCarDto(){
        return this.carMapper.listToDto(this.carService.getAll());
    }

    @GetMapping("get-dto-many-to-one/{model}")
    public CarDTOManyToOne getDTOMNTO(
            @PathVariable String model
    ){
        CarDTOManyToOne carDTOManyToOne = CarMapper2.INSTANCE.carEntityToCarDtoManyToOne(carService.getByModel(model));
        return carDTOManyToOne;
    }

    @GetMapping("get-all-dto-many-to-one")
    public List<CarDTOManyToOne> getAllDTOMNTO(
    ){
        List<CarDTOManyToOne> lcarDTOManyToOne = CarMapper2.INSTANCE.lCarDtoManyToOnes(carService.getAll());
        return lcarDTOManyToOne;
    }

}
