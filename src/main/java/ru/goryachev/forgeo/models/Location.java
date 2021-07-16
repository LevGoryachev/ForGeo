package ru.goryachev.forgeo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Location is an entity for static geolocations of company facilities
 * (construction sites, buildings, branches, warehouses).
 * @author Lev Goryachev
 * @version 3
 */

@Entity
@Table(name = "site_location")
public class Location extends BaseEntity {

    @Column(name = "latitude")
    private Double lat;

    @Column(name = "longitude")
    private Double lng;

    @OneToMany(mappedBy = "location", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "location" ,"hibernateLazyInitializer", "handler" }, allowSetters = true)
    private List<Address> addresses;

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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(getLat(), location.getLat()) &&
                Objects.equals(getLng(), location.getLng()) &&
                Objects.equals(getAddresses(), location.getAddresses());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLat(), getLng(), getAddresses());
    }

    @Override
    public String toString() {
        return "Location{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
