package week3.day2345example.mapper.classes.request;

import org.mapstruct.Mapper;
import week3.day2345example.dto.classes.request.ClassesRequestDTO;
import week3.day2345example.model.Classes;

/**
 * Created by Trong Phu on 21/08/2024 09:31:50
 *
 * @author Trong Phu
 */
@Mapper(componentModel = "spring")
public interface ClassesRequestDTOMapper {
    Classes dtoToEntity(ClassesRequestDTO classesRequestDTO);
}
