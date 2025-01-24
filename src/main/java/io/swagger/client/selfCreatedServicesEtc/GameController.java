package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Game;

import java.io.IOException;

public class GameController {
    public static void playGame(DefaultApi api, String gameId, String playerId, String mapId, String robotOneID,
                                String robotTwoID, LocalRobot robotOne, LocalRobot robotTwo) throws ApiException {
        MapServices.printMap(api, mapId);
        String moveID;

        if (getStartingRobot(api, robotOneID, robotTwoID) == 1) {
            moveID = MoveServices.makeMove(api, gameId, playerId, mapId, robotOne);
        } else {
            moveID = MoveServices.makeMove(api, gameId, playerId, mapId, robotTwo);
        }

        MapServices.printMap(api, mapId);
        //MoveServices.getMovesAfter(api, moveID);
    }

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

    public static boolean waitForStart(DefaultApi api, String gameId) throws InterruptedException, ApiException {
        while(!api.apiGamesGameIdGet(gameId).getStatus().equals(Game.StatusEnum.STARTED)) {
            System.out.println(api.apiGamesGameIdGet(gameId).getStatus());
            Thread.sleep(5000);
        }

        return true;
    }
}
