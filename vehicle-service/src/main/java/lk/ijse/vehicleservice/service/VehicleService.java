package lk.ijse.vehicleservice.service;

import lk.ijse.vehicleservice.dto.VehicleDTO;

public interface VehicleService {
    boolean registerVehicle(VehicleDTO vehicleDTO);
    boolean updateVehicle(VehicleDTO vehicleDTO);
    VehicleDTO getVehicle(String vehicleId);


}
