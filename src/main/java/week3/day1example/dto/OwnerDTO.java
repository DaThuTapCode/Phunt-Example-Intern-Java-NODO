package week3.day1example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Trong Phu on 19/08/2024 14:32:41
 *
 * @author Trong Phu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OwnerDTO {
    private String fullName;  // Khác với `nameOwner` của entity
    private Date dob;         // Khác với `dayOfBirth` của entity
    private String sex;       // Khác với `gender` của entity
}
