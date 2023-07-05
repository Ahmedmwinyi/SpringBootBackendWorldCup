package com.football.footballbackend.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data

@Entity
@Table(name = "teams")

public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Title")
    private String title;

    @Column(name = "Continent")
    private String cont;

    @Column(name = "Coach")
    private String coach;

    @Column(name = "KeyPlayer")
    private String keyplayer;

}
