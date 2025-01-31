package io.swagger.client.selfCreatedServicesEtc.Directions;

import io.swagger.client.model.Align;

import java.util.Objects;

public class InvertDirections {
    public static Align invertDirection(Directions alignment) {
        for (Align align : Align.values()) {
            if (Objects.equals(alignment.freddyKey, align.getValue())) {
                return align;
            }
        }
        return null;
    }
}
