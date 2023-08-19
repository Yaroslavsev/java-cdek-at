package org.example.live_coding_18_08_2023.models;

import java.util.Objects;

public class Geo {
    private double lat;
    private double ing;

    public Geo() {
    }

    public Geo(double lat, double ing) {
        this.lat = lat;
        this.ing = ing;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getIng() {
        return ing;
    }

    public void setIng(double ing) {
        this.ing = ing;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "lat=" + lat +
                ", ing=" + ing +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Geo)) return false;
        Geo geo = (Geo) o;
        return Double.compare(getLat(), geo.getLat()) == 0 && Double.compare(getIng(), geo.getIng()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLat(), getIng());
    }
}
