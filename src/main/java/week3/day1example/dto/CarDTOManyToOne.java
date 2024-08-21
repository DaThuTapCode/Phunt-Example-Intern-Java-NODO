package week3.day1example.dto;

import lombok.*;
import week3.day1example.model.Owner;

/**
 * Created by Trong Phu on 19/08/2024 13:57:20
 *
 * @author Trong Phu
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDTOManyToOne {

    private String make;
    private String model;
    private int year;
    private String colorCode;
    private double price;
    private OwnerDTO ownerDTO;

}
