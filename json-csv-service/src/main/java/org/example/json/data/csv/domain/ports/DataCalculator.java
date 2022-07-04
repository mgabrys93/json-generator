package org.example.json.data.csv.domain.ports;

import java.util.List;

public interface DataCalculator {

    List<String> getOperationsResults(List<String> operations);
}
