package com.example.demo.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class SingerDTO implements Serializable {

    private String name;
    private String surname;
    private String birth_year;
    private String song;


}

