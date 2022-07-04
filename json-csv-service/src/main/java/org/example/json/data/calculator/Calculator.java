package org.example.json.data.calculator;

import org.example.api.LocationMetadataDTO;

import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    private final List<Operation> operations;

    public Calculator(List<String> operations) {
        this.operations = operations.stream()
                .map(OperationFactory::getOperation)
                .collect(Collectors.toList());
    }

    public List<String> calculate(List<LocationMetadataDTO> locationMetadataDTOS) {
        return locationMetadataDTOS.stream()
                .map(this::getResultForEachOperationForLocationMetadata)
                .collect(Collectors.toList());
    }

    private String getResultForEachOperationForLocationMetadata(LocationMetadataDTO locationMetadataDTO) {
        return operations.stream()
                .map(operation -> operation.getResult(locationMetadataDTO))
                .map(Object::toString)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
    }
}
