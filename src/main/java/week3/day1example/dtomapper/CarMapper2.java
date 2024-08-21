package week3.day1example.dtomapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import week3.day1example.dto.CarDTOManyToOne;
import week3.day1example.dto.CarDTOTrungTenThuocTinh;
import week3.day1example.model.Car;

import java.util.List;

/**
 * Created by Trong Phu on 19/08/2024 10:46:35
 *
 * @author Trong Phu
 */
@Mapper
public interface CarMapper2 {
    CarMapper2 INSTANCE = Mappers.getMapper(CarMapper2.class);

    CarDTOTrungTenThuocTinh carEntityToCarDtoTTTT(Car car);

    @Mapping(target = "ownerDTO.fullName", source = "owner.nameOwner")
    @Mapping(target = "ownerDTO.dob", source = "owner.dayOfBirth")
    @Mapping(target = "ownerDTO.sex", source = "owner.gender")
    CarDTOManyToOne carEntityToCarDtoManyToOne(Car car);

    List<CarDTOManyToOne> lCarDtoManyToOnes(List<Car> lc);
}
