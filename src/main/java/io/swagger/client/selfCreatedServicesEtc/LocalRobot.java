package io.swagger.client.selfCreatedServicesEtc;

import java.math.BigDecimal;

public class LocalRobot {
    protected String name;
    protected String avatar;
    protected int index;
    protected BigDecimal movementPoints;
    protected int hp;
    protected int damage;
    protected int range;

    public LocalRobot() {
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
}


