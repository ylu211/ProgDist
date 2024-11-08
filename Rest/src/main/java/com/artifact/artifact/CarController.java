package com.artifact.artifact;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private static List<Car> cars = new ArrayList<>(Arrays.asList(
        new Car("11AA22", "Ferrari", 100, false),
        new Car("33BB44", "Porsche", 120, false),
        new Car("31AB46", "VW", 160, false)

    ));

    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Car> listOfCars() {
        return cars;
    }

    @GetMapping("/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception {
        return cars.stream().filter(car -> car.getPlateNumber().equals(plateNumber)).findFirst().orElseThrow(() -> new Exception("Car not found"));
    }

    @PutMapping(value = "/cars/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public String rentOrGetBack(
        @PathVariable("plateNumber") String plateNumber,
        @RequestParam("isRented") boolean isRented,
        @RequestParam(value = "begin", required = false) String begin,
        @RequestParam(value = "end", required = false) String end) throws Exception {
        
        Car car = cars.stream()
                      .filter(c -> c.getPlateNumber().equals(plateNumber))
                      .findFirst()
                      .orElseThrow(() -> new Exception("Car not found"));
        
        car.setRented(isRented);
        if (isRented) {
            if(begin==null||end==null) {
                throw new Exception("Need dates");
            }
            Dates rentalDates = new Dates();
            rentalDates.setBegin(begin);
            rentalDates.setEnd(end);
            car.setRentalDates(rentalDates);
            return "Car rented from " + begin + " to " + end;
        }

        String message = isRented ? "Car rented from " + begin + " to " + end : "Car returned successfully";
             
        return message;
    }

}
