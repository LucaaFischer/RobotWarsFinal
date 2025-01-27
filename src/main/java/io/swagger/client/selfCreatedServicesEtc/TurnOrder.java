package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;

public class TurnOrder {
    public static int getStartingRobot(DefaultApi api, String robotOneID, String robotTwoID) throws ApiException {
        int movementRobotOne = api.apiRobotsRobotIdGet(robotOneID).getMovementRate().intValue();
        int movementRobotTwo = api.apiRobotsRobotIdGet(robotTwoID).getMovementRate().intValue();
        int startingRobot;

        if (movementRobotOne > movementRobotTwo) {
            startingRobot = 1;
        } else {
            startingRobot = 2;
        }
        return startingRobot;
    }
}
