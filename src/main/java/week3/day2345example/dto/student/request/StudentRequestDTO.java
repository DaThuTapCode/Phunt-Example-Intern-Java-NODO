package week3.day2345example.dto.student.request;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import week2.day345example.util.EnumStatus;

/**
 * Created by Trong Phu on 21/08/2024 09:47:04
 *
 * @author Trong Phu
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequestDTO {


    private String name;

    private Integer age;

    private String address;

    @Enumerated(EnumType.STRING)
    private EnumStatus status;
}
