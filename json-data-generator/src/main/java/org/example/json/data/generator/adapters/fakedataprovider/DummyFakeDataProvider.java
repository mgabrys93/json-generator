package org.example.json.data.generator.adapters.fakedataprovider;

import org.example.json.data.generator.domain.ports.FakeDataProvider;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
class DummyFakeDataProvider implements FakeDataProvider {

    private static final double MIN_LONGITUDE_VALUE = -180d;
    private static final double MAX_LONGITUDE_VALUE = 180d;
    private static final double MIN_LATITUDE_VALUE = -90d;
    private static final double MAX_LATITUDE_VALUE = 90d;

    private final Random random = new Random();

    @Override
    public double getLongitudeValue() {
        return MIN_LONGITUDE_VALUE + ((MAX_LONGITUDE_VALUE - MIN_LONGITUDE_VALUE) * random.nextDouble());
    }

    @Override
    public double getLatitudeValue() {
        return MIN_LATITUDE_VALUE + ((MAX_LATITUDE_VALUE - MIN_LATITUDE_VALUE) * random.nextDouble());
    }

    @Override
    public String getCountryName() {
        return "Poland";
    }

    @Override
    public String getCountryCode() {
        return "PL";
    }

    @Override
    public String getCityName() {
        return "Wiśniowa";
    }

    @Override
    public long getId() {
        return ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
    }
}
