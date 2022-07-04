package org.example.json.data.generator.adapters.api;

import org.example.api.LocationMetadataDTO;
import org.example.json.data.generator.domain.ports.DataGenerator;
import org.example.json.data.generator.infrastructure.DomainToDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/generate/json")
class JsonGeneratorResource {

    @Autowired
    DataGenerator dataGenerator;

    @GetMapping("{size}")
    public List<LocationMetadataDTO> getGeneratedJson(@PathVariable("size") int size) {
        return dataGenerator.generateCityMetadata(size).stream()
                .map(DomainToDTOMapper::mapToDTO)
                .collect(Collectors.toList());
    }
}
