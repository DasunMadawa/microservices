package lk.ijse.userservice.service;

import lk.ijse.userservice.dto.UserDTO;
import lk.ijse.userservice.entity.User;

public interface UserService {
    boolean registerUser(UserDTO userDTO);
    boolean updateUser(UserDTO userDTO);
    boolean verifyUser(UserDTO userDTO);

}
