package org.example.json.data.generator.domain.ports;

import org.example.json.data.generator.domain.model.CityMetadata;

import java.util.List;

public interface DataGenerator {
    List<CityMetadata> generateCityMetadata(int size);
}
