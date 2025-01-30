package io.swagger.client.selfCreatedServicesEtc.Game;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Move;
import io.swagger.client.selfCreatedServicesEtc.LocalRobots.LocalRobot;
import io.swagger.client.selfCreatedServicesEtc.LocalRobots.PrintStats;
import io.swagger.client.selfCreatedServicesEtc.WaitForEnemy;

import java.util.List;

public class MainGame {
    public static void playGame(DefaultApi api, String gameId, String mapId, String firstRobotId, String firstPlayerId,
                                String secondRobotId, String secondPlayerId,
                                LocalRobot firstRobot, LocalRobot secondRobot) throws ApiException {
        int countTurns = 0;

        System.out.println("Robot 1: " +firstRobot.getName());
        System.out.println("Robot 2: " +secondRobot.getName());

        while (countTurns < 100) {
            List<Move> previousMoves = api.apiGamesGameIdGet(gameId).getMoves();
            if (countTurns % 2 == 0) {
                if(firstRobot.getName().equals("You")) {
                    GameController.turn(api, gameId, mapId, firstRobotId, firstPlayerId, firstRobot, secondRobot);

                } else {
                    WaitForEnemy.wait(api, gameId, previousMoves.getLast().getId(), firstRobot, secondRobot, firstRobot.getMovementPoints().intValue(), 0);
                }

            } else {
                if(secondRobot.getName().equals("You")) {
                    GameController.turn(api, gameId, mapId, secondRobotId, secondPlayerId, secondRobot, firstRobot);
                } else {
                    WaitForEnemy.wait(api, gameId, previousMoves.getLast().getId(), secondRobot, firstRobot, secondRobot.getMovementPoints().intValue(), 0);
                }
            }
            PrintStats.printStats(firstRobot, secondRobot);
            countTurns++;
        }
    }
}
