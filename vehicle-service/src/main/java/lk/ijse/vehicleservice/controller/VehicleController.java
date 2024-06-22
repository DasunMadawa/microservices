package lk.ijse.vehicleservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/vehicle")
public class VehicleController {
    @GetMapping("/health")
    public String vehicleHealthCheck(){
        return "Vehicle OK !";

    }

}
