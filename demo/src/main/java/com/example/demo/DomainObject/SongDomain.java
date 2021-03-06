package com.example.demo.DomainObject;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Song")

public class SongDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long songID;
    private String Name;
    private String Album;

    @Column(name = "Release_Year")
    private String release_year;

}
