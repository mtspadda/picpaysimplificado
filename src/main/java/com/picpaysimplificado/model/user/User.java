package com.picpaysimplificado.model.user;

import com.picpaysimplificado.dto.UserDto;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String document;

    @Column(unique = true)
    private String email;

    private String password;

    private BigDecimal balance;

    private UserType userType;

    public User(UserDto userDto){
        this.firstName = userDto.firstName();
        this.lastName = userDto.lastName();
        this.balance = userDto.balance();
        this.password = userDto.password();
        this.email = userDto.email();
        this.document = userDto.document();
        this.userType = userDto.userType();
    }
}
