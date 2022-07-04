package org.example.json.data.calculator;

import org.example.api.LocationMetadataDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;

class AddOperation extends Operation {

    private final String firstValue;
    private final String secondValue;

    AddOperation(String operation) {
        String[] values = operation.split("\\+");
        this.firstValue = values[0];
        this.secondValue = values[1];
        validateAttributes(firstValue, secondValue);
    }

    @Override
    public BigDecimal getResult(LocationMetadataDTO locationMetadataDTO) {
        return getFirstValue(locationMetadataDTO).add(getSecondValue(locationMetadataDTO))
                .setScale(5, RoundingMode.HALF_UP);
    }

    private BigDecimal getFirstValue(LocationMetadataDTO locationMetadataDTO) {
        return fieldToAttributeFunction.get(firstValue).apply(locationMetadataDTO);
    }

    private BigDecimal getSecondValue(LocationMetadataDTO locationMetadataDTO) {
        return fieldToAttributeFunction.get(secondValue).apply(locationMetadataDTO);
    }
}
