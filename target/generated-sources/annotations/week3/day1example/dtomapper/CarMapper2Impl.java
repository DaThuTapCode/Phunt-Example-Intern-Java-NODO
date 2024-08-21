package week3.day1example.dtomapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import week3.day1example.dto.CarDTOManyToOne;
import week3.day1example.dto.CarDTOTrungTenThuocTinh;
import week3.day1example.dto.OwnerDTO;
import week3.day1example.model.Car;
import week3.day1example.model.Owner;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-21T15:09:00+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
public class CarMapper2Impl implements CarMapper2 {

    @Override
    public CarDTOTrungTenThuocTinh carEntityToCarDtoTTTT(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDTOTrungTenThuocTinh.CarDTOTrungTenThuocTinhBuilder carDTOTrungTenThuocTinh = CarDTOTrungTenThuocTinh.builder();

        carDTOTrungTenThuocTinh.make( car.getMake() );
        carDTOTrungTenThuocTinh.model( car.getModel() );
        carDTOTrungTenThuocTinh.year( car.getYear() );
        carDTOTrungTenThuocTinh.colorCode( car.getColorCode() );
        carDTOTrungTenThuocTinh.price( car.getPrice() );

        return carDTOTrungTenThuocTinh.build();
    }

    @Override
    public CarDTOManyToOne carEntityToCarDtoManyToOne(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDTOManyToOne.CarDTOManyToOneBuilder carDTOManyToOne = CarDTOManyToOne.builder();

        carDTOManyToOne.ownerDTO( ownerToOwnerDTO( car.getOwner() ) );
        carDTOManyToOne.make( car.getMake() );
        carDTOManyToOne.model( car.getModel() );
        carDTOManyToOne.year( car.getYear() );
        carDTOManyToOne.colorCode( car.getColorCode() );
        carDTOManyToOne.price( car.getPrice() );

        return carDTOManyToOne.build();
    }

    @Override
    public List<CarDTOManyToOne> lCarDtoManyToOnes(List<Car> lc) {
        if ( lc == null ) {
            return null;
        }

        List<CarDTOManyToOne> list = new ArrayList<CarDTOManyToOne>( lc.size() );
        for ( Car car : lc ) {
            list.add( carEntityToCarDtoManyToOne( car ) );
        }

        return list;
    }

    protected OwnerDTO ownerToOwnerDTO(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        OwnerDTO.OwnerDTOBuilder ownerDTO = OwnerDTO.builder();

        ownerDTO.fullName( owner.getNameOwner() );
        ownerDTO.dob( owner.getDayOfBirth() );
        ownerDTO.sex( owner.getGender() );

        return ownerDTO.build();
    }
}
