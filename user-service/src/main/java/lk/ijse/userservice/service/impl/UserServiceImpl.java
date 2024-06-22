package lk.ijse.userservice.service.impl;

import lk.ijse.userservice.dto.UserDTO;
import lk.ijse.userservice.entity.User;
import lk.ijse.userservice.exception.DuplicateException;
import lk.ijse.userservice.exception.InvalidateException;
import lk.ijse.userservice.exception.NotFoundException;
import lk.ijse.userservice.repo.UserRepo;
import lk.ijse.userservice.service.UserService;
import lk.ijse.userservice.util.GenerateID;
import lk.ijse.userservice.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private Mapping mapping;
    @Autowired
    private GenerateID generateID;

    @Override
    public boolean registerUser(UserDTO userDTO) {
        if (userRepo.findUserByUserName(userDTO.getUserName()) == null) {
            userDTO.setUserId(generateID.generateUUID());

            userRepo.save(mapping.toUser(userDTO));
            return true;
        }

        throw new DuplicateException("User Name Duplicated");

    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        if (userRepo.existsById(userDTO.getUserId())) {
            userRepo.save(mapping.toUser(userDTO));
            return true;

        }

        throw new NotFoundException("User Not Found");

    }

    @Override
    public boolean verifyUser(UserDTO userDTO) {
        User userByUserName = userRepo.findUserByUserName(userDTO.getUserName());
        if (userByUserName != null) {
            UserDTO tempUserDTO = mapping.toUserDTO(userByUserName);
            return (tempUserDTO.getPassword().equals(userDTO.getPassword()));

        }
        return false;

    }

}
