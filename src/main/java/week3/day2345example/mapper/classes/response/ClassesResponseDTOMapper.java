package week3.day2345example.mapper.classes.response;

import org.mapstruct.Mapper;
import week3.day2345example.dto.classes.response.ClassesResponseDTO;
import week3.day2345example.model.Classes;

import java.util.List;

/**
 * Created by Trong Phu on 21/08/2024 08:50:39
 *
 * @author Trong Phu
 */
@Mapper(componentModel = "spring")
public interface ClassesResponseDTOMapper {

    List<ClassesResponseDTO> entityToRDTO(List<Classes> listClasses);
}
