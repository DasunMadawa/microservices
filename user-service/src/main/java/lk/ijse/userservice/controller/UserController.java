package lk.ijse.userservice.controller;

import lk.ijse.userservice.dto.UserDTO;
import lk.ijse.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/health")
    public String userHealthCheck() {
        return "User OK !";

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        try {
            userService.registerUser(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> updateUser(@PathVariable("id") String userId, @RequestBody UserDTO userDTO) {
        try {
            userDTO.setUserId(userId);
            userService.updateUser(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

        }

    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/verify", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity verifyUser(@RequestBody UserDTO userDTO) {
        boolean isVerified = userService.verifyUser(userDTO);
        return isVerified ?
                ResponseEntity.status(HttpStatus.OK).body(true) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);

    }

}
