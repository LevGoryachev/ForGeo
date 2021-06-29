package ru.goryachev.forgeo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "site_location")
public class Location extends BaseEntity {

    @Column(name = "latitude")
    private Double lat;

    @Column(name = "longitude")
    private Double lng;

    @OneToMany(mappedBy = "location")
    private List<Address> addresses;


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
