package com.Magnanime.personalWebsite.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//Model for users

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String email;
    @Column(columnDefinition = "boolean default false")
    private Boolean enabled;
}
