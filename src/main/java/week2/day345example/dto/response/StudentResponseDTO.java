package week2.day345example.dto.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import week2.day345example.entity.Student;
import week2.day345example.util.EnumStatus;

/**
 * Created by Trong Phu on 15/08/2024 15:49:04
 *
 * @author Trong Phu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponseDTO {

    private Long id;

    private String name;

    private Integer age;

    private String address;

//    private Integer yearOfBirth;

    @Enumerated(EnumType.STRING)
    private EnumStatus status;

    public Integer getYearOfBirth(){
        return 2024 - this.age;
    }

   public static StudentResponseDTO covert(Student student){
        return StudentResponseDTO.builder()
                .id(student.getId())
                .address(student.getAddress())
                .name(student.getName())
                .age(student.getAge())
                .status(student.getStatus())
                .build();
    }

}
