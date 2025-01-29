package io.swagger.client.selfCreatedServicesEtc.Game;

import io.swagger.client.selfCreatedServicesEtc.LocalRobots.LocalRobot;

public class TurnOrder {
    public static int getStartingRobot(LocalRobot robotOne, LocalRobot robotTwo) {
        int startingRobot;

        if (robotOne.getMovementPoints().intValue() > robotTwo.getMovementPoints().intValue()) {
            startingRobot = 1;
        } else {
            startingRobot = 2;
        }
        return startingRobot;
    }
}
