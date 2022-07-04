package org.example.json.data.generator.domain.model;

public enum IATAAirportCode {
    KRK("KRK");

    private final String value;

    private IATAAirportCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
