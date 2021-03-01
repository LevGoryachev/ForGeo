package ru.goryachev.forgeo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location extends BaseEntity {

    @Column (name = "longitude")
    private Double lng;

    @Column (name = "latitude")
    private Double lat;

    @Column (name = "postal_address")
    private String postalAddr;

    @Column (name = "postal_address")
    private String constrAddr;

    @Column (name = "linear")
    private Boolean isLinear;
}
