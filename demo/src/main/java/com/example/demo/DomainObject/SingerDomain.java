package com.example.demo.DomainObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;

@Data
@Entity
@Table(name = "singers")

public class SingerDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column (nullable = false, unique = true)

    private String name;
    private String surname;
    private Integer birth_year;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "song_id")
    private SongDomain song;
}
