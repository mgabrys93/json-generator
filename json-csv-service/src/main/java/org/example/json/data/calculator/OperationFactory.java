package org.example.json.data.calculator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class OperationFactory {

    static Operation getOperation(String operation) {
        if (operation.contains("+")) {
            return new AddOperation(operation);
        } else if (operation.contains("*")) {
            return new MultiplyOperation(operation);
        } else {
            throw new UnsupportedOperationException("Operation" + operation + " is not supported");
        }
    }
}
