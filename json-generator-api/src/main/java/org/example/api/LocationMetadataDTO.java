package org.example.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import javax.annotation.Nullable;

@Value.Immutable
@JsonSerialize(as = ImmutableLocationMetadataDTO.class)
@JsonDeserialize(as = ImmutableLocationMetadataDTO.class)
public interface LocationMetadataDTO {

    static ImmutableLocationMetadataDTO.Builder builder() {
        return ImmutableLocationMetadataDTO.builder();
    }

    @JsonProperty(value = "_type")
    String getType();

    @JsonProperty(value = "_id")
    Long getId();

    @Nullable
    String getKey();

    String getName();

    String getFullName();

    @Nullable
    @JsonProperty(value = "iata_airport_code")
    String getIataAirportCode();

    String getCountry();

    @JsonProperty(value = "geo_position")
    GeoPositionDTO getGeoPosition();

    @JsonProperty(value = "location_id")
    Long getLocationId();

    Boolean getInEurope();

    String getCountryCode();

    Boolean getCoreCountry();

    @Nullable
    String getDistance();
}
