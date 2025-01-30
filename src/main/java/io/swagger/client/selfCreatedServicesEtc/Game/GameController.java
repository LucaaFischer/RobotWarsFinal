package io.swagger.client.selfCreatedServicesEtc.Game;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Game;
import io.swagger.client.model.MovementType;
import io.swagger.client.selfCreatedServicesEtc.LocalRobots.LocalRobot;
import io.swagger.client.selfCreatedServicesEtc.Services.MapServices;
import io.swagger.client.selfCreatedServicesEtc.Services.MoveServices;

import java.util.Scanner;

public class GameController {
    public static void turn(DefaultApi api, String gameId, String mapId, String robotID, String playerId, LocalRobot robotTurn, LocalRobot robotNotTurn)
            throws ApiException {
        Scanner input = new Scanner(System.in);
        String moveId = "";
        int movementThisRound = robotTurn.getMovementPoints().intValue();

        do {
            System.out.println("\n" + robotTurn.getName() + " turn");
            System.out.println("What wanna do? \n (1) Move \n (2) Align \n (3) Attack \n (4) end Move");
            String intendedAction = input.nextLine();

            if (intendedAction.equals("1")) {
                moveId = MoveServices.makeMove(api, gameId, playerId, mapId, robotTurn);
            } else if (intendedAction.equals("2")) {
                moveId = MoveServices.makeAlign(api, gameId, playerId, robotTurn);
            } else if (intendedAction.equals("3")) {
                moveId = MoveServices.attack(api, gameId, playerId, mapId, robotTurn, robotNotTurn);
            } else if (intendedAction.equals("4")) {
                moveId = MoveServices.endMove(api, gameId, playerId, robotTurn);
                movementThisRound = 0;
            }

            MapServices.printMap(api, gameId, robotTurn, robotNotTurn);
            robotTurn.setLastMoveId(moveId);
            movementThisRound--;
        } while (movementThisRound > 0);

        if (movementThisRound == 0 && !api.apiGamesGameIdGet(gameId).getMoves().getLast().getMovementType().equals(MovementType.END)) {
            MoveServices.endMove(api, gameId, playerId, robotTurn);
        }
    }

    public static boolean waitForStart(DefaultApi api, String gameId) throws InterruptedException, ApiException {
        while (!api.apiGamesGameIdGet(gameId).getStatus().equals(Game.StatusEnum.STARTED)) {
            System.out.println(api.apiGamesGameIdGet(gameId).getStatus());
            Thread.sleep(5000);
        }

        return true;
    }
}
