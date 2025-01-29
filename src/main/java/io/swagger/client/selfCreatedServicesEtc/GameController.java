package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Game;

import java.util.Scanner;

public class GameController {
    public static void turn(DefaultApi api, String gameId, String mapId, String robotID, String playerId, LocalRobot robotTurn, LocalRobot robotNotTurn)
            throws ApiException {
        Scanner input = new Scanner(System.in);
        int movementThisRound = robotTurn.getMovementPoints().intValue();

        MapServices.printMap(api, gameId, robotTurn, robotNotTurn);
        String moveID = "invalid";

        do {
        System.out.println("Player " + playerId + " turn");
        System.out.println("What wanna do? \n (1) Move \n (2) Align \n (3) Attack");
        String intendedAction = input.nextLine();

            if (intendedAction.equals("1")) {
                moveID = MoveServices.makeMove(api, gameId, playerId, mapId, robotTurn);
            } else if (intendedAction.equals("2")) {
                System.out.println("index RobotTurn before align:" +robotTurn.getIndex());
                System.out.println("index RobotNotTurn before align" +robotNotTurn.getIndex());
                moveID = MoveServices.makeAlign(api, gameId, playerId, robotTurn);
            } else if (intendedAction.equals("3")) {
                moveID = MoveServices.attack(api, gameId, playerId, mapId, robotTurn);
            }

            MapServices.printMap(api, gameId, robotTurn, robotNotTurn);
            movementThisRound--;

            System.out.println("Moves left: " + movementThisRound);

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
