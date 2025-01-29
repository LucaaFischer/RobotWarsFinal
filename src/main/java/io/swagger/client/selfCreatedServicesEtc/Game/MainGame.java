package io.swagger.client.selfCreatedServicesEtc.Game;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.selfCreatedServicesEtc.LocalRobots.LocalRobot;

public class MainGame {
    public static void playGame(DefaultApi api, String gameId, String mapId, String firstRobotId, String firstPlayerId,
                                String secondRobotId, String secondPlayerId,
                                LocalRobot firstRobot, LocalRobot secondRobot) throws ApiException {
        int countTurns = 0;

        while (countTurns < 100) {
            if (countTurns % 2 == 0) {
                GameController.turn(api, gameId, mapId, firstRobotId, firstPlayerId, firstRobot, secondRobot);
            } else {
                GameController.turn(api, gameId, mapId, secondRobotId, secondPlayerId, secondRobot, firstRobot);
            }
            countTurns++;
        }
    }
}
