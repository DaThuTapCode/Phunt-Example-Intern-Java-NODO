package week3.day2345example.dto.classes.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import week3.day2345example.dto.student.request.StudentRequestDTO;

import java.util.List;

/**
 * Created by Trong Phu on 21/08/2024 09:18:33
 *
 * @author Trong Phu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassesRequestDTO {

    private Long id;
    private String classesName;
    private List<StudentRequestDTO> students;
}
