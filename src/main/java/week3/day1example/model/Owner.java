package week3.day1example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by Trong Phu on 19/08/2024 13:51:19
 *
 * @author Trong Phu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Owner {
    private String nameOwner;

    private Date dayOfBirth;

    private String gender;
}
