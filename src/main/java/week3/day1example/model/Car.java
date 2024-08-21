package week3.day1example.model;

import lombok.*;

import java.util.Date;

/**
 * Created by Trong Phu on 19/08/2024 09:40:24
 *
 * @author Trong Phu
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private String make;
    private String model;
    private int year;
    private String colorCode;
    private Date manufactureDate;
    private double price;
    private Owner owner;
}
