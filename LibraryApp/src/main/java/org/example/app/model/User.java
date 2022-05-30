package org.example.app.model;

import lombok.*;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;

import javax.validation.constraints.Email;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;
    private String firstName;
    private String lastName;
    @PESEL
    private String pesel;
    @Email
    private String email;

}
