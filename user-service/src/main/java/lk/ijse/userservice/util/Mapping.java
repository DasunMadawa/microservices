package lk.ijse.userservice.util;

import lk.ijse.userservice.dto.UserDTO;
import lk.ijse.userservice.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private GenerateID generateID;

    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        userDTO.setPassword(new String(Base64.getDecoder().decode(userDTO.getPassword())));
        return userDTO;

    }

    public User toUser(UserDTO userDTO) {
        userDTO.setPassword(Base64.getEncoder().encodeToString(userDTO.getPassword().getBytes()));
        return modelMapper.map(userDTO , User.class);

    }


}
