package org.example.json.data.csv.adapters.jsonclient;

import org.example.api.LocationMetadataDTO;
import org.example.json.data.csv.domain.ports.JsonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;

@Component
class JsonLocationMetadataClient implements JsonClient {

    private final Random random = new Random();
    private final RestTemplate restTemplate;

    @Autowired
    JsonLocationMetadataClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<LocationMetadataDTO> fetchLocationMetadata() {
        int size = random.nextInt(9) + 1;
        return restTemplate.exchange("http://localhost:8080/generate/json/" + size, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<LocationMetadataDTO>>() {
                }).getBody();
    }
}
