package org.example.json.data.generator.domain.model;

public enum MetadataType {
    POSITION("Position");

    private final String value;

    private MetadataType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
