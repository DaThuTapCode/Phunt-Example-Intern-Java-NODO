package week3.day1example.service;

import org.springframework.stereotype.Service;
import week3.day1example.model.Car;
import week3.day1example.model.Owner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Trong Phu on 19/08/2024 09:48:42
 *
 * @author Trong Phu
 */
@Service
public class CarService {
    private List<Car> list = new ArrayList<>();

    public CarService() {
        list.add(new Car("Vinfast", "VF3", 2024, "#000000", new Date(), 235000000d, new Owner("Phú", new Date("2004/09/13"), "Nam")));
        list.add(new Car("Vinfast", "VF9", 2023, "#000000", new Date(), 2000000000, new Owner("Phú", new Date("2004/09/13"), "Nam")));
        list.add(new Car("Nissan", "GT-R", 2024, "#000000", new Date(), 1000d, new Owner("Phú", new Date("2004/09/13"), "Nam")));
        list.add(new Car("Toyota", "Camry", 2022, "Red", new Date(), -1000d, new Owner("Phú", new Date("2004/09/13"), "Nam")));
    }

    public List<Car> getAll() {
        return this.list;
    }

    public Car getByModel(String model) {
        for (Car c : this.list) {
            if (c.getModel().equals(model)) {
                return c;
            }
        }
        return null;
    }
}
