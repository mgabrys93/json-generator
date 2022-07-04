package org.example.json.data.generator.domain;

import org.example.json.data.generator.domain.model.CityMetadata;
import org.example.json.data.generator.domain.ports.DataGenerator;
import org.example.json.data.generator.domain.ports.FakeDataProvider;
import org.example.json.data.generator.domain.ports.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
class DataGeneratorService implements DataGenerator {

    private final FakeDataProvider fakeDataProvider;
    private final MessagePublisher messagePublisher;

    @Autowired
    DataGeneratorService(FakeDataProvider fakeDataProvider, MessagePublisher messagePublisher) {
        this.fakeDataProvider = fakeDataProvider;
        this.messagePublisher = messagePublisher;
    }

    @Override
    public List<CityMetadata> generateCityMetadata(int size) {
        List<CityMetadata> cityMetadata = IntStream.iterate(0, i -> i + 1)
                .limit(size)
                .mapToObj(i -> generateCityMetadata())
                .collect(Collectors.toList());
        messagePublisher.publish(cityMetadata);
        return cityMetadata;
    }

    private CityMetadata generateCityMetadata() {
        return CityMetadata.createCityMetadata(
                fakeDataProvider.getId(),
                fakeDataProvider.getId(),
                fakeDataProvider.getCountryName(),
                fakeDataProvider.getCountryCode(),
                fakeDataProvider.getCityName(),
                fakeDataProvider.getLongitudeValue(),
                fakeDataProvider.getLatitudeValue());
    }
}
