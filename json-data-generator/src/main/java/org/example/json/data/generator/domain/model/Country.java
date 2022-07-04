package org.example.json.data.generator.domain.model;

import lombok.Data;

import java.util.Set;

@Data
public class Country {

    private static final Set<String> EUROPE_COUNTRIES = Set.of("Poland");
    private static final Set<String> CORE_COUNTRIES = Set.of("Poland");
    private final String countryName;
    private final String countryCode;
    private final boolean inEurope;
    private final boolean coreCountry;

    public Country(String countryName, String countryCode) {
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.inEurope = EUROPE_COUNTRIES.contains(countryName);
        this.coreCountry = CORE_COUNTRIES.contains(countryName);
    }
}
