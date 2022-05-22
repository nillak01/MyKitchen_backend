package com.samsung.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "name")
    private String name;

    @Column(name = "my")
    private boolean my;


    @Column(name = "point_1")
    private String point_1;

    @Column(name = "point_2")
    private String point_2;

    @Column(name = "point_3")
    private String point_3;

    @Column(name = "point_4")
    private String point_4;

    @Column(name = "point_5")
    private String point_5;

    @Column(name = "point_6")
    private String point_6;

    @Column(name = "point_7")
    private String point_7;

    @Column(name = "point_8")
    private String point_8;

    @Column(name = "point_9")
    private String point_9;

    @Column(name = "point_10")
    private String point_10;


}
