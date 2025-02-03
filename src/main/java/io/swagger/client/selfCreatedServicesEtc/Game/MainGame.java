package io.swagger.client.selfCreatedServicesEtc.Game;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Move;
import io.swagger.client.selfCreatedServicesEtc.Combat.FightController;
import io.swagger.client.selfCreatedServicesEtc.LocalRobots.LocalRobot;
import io.swagger.client.selfCreatedServicesEtc.LocalRobots.PrintStats;

import java.util.List;

public class MainGame {
    public static void playGame(DefaultApi api, String gameId, String mapId, LocalRobot firstRobot, LocalRobot secondRobot)
            throws ApiException {
        int countTurns = 0;

        System.out.println("Robot 1: " +firstRobot.getName());
        System.out.println("Robot 2: " +secondRobot.getName());
        PrintStats.printStats(firstRobot, secondRobot);

        while (countTurns < 100 && !FightController.checkWin(firstRobot, secondRobot)) {
            List<Move> previousMoves = api.apiGamesGameIdGet(gameId).getMoves();
            if (countTurns % 2 == 0) {
                if(firstRobot.getName().equals("You")) {
                    GameController.turn(api, gameId, mapId, firstRobot.getUserId(), firstRobot, secondRobot);

                } else {
                    WaitForEnemy.wait(api, gameId, previousMoves.getLast().getId(), firstRobot, secondRobot, firstRobot.getMovementPoints().intValue());
                }

            } else {
                if(secondRobot.getName().equals("You")) {
                    GameController.turn(api, gameId, mapId, secondRobot.getUserId(), secondRobot, firstRobot);
                } else {
                    WaitForEnemy.wait(api, gameId, previousMoves.getLast().getId(), secondRobot, firstRobot, secondRobot.getMovementPoints().intValue());
                }
            }
            PrintStats.printStats(firstRobot, secondRobot);
            countTurns++;
        }
    }
}
