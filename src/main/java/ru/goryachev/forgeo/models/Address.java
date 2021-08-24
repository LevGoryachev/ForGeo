package ru.goryachev.forgeo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;


/**
 * Address is an entity for addresses of company facilities
 * (construction sites, buildings, branches, warehouses).
 * @author Lev Goryachev
 * @version 3
 */

@Entity
@Table(name = "address")
public class Address extends BaseEntity {

    @Column(name = "type")
    private String type;

    @Column(name = "line_1")
    private String lineOne;

    @Column(name = "line_2")
    private String lineTwo;

    @Column(name = "line_3")
    private String lineThree;

    @Column(name = "town_city")
    private String townCity;

    @Column(name = "country")
    private String country;

    @Column(name = "zip_postal")
    private String zipPostal;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(/*columnDefinition="bigint",*/ name = "site_location_id", insertable = false, updatable = false)
    @JsonIgnoreProperties(value = { "addresses" ,"hibernateLazyInitializer", "handler" }, allowSetters = true)
    private Location location;

    @Column(name = "site_location_id")
    private Long locationId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLineOne() {
        return lineOne;
    }

    public void setLineOne(String lineOne) {
        this.lineOne = lineOne;
    }

    public String getLineTwo() {
        return lineTwo;
    }

    public void setLineTwo(String lineTwo) {
        this.lineTwo = lineTwo;
    }

    public String getLineThree() {
        return lineThree;
    }

    public void setLineThree(String lineThree) {
        this.lineThree = lineThree;
    }

    public String getTownCity() {
        return townCity;
    }

    public void setTownCity(String townCity) {
        this.townCity = townCity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipPostal() {
        return zipPostal;
    }

    public void setZipPostal(String zipPostal) {
        this.zipPostal = zipPostal;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getType(), address.getType()) &&
                Objects.equals(getLineOne(), address.getLineOne()) &&
                Objects.equals(getLineTwo(), address.getLineTwo()) &&
                Objects.equals(getLineThree(), address.getLineThree()) &&
                Objects.equals(getTownCity(), address.getTownCity()) &&
                Objects.equals(getCountry(), address.getCountry()) &&
                Objects.equals(getZipPostal(), address.getZipPostal()) &&
                Objects.equals(getLocationId(), address.getLocationId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getLineOne(), getLineTwo(), getLineThree(), getTownCity(), getCountry(), getZipPostal(), getLocationId());
    }

    @Override
    public String toString() {
        return "Address{" +
                "type='" + type + '\'' +
                ", lineOne='" + lineOne + '\'' +
                ", lineTwo='" + lineTwo + '\'' +
                ", lineThree='" + lineThree + '\'' +
                ", townCity='" + townCity + '\'' +
                ", country='" + country + '\'' +
                ", zipPostal='" + zipPostal + '\'' +
                ", location=" + location +
                ", locationId=" + locationId +
                '}';
    }
}
