package ru.goryachev.forgeo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location extends BaseEntity {

    @Column(name = "latitude")
    private Double lat;

    @Column(name = "longitude")
    private Double lng;

    @Column(name = "postal_address")
    private String postalAddr;

    @Column(name = "constr_address")
    private String constrAddr;

    @Column(name = "linear")
    private Boolean isLinear;

    public Location() {
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getPostalAddr() {
        return postalAddr;
    }

    public void setPostalAddr(String postalAddr) {
        this.postalAddr = postalAddr;
    }

    public String getConstrAddr() {
        return constrAddr;
    }

    public void setConstrAddr(String constrAddr) {
        this.constrAddr = constrAddr;
    }

    public Boolean getLinear() {
        return isLinear;
    }

    public void setLinear(Boolean linear) {
        isLinear = linear;
    }
}
