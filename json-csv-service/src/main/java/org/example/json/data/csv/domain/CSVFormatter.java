package org.example.json.data.csv.domain;

import org.example.api.LocationMetadataDTO;
import org.example.json.data.infrastructure.ValidationErrorException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

class CSVFormatter {

    private static final Map<String, Function<LocationMetadataDTO, String>> fieldToAttributeFunction = new HashMap<>();

    static {
        fieldToAttributeFunction.put("_id", locationMetadataDTO -> String.valueOf(locationMetadataDTO.getId()));
        fieldToAttributeFunction.put("_type", LocationMetadataDTO::getType);
        fieldToAttributeFunction.put("location_id", locationMetadataDTO -> String.valueOf(locationMetadataDTO.getLocationId()));
        fieldToAttributeFunction.put("longitude", t -> t.getGeoPosition().getLongitude().toString());
        fieldToAttributeFunction.put("latitude", locationMetadataDTO -> locationMetadataDTO.getGeoPosition().getLatitude().toString());
        fieldToAttributeFunction.put("key", LocationMetadataDTO::getKey);
        fieldToAttributeFunction.put("name", LocationMetadataDTO::getName);
        fieldToAttributeFunction.put("fullName", LocationMetadataDTO::getFullName);
        fieldToAttributeFunction.put("iata_airport_code", LocationMetadataDTO::getIataAirportCode);
        fieldToAttributeFunction.put("country", LocationMetadataDTO::getCountry);
        fieldToAttributeFunction.put("inEurope", locationMetadataDTO1 -> locationMetadataDTO1.getInEurope().toString());
        fieldToAttributeFunction.put("countryCode", LocationMetadataDTO::getCountryCode);
        fieldToAttributeFunction.put("coreCountry", locationMetadataDTO -> locationMetadataDTO.getCoreCountry().toString());
        fieldToAttributeFunction.put("distance", LocationMetadataDTO::getDistance);
    }

    private final List<String> attributes;

    CSVFormatter(List<String> attributes) {
        validateAttributes(attributes);
        this.attributes = attributes;
    }

    String formatData(List<LocationMetadataDTO> locationMetadataDTOS) {
        return locationMetadataDTOS.stream()
                .map(this::extractValues)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .reduce((a, b) -> a + "\n" + b)
                .orElse("");
    }

    private Optional<String> extractValues(LocationMetadataDTO locationMetadataDTO) {
        return attributes.stream()
                .map(attribute -> fieldToAttributeFunction.get(attribute).apply(locationMetadataDTO))
                .map(String::valueOf)
                .reduce((a, b) -> a + ", " + b);
    }

    private void validateAttributes(List<String> attributes) {
        boolean allAttributesExistInModel = fieldToAttributeFunction.keySet().containsAll(attributes);
        if (!allAttributesExistInModel) {
            throw new ValidationErrorException();
        }
    }
}
