package com.example.SriLankaPassport.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String FirstName;
    private String LastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String userName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id",nullable=false)
    private  Role role;



}
