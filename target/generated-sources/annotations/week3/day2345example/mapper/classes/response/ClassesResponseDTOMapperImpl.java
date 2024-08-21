package week3.day2345example.mapper.classes.response;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import week3.day2345example.dto.classes.response.ClassesResponseDTO;
import week3.day2345example.model.Classes;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-21T15:00:37+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class ClassesResponseDTOMapperImpl implements ClassesResponseDTOMapper {

    @Override
    public List<ClassesResponseDTO> entityToRDTO(List<Classes> listClasses) {
        if ( listClasses == null ) {
            return null;
        }

        List<ClassesResponseDTO> list = new ArrayList<ClassesResponseDTO>( listClasses.size() );
        for ( Classes classes : listClasses ) {
            list.add( classesToClassesResponseDTO( classes ) );
        }

        return list;
    }

    protected ClassesResponseDTO classesToClassesResponseDTO(Classes classes) {
        if ( classes == null ) {
            return null;
        }

        ClassesResponseDTO.ClassesResponseDTOBuilder classesResponseDTO = ClassesResponseDTO.builder();

        classesResponseDTO.id( classes.getId() );
        classesResponseDTO.classesName( classes.getClassesName() );

        return classesResponseDTO.build();
    }
}
