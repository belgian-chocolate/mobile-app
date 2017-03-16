package com.tainguyenbui.techsprint.model.transaction;

import java.math.BigDecimal;

/**
 * Created by tainguyenbui on 14/03/2017.
 */

public class Address {

    String short_formatted;
    String formatted;
    String address;
    String city;
    String region;
    String country;
    String postcode;
    BigDecimal latitude;
    BigDecimal longitude;
    int zoom_level;
    Boolean approximate;

    public String getShort_formatted() {
        return short_formatted;
    }

    public void setShort_formatted(String short_formatted) {
        this.short_formatted = short_formatted;
    }

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public int getZoom_level() {
        return zoom_level;
    }

    public void setZoom_level(int zoom_level) {
        this.zoom_level = zoom_level;
    }

    public Boolean getApproximate() {
        return approximate;
    }

    public void setApproximate(Boolean approximate) {
        this.approximate = approximate;
    }
}
