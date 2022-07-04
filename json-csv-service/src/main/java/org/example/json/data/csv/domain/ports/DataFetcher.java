package org.example.json.data.csv.domain.ports;

import java.util.List;

public interface DataFetcher {

    String getDataInCSVFormat(List<String> attributes);
}
