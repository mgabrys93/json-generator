package org.example.json.data.generator.domain.model;

import lombok.Data;

@Data
public class GeoPosition {
    private final Latitude latitude;
    private final Longitude longitude;

    public GeoPosition(double latitudeValue, double longitudeValue) {
        this.latitude = new Latitude(latitudeValue);
        this.longitude = new Longitude(longitudeValue);
    }
}
