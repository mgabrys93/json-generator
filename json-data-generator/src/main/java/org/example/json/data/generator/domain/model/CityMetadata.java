package org.example.json.data.generator.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class CityMetadata {
    private final MetadataType metadataType;
    private final Id id;
    private final Id locationId;
    private final Key key;
    private final City city;
    private final Country country;
    private final IATAAirportCode iataAirportCode;
    private final GeoPosition geoPosition;
    private final Distance distance;

    public static CityMetadata createCityMetadata(long id, long locationId, String countryName, String countryCode,
                                                  String cityName, double longitude, double latitude) {
        Id newId = new Id(id);
        Id newLocationId = new Id(locationId);
        Country newCountry = new Country(countryName, countryCode);
        City newCity = new City(cityName, newCountry);
        GeoPosition newGeoposition = new GeoPosition(latitude, longitude);
        return new CityMetadata(MetadataType.POSITION, newId, newLocationId, new Key("emptyKey"),
                newCity, newCountry, IATAAirportCode.KRK, newGeoposition, new Distance("distance"));
    }

    private CityMetadata(MetadataType metadataType,
                         Id id,
                         Id locationId,
                         Key key,
                         City city,
                         Country country,
                         IATAAirportCode iataAirportCode,
                         GeoPosition geoPosition,
                         Distance distance) {
        this.metadataType = metadataType;
        this.id = id;
        this.locationId = locationId;
        this.key = key;
        this.city = city;
        this.country = country;
        this.iataAirportCode = iataAirportCode;
        this.geoPosition = geoPosition;
        this.distance = distance;
    }
}
