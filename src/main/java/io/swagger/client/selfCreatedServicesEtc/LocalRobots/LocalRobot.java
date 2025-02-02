package io.swagger.client.selfCreatedServicesEtc.LocalRobots;

import io.swagger.client.model.Align;
import io.swagger.client.selfCreatedServicesEtc.Directions.Directions;

import java.math.BigDecimal;

public class LocalRobot {
    protected String userId;
    protected String robotId;
    protected String name;
    protected String avatar;
    protected int index;
    protected Align align;
    protected BigDecimal movementPoints;
    protected int hp;
    protected int damage;
    protected int range;
    protected String lastMoveId;
    protected Directions direction;

    public LocalRobot() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRobotId() {
        return robotId;
    }

    public void setRobotId(String robotId) {
        this.robotId = robotId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public Align getAlign() {
        return align;
    }
    public void setAlign(Align align) {
        this.align = align;
    }
    public BigDecimal getMovementPoints() {
        return movementPoints;
    }
    public void setMovementPoints(BigDecimal movementPoints) {
        this.movementPoints = movementPoints;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public Directions getDirection() {
        return direction;
    }

    public void setDirection(Directions direction) {
        this.direction = direction;
    }

    public String getLastMoveId() {
        return lastMoveId;
    }

    public void setLastMoveId(String lastMoveId) {
        this.lastMoveId = lastMoveId;
    }
}


