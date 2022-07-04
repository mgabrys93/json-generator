package org.example.json.data.csv.domain;

import org.example.api.LocationMetadataDTO;
import org.example.json.data.csv.domain.ports.JsonClient;

import java.util.List;

class DummyDataClient implements JsonClient {

    private final List<LocationMetadataDTO> data;

    DummyDataClient(List<LocationMetadataDTO> data) {
        this.data = data;
    }

    @Override
    public List<LocationMetadataDTO> fetchLocationMetadata() {
        return data;
    }
}
