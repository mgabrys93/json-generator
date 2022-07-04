package org.example.json.data.generator.domain.model;

import com.google.common.base.Preconditions;
import lombok.Data;

import java.util.function.DoublePredicate;

@Data
public class Longitude {
    private static DoublePredicate isLongitude = value -> Math.abs(value) < 180;

    private final double longitudeValue;

    public Longitude(double longitudeValue) {
        Preconditions.checkArgument(isLongitude.test(longitudeValue), "Longitude must be in the range(-90;90)");
        this.longitudeValue = longitudeValue;
    }
}
