package org.example.json.data.csv.adapters.api;

import org.example.json.data.csv.domain.ports.DataCalculator;
import org.example.json.data.csv.domain.ports.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("csv")
class CSVOperationsResource {

    private static final List<String> PREDEFINED_CSV_FORMAT = List.of("_type", "_id", "name", "latitude", "longitude");

    private final DataFetcher dataFetcher;
    private final DataCalculator dataCalculator;

    @Autowired
    CSVOperationsResource(DataFetcher dataFetcher, DataCalculator dataCalculator) {
        this.dataFetcher = dataFetcher;
        this.dataCalculator = dataCalculator;
    }

    @GetMapping(path = "data", produces = "text/csv")
    public String getContentAsCSV() {
        return dataFetcher.getDataInCSVFormat(PREDEFINED_CSV_FORMAT);
    }

    @GetMapping(path = "data/{attributes}", produces = "text/csv")
    public String getContentInFormat(@PathVariable("attributes") String attributes) {
        return dataFetcher.getDataInCSVFormat(Arrays.asList(attributes.split(",")));
    }

    @GetMapping(path = "operation/{operations}", produces = "text/csv")
    public String getResultForOperations(@PathVariable("operations") String operations) {
        return dataCalculator.getOperationsResults(Arrays.asList(operations.split(","))).stream()
                .reduce((a, b) -> a + "\n" + b)
                .orElse("");
    }
}
