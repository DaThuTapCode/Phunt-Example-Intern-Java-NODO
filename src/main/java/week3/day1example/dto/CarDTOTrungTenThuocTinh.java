package week3.day1example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Trong Phu on 19/08/2024 13:47:50
 *
 * @author Trong Phu
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDTOTrungTenThuocTinh {
    private String make;
    private String model;
    private int year;
    private String colorCode;
    private double price;
}
