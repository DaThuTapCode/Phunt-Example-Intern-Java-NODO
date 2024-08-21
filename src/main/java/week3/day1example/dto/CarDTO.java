package week3.day1example.dto;

import lombok.*;

/**
 * Created by Trong Phu on 19/08/2024 09:40:55
 *
 * @author Trong Phu
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private String fullName;
    private String color;
    private String manufactureDateString;
    private String formattedPrice;

}
