package week3.day2345example.mapper.classes.request;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import week3.day2345example.dto.classes.request.ClassesRequestDTO;
import week3.day2345example.dto.student.request.StudentRequestDTO;
import week3.day2345example.model.Classes;
import week3.day2345example.model.Student;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-21T15:00:37+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class ClassesRequestDTOMapperImpl implements ClassesRequestDTOMapper {

    @Override
    public Classes dtoToEntity(ClassesRequestDTO classesRequestDTO) {
        if ( classesRequestDTO == null ) {
            return null;
        }

        Classes.ClassesBuilder classes = Classes.builder();

        classes.id( classesRequestDTO.getId() );
        classes.classesName( classesRequestDTO.getClassesName() );
        classes.students( studentRequestDTOListToStudentList( classesRequestDTO.getStudents() ) );

        return classes.build();
    }

    protected Student studentRequestDTOToStudent(StudentRequestDTO studentRequestDTO) {
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

    protected List<Student> studentRequestDTOListToStudentList(List<StudentRequestDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Student> list1 = new ArrayList<Student>( list.size() );
        for ( StudentRequestDTO studentRequestDTO : list ) {
            list1.add( studentRequestDTOToStudent( studentRequestDTO ) );
        }

        return list1;
    }
}
