package com.example.assignment;

import jakarta.persistence.*;
/**
 * Represents a user location with latitude and longitude coordinates.
 */
@Entity
@Table(name = "user_location")
public class UserLocation {
    /**
     * The unique identifier for the user location.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the user location.
     */
    private String name;

    /**
     * The latitude coordinate of the user location.
     */
    private double latitude;

    /**
     * The longitude coordinate of the user location.
     */
    private double longitude;

    /**
     * The distance of the user location from the origin point.
     * This field is transient, meaning it is not persisted in the database.
     */
    @Transient
    private double distanceFromOrigin;

    /**
     * Returns the distance of the user location from the origin point.
     *
     * @return the distance from the origin point
     */
    public double getDistanceFromOrigin() {
        return distanceFromOrigin;
    }

    /**
     * Sets the distance of the user location from the origin point.
     *
     * @param distanceFromOrigin the distance from the origin point
     */
    public void setDistanceFromOrigin(double distanceFromOrigin) {
        this.distanceFromOrigin = distanceFromOrigin;
    }

    /**
     * Returns the unique identifier of the user location.
     *
     * @return the unique identifier
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the user location.
     *
     * @param id the unique identifier
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the user location.
     *
     * @return the name of the user location
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the user location.
     *
     * @param name the name of the user location
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the latitude coordinate of the user location.
     *
     * @return the latitude coordinate
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude coordinate of the user location.
     *
     * @param latitude the latitude coordinate
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Returns the longitude coordinate of the user location.
     *
     * @return the longitude coordinate
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude coordinate of the user location.
     *
     * @param longitude the longitude coordinate
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
