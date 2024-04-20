package com.webSales.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Integer id;
    private String name;
    private String password;
    private String confirmpassword;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String country;
}
