package com.stoom.locationApi.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "db_adress")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String streetName;

    @Column(nullable = false)
    private Long number;

    @Column(nullable = false)
    private String complement;

    @Column(nullable = false)
    private String neighbourhood;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false, length = 2)
    private String state;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String zipCode;

    @Column
    private String latitude;

    @Column
    private String longitude;
}
