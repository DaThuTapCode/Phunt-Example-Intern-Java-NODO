package week3.day2345example.mapper.student.request;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import week3.day2345example.dto.student.request.StudentRequestDTO;
import week3.day2345example.model.Student;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-21T15:00:37+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class StudentRequestDTOMapperImpl implements StudentRequestDTOMapper {

    @Override
    public List<Student> listDtoToListEntity(List<StudentRequestDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Student> list1 = new ArrayList<Student>( list.size() );
        for ( StudentRequestDTO studentRequestDTO : list ) {
            list1.add( dtoToEntiTy( studentRequestDTO ) );
        }

        return list1;
    }

    @Override
    public Student dtoToEntiTy(StudentRequestDTO studentRequestDTO) {
        if ( studentRequestDTO == null ) {
            return null;
        }

        Student.StudentBuilder student = Student.builder();

        student.name( studentRequestDTO.getName() );
        student.age( studentRequestDTO.getAge() );
        student.address( studentRequestDTO.getAddress() );
        student.status( studentRequestDTO.getStatus() );

        return student.build();
    }
}
