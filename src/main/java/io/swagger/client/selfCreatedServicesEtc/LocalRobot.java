package io.swagger.client.selfCreatedServicesEtc;

import java.math.BigDecimal;

public class LocalRobot {
    protected int index;
    protected BigDecimal movementPoints;

    public LocalRobot(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public BigDecimal getMovementPoints() {
        return movementPoints;
    }
    public void setMovementPoints(BigDecimal movementPoints) {
        this.movementPoints = movementPoints;
    }
}


