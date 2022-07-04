package org.example.json.data.generator.adapters.messagebroker;

import org.example.json.data.generator.domain.model.CityMetadata;
import org.example.json.data.generator.domain.ports.MessagePublisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class KafkaMessageBroker implements MessagePublisher {

    @Override
    public void publish(List<CityMetadata> cityMetadata) {
        //todo add sending cityMetadata
    }
}
