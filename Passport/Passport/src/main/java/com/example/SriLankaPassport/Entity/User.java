package com.example.SriLankaPassport.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String FirstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private String userName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="role_id",nullable=false)
    private  Role role;




}
