package org.example.json.data.generator.domain.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class City {
    private final String name;

    @Getter(AccessLevel.NONE)
    private final Country country;

    public String getFullName() {
        return name + ", " + country.getCountryName();
    }
}
