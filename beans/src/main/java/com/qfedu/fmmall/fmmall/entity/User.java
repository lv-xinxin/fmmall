package com.qfedu.fmmall.fmmall.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int userId;
    private String username;
    private String userRealname;
    private String userImg;

}
