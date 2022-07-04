package org.example.json.data.calculator;

import org.example.api.LocationMetadataDTO;
import org.example.json.data.infrastructure.ValidationErrorException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

abstract class Operation {

    static final Map<String, Function<LocationMetadataDTO, BigDecimal>> fieldToAttributeFunction = Map.of(
            "_id", locationMetadataDTO -> BigDecimal.valueOf(locationMetadataDTO.getId()).setScale(5, RoundingMode.HALF_UP),
            "location_id", locationMetadataDTO -> BigDecimal.valueOf(locationMetadataDTO.getLocationId()).setScale(5, RoundingMode.HALF_UP),
            "longitude", t -> BigDecimal.valueOf(t.getGeoPosition().getLongitude()).setScale(5, RoundingMode.HALF_UP),
            "latitude", locationMetadataDTO -> BigDecimal.valueOf(locationMetadataDTO.getGeoPosition().getLatitude()).setScale(5, RoundingMode.HALF_UP)
    );

    protected void validateAttributes(String... attributes) {
        boolean allAttributesExistInModel = fieldToAttributeFunction.keySet().containsAll(Arrays.asList(attributes));
        if (!allAttributesExistInModel) {
            throw new ValidationErrorException();
        }
    }

    abstract BigDecimal getResult(LocationMetadataDTO locationMetadataDTO);
}
