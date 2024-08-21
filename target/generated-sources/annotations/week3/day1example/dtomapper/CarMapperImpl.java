package week3.day1example.dtomapper;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import week3.day1example.dto.CarDTO;
import week3.day1example.model.Car;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-21T15:24:25+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public CarDTO toDto(Car car) {
        beforeMapping( car );

        if ( car == null ) {
            return null;
        }

        CarDTO.CarDTOBuilder carDTO = CarDTO.builder();

        carDTO.color( mapColorCode( car.getColorCode() ) );
        if ( car.getManufactureDate() != null ) {
            carDTO.manufactureDateString( mapManufactureDate( new SimpleDateFormat( "dd-MM-yyyy" ).format( car.getManufactureDate() ) ) );
        }
        carDTO.formattedPrice( new DecimalFormat( "$#.00" ).format( car.getPrice() ) );

        carDTO.fullName( car.getMake() + ' ' + car.getModel() );

        return carDTO.build();
    }

    @Override
    public List<CarDTO> listToDto(List<Car> listCar) {
        if ( listCar == null ) {
            return null;
        }

        List<CarDTO> list = new ArrayList<CarDTO>( listCar.size() );
        for ( Car car : listCar ) {
            list.add( toDto( car ) );
        }

        return list;
    }
}
