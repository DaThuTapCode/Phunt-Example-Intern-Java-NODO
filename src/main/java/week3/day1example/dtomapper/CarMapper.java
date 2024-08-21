package week3.day1example.dtomapper;

import org.mapstruct.*;
import week3.day1example.dto.CarDTO;
import week3.day1example.model.Car;

import java.util.List;

/**
 * Created by Trong Phu on 19/08/2024 09:41:54
 *
 * @author Trong Phu
 */
@Mapper(componentModel = "spring")
public interface CarMapper {
    @Mapping(source = "colorCode", target = "color", qualifiedByName = "mapColorCode")
    @Mapping(source = "manufactureDate", target = "manufactureDateString", dateFormat = "dd-MM-yyyy", qualifiedByName = "mapManufactureDate")
    @Mapping(source = "price", target = "formattedPrice", numberFormat = "$#.00")
    @Mapping(target = "fullName", expression = "java(car.getMake() + ' ' + car.getModel())")
    CarDTO toDto(Car car);

    List<CarDTO> listToDto(List<Car> listCar);

    // sử dụng custom mapper
    // Có thể viết  các phương thức ánh xạ tùy chỉnh trong mapper khi ánh xạ phức tạp hơn không thể xử lý bằng mapping';
    @Named("mapColorCode")
    default String mapColorCode(String colorCode) {
        // Custom logic
        return "Mapped: " + colorCode;
    }

    @Named("mapManufactureDate")
    default String mapManufactureDate(String manufactureDate) {
        return "Ngày sản xuất: " + manufactureDate;
    }

    // Thêm BeforeMapping để xử lý trước ánh xạ
    @BeforeMapping
    default void beforeMapping(Car car) {
        if (car.getPrice() < 0) {
            car.setPrice(0);  // Nếu giá trị âm, đặt về 0
        }
    }

    // Thêm AfterMapping để xử lý sau ánh xạ
    @AfterMapping
    default void afterMapping(CarDTO carDTO) {
        System.out.println("duma");
//        car.setColorCode("hehe");
//        if ("Red".equalsIgnoreCase(car.getColorCode())) {
//            carDTO.setColor("Bright Red"); // Nếu màu là đỏ, đổi thành Bright Red
//        }
    }

}
