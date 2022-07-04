package org.example.json.data.csv.domain.ports;

import org.example.api.LocationMetadataDTO;

import java.util.List;

public interface JsonClient {

    List<LocationMetadataDTO> fetchLocationMetadata();
}
