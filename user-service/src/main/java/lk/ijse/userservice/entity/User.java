package lk.ijse.userservice.entity;

import jakarta.persistence.*;
import lk.ijse.userservice.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    private String userId;
    private String name;

    @Column(unique = true)
    private String userName;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String password;

}
