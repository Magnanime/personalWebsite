package com.Magnanime.personalWebsite.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

//Model for users

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String userName;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private Boolean enabled;
    @Column
    private String registrationLetter;
}
