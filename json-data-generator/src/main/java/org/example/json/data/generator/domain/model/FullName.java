package org.example.json.data.generator.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class FullName {
    private final String name;

    public FullName(City cityName, Country country) {
        this.name = cityName.getName() + ", " + country.getCountryName();
    }

}
