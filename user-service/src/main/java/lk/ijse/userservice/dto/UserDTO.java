package lk.ijse.userservice.dto;

import lk.ijse.userservice.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String userId;
    private String name;
    private String userName;
    private Role role;
    private String password;

}
