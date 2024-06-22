package lk.ijse.vehicleservice.controller;

import jakarta.validation.Valid;
import lk.ijse.vehicleservice.dto.VehicleDTO;
import lk.ijse.vehicleservice.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/health")
    public String vehicleHealthCheck(){
        return "Vehicle OK !";

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleDTO> saveVehicle(@Valid @RequestBody VehicleDTO vehicleDTO) {
        try {
            vehicleService.registerVehicle(vehicleDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(vehicleDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }

    }

    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleDTO> updateVehicle(@Valid @PathVariable("id") String vehicleId, @RequestBody VehicleDTO vehicleDTO) {
        try {
            vehicleDTO.setVehicleId(vehicleId);
            vehicleService.updateVehicle(vehicleDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(vehicleDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }

    }

    @GetMapping(value = "{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehicleDTO> getVehicle(@PathVariable("id") String vehicleId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicle(vehicleId));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }

    }


}
