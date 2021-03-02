package ru.goryachev.forgeo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@Table(name = "locations")
public class Location extends BaseEntity {

    //@Column (name = "longitude")
    private Integer lng;

    //@Column (name = "latitude")
    private Integer lat;

    //@Column (name = "postal_address")
    private String postalAddr;

    //@Column (name = "constr_address")
    private String constrAddr;

    //@Column (name = "linear")
    private Boolean isLinear;

    public Integer getLng() {
        return lng;
    }

    public void setLng(Integer lng) {
        this.lng = lng;
    }

    public Integer getLat() {
        return lat;
    }

    public void setLat(Integer lat) {
        this.lat = lat;
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
