package org.example.json.data.csv.domain;

import org.example.api.GeoPositionDTO;
import org.example.api.LocationMetadataDTO;

class TestDataGenerator {

    static LocationMetadataDTO createLocationMetadataWithId(long id) {
        return createLocationMetadata(id, 1L, "test", 1d, 1d);
    }

    static LocationMetadataDTO createLocationMetadataWithLongitudeAndLatitude(double longitude, double latitude) {
        return createLocationMetadata(1L, 1L, "test", latitude, longitude);
    }

    static LocationMetadataDTO createLocationMetadata(long id, long locationId, String name,
                                                      double latitude, double longitude) {
        return LocationMetadataDTO.builder()
                .type("Position")
                .id(id)
                .locationId(locationId)
                .key(null)
                .name(name)
                .fullName(name + ", Poland")
                .iataAirportCode(null)
                .country("Poland")
                .geoPosition(getGeoPositionTestData(latitude, longitude))
                .inEurope(true)
                .countryCode("PL")
                .coreCountry(true)
                .distance(null)
                .build();
    }

    private static GeoPositionDTO getGeoPositionTestData(double latitude, double longitude) {
        return GeoPositionDTO.builder()
                .latitude(latitude)
                .longitude(longitude)
                .build();
    }
}
