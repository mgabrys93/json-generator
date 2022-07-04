package org.example.json.data.csv.domain;

import org.example.api.LocationMetadataDTO;
import org.example.json.data.calculator.Calculator;
import org.example.json.data.csv.domain.ports.DataCalculator;
import org.example.json.data.csv.domain.ports.DataFetcher;
import org.example.json.data.csv.domain.ports.JsonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class CSVService implements DataCalculator, DataFetcher {

    private final JsonClient jsonClient;

    @Autowired
    CSVService(JsonClient jsonClient) {
        this.jsonClient = jsonClient;
    }

    @Override
    public List<String> getOperationsResults(List<String> operations) {
        List<LocationMetadataDTO> locationMetadataDTOS = jsonClient.fetchLocationMetadata();
        Calculator calculator = new Calculator(operations);
        return calculator.calculate(locationMetadataDTOS);
    }

    @Override
    public String getDataInCSVFormat(List<String> attributes) {
        List<LocationMetadataDTO> locationMetadataDTOS = jsonClient.fetchLocationMetadata();
        CSVFormatter csvFormatter = new CSVFormatter(attributes);
        return csvFormatter.formatData(locationMetadataDTOS);
    }
}
