package org.example.json.data.generator.infrastructure;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.api.GeoPositionDTO;
import org.example.api.LocationMetadataDTO;
import org.example.json.data.generator.domain.model.CityMetadata;
import org.example.json.data.generator.domain.model.GeoPosition;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DomainToDTOMapper {

    public static LocationMetadataDTO mapToDTO(CityMetadata cityMetadata) {
        return LocationMetadataDTO.builder()
                .type(cityMetadata.getMetadataType().getValue())
                .id(cityMetadata.getId().getIdValue())
                .key(cityMetadata.getKey().getValue())
                .name(cityMetadata.getCity().getName())
                .fullName(cityMetadata.getCity().getFullName())
                .iataAirportCode(cityMetadata.getIataAirportCode().getValue())
                .country(cityMetadata.getCountry().getCountryName())
                .geoPosition(mapToDTO(cityMetadata.getGeoPosition()))
                .locationId(cityMetadata.getLocationId().getIdValue())
                .inEurope(cityMetadata.getCountry().isInEurope())
                .countryCode(cityMetadata.getCountry().getCountryCode())
                .coreCountry(cityMetadata.getCountry().isCoreCountry())
                .distance(cityMetadata.getDistance().getValue())
                .build();
    }

    private static GeoPositionDTO mapToDTO(GeoPosition geoPosition) {
        return GeoPositionDTO.builder()
                .latitude(geoPosition.getLatitude().getLatitudeValue())
                .longitude(geoPosition.getLongitude().getLongitudeValue())
                .build();
    }
}
