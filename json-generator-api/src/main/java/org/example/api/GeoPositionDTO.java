package org.example.api;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonSerialize(as = ImmutableGeoPositionDTO.class)
@JsonDeserialize(as = ImmutableGeoPositionDTO.class)
public interface GeoPositionDTO {

    static ImmutableGeoPositionDTO.Builder builder(){
        return ImmutableGeoPositionDTO.builder();
    }

    Double getLatitude();

    Double getLongitude();
}
