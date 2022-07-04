package org.example.json.data.generator.domain.ports;

public interface FakeDataProvider {

    double getLongitudeValue();
    double getLatitudeValue();
    String getCountryName();
    String getCountryCode();
    String getCityName();
    long getId();
}
