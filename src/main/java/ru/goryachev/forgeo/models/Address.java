package ru.goryachev.forgeo.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address")
public class Address extends BaseEntity {

    @Column(name = "type")
    private String lat;

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

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn("")
    private Location location;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getLat(), address.getLat()) &&
                Objects.equals(getLineOne(), address.getLineOne()) &&
                Objects.equals(getLineTwo(), address.getLineTwo()) &&
                Objects.equals(getLineThree(), address.getLineThree()) &&
                Objects.equals(getTownCity(), address.getTownCity()) &&
                Objects.equals(getCountry(), address.getCountry()) &&
                Objects.equals(getZipPostal(), address.getZipPostal()) &&
                Objects.equals(getLocation(), address.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLat(), getLineOne(), getLineTwo(), getLineThree(), getTownCity(), getCountry(), getZipPostal(), getLocation());
    }

    @Override
    public String toString() {
        return "Address{" +
                "lat='" + lat + '\'' +
                ", lineOne='" + lineOne + '\'' +
                ", lineTwo='" + lineTwo + '\'' +
                ", lineThree='" + lineThree + '\'' +
                ", townCity='" + townCity + '\'' +
                ", country='" + country + '\'' +
                ", zipPostal='" + zipPostal + '\'' +
                '}';
    }
}
