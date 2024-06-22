package lk.ijse.userservice.dto;

import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String userName;
    private Role role;
    @NotNull
    private String password;

}
