package week3.day2345example.mapper.student.request;

import org.mapstruct.Mapper;
import week3.day2345example.dto.student.request.StudentRequestDTO;
import week3.day2345example.model.Student;

import java.util.List;

/**
 * Created by Trong Phu on 21/08/2024 10:06:01
 *
 * @author Trong Phu
 */
@Mapper(componentModel = "spring")
public interface StudentRequestDTOMapper {
    List<Student> listDtoToListEntity(List<StudentRequestDTO> list);
    Student dtoToEntiTy(StudentRequestDTO studentRequestDTO);
}
