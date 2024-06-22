package lk.ijse.vehicleservice.util;

import lk.ijse.vehicleservice.dto.VehicleDTO;
import lk.ijse.vehicleservice.entity.Vehicle;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public VehicleDTO toVehicleDTO(Vehicle vehicle) {
        return modelMapper.map(vehicle , VehicleDTO.class);

    }

    public Vehicle toVehicle(VehicleDTO vehicleDTO) {
        return modelMapper.map(vehicleDTO , Vehicle.class);

    }


}
