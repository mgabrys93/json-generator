package org.example.json.data.generator.domain.model;

import com.google.common.base.Preconditions;
import lombok.Data;

import java.util.function.DoublePredicate;

@Data
public class Latitude {

    private static DoublePredicate isLatitude = value -> Math.abs(value) < 90;

    private final double latitudeValue;

    public Latitude(double latitudeValue) {
        Preconditions.checkArgument(isLatitude.test(latitudeValue), "Latitude must be in the range(-90;90)");
        this.latitudeValue = latitudeValue;
    }
}
