package org.example.json.data.generator.domain.model;

import com.google.common.base.Preconditions;
import lombok.Data;

@Data
public class Id {
    private final long idValue;

    public Id(long idValue) {
        Preconditions.checkArgument(idValue > 0, "Id must be a positive number");
        this.idValue = idValue;
    }
}
