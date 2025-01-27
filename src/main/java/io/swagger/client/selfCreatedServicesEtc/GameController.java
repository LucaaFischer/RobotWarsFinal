package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Game;

import java.util.Scanner;

public class GameController {
    public static void turn(DefaultApi api, String gameId, String playerId, String mapId, String robotID, LocalRobot robot)
            throws ApiException {
        Scanner input = new Scanner(System.in);
        int movementThisRound = robot.getMovementPoints().intValue();

        MapServices.printMap(api, mapId);
        String moveID = "invalid";

        do {
        System.out.println("What wanna do? \n (1) Move \n (2) Align \n (3) Attack");
        String intendedAction = input.nextLine();

            if (intendedAction.equals("1")) {
                moveID = MoveServices.makeMove(api, gameId, playerId, mapId, robot);
            } else if (intendedAction.equals("2")) {
                moveID = MoveServices.makeAlign(api, gameId, playerId, robot);
            } else if (intendedAction.equals("3")) {
                moveID = MoveServices.attack(api, gameId, playerId, mapId, robot);
            }

            MapServices.printMap(api, mapId);
            movementThisRound--;

            //debugging//
            System.out.println("move " + moveID);
            System.out.println("player " + playerId);
            System.out.println("robot" + robotID);

        } while (movementThisRound > 0);

        //MoveServices.getMovesAfter(api, moveID);
    }

    public static boolean waitForStart(DefaultApi api, String gameId) throws InterruptedException, ApiException {
        while (!api.apiGamesGameIdGet(gameId).getStatus().equals(Game.StatusEnum.STARTED)) {
            System.out.println(api.apiGamesGameIdGet(gameId).getStatus());
            Thread.sleep(5000);
        }

        return true;
    }
}
