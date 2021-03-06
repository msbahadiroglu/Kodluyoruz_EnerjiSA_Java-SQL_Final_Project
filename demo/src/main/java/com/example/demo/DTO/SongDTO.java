package com.example.demo.DTO;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SongDTO implements Serializable {

    //private static final long serialVersionUID = 1L;
    @JsonIgnore
    private Long id;


    @JsonProperty("song")
    private SongDTO songDTO;
    private String album; //Bu satır JsonIgnore'un altındaydı değiştirebilirsin

}
