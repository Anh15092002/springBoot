package com.webSales.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name" ,length = 100, nullable = false)
    private String name;

    @Column(name = "password",length = 100, nullable = false)
    private String password;

    @Column(name = "confirmpassword", length = 100, nullable = false)
    private String confirmpassword;

    @Column(name = "email",length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "city", length = 50)
    private  String city;

    @Column(name = "country", length = 50)
    private String country;
}
