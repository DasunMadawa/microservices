package lk.ijse.vehicleservice.service.impl;

import lk.ijse.vehicleservice.dto.VehicleDTO;
import lk.ijse.vehicleservice.exception.DuplicateException;
import lk.ijse.vehicleservice.exception.NotFoundException;
import lk.ijse.vehicleservice.repo.VehicleRepo;
import lk.ijse.vehicleservice.service.VehicleService;
import lk.ijse.vehicleservice.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepo vehicleRepo;
    @Autowired
    private Mapping mapping;

    @Override
    public boolean registerVehicle(VehicleDTO vehicleDTO) {
        if (!vehicleRepo.existsById(vehicleDTO.getVehicleId())) {
            vehicleRepo.save(mapping.toVehicle(vehicleDTO));
            return true;
        }
        throw new DuplicateException("Vehicle Id Duplicate");

    }

    @Override
    public boolean updateVehicle(VehicleDTO vehicleDTO) {
        if (vehicleRepo.existsById(vehicleDTO.getVehicleId())) {
            vehicleRepo.save(mapping.toVehicle(vehicleDTO));
            return true;
        }
        throw new NotFoundException("Vehicle Not Found");

    }

    @Override
    public VehicleDTO getVehicle(String vehicleId) {
        if (vehicleRepo.existsById(vehicleId)) {
            return mapping.toVehicleDTO(vehicleRepo.getReferenceById(vehicleId));

        }

        throw new NotFoundException("Vehicle Not Found");

    }

}
