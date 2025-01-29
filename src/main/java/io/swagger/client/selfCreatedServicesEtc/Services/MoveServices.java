package io.swagger.client.selfCreatedServicesEtc.Services;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Align;
import io.swagger.client.model.Move;
import io.swagger.client.model.MovementType;
import io.swagger.client.model.NewMove;
import io.swagger.client.selfCreatedServicesEtc.Directions.AskForDirection;
import io.swagger.client.selfCreatedServicesEtc.Directions.Directions;
import io.swagger.client.selfCreatedServicesEtc.Directions.InvertDirections;
import io.swagger.client.selfCreatedServicesEtc.LocalRobots.LocalRobot;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class MoveServices {
    public List<Move> getMoveAfter(DefaultApi api, String moveID) throws ApiException {
        return api.apiGamesGameIdMoveGet(moveID);
    }

    public static String makeMove(DefaultApi api, String gameID, String playerID, String mapId, LocalRobot robot) throws ApiException {
        Scanner input = new Scanner(System.in);
        int index = robot.getIndex();

        try {
            double mapSizeX = (double) api.apiMapsMapIdGet(mapId).get("mapSizeX");
            int[] currCoordinates = MapServices.getCoordinates(index, (int) mapSizeX);
            int[] newCoordinates = new int[2];

            NewMove newMove = new NewMove();

            System.out.println("Where u wanna move?");
            AskForDirection.whichDirection();

            String intendedMove = input.nextLine();
            Align align = Align.NW;

            for (Directions direction : Directions.values()) {
                if (intendedMove.equalsIgnoreCase(direction.key)) {
                    newCoordinates[0] = currCoordinates[0] + direction.x;
                    newCoordinates[1] = currCoordinates[1] + direction.y;
                    align = InvertDirections.invertDirection(direction);
                }
            }

            BigDecimal newMapIndex = BigDecimal.valueOf(MapServices.coordinatesToMapIndex((int) mapSizeX, newCoordinates));

            robot.setIndex(newMapIndex.intValue());
            robot.setAlign(align);
            newMove.setMapIndex(newMapIndex);
            newMove.setPlayerId(playerID);
            newMove.setMovementType(MovementType.MOVE);
            newMove.setAlign(align);

            System.out.println(playerID);
            System.out.println(MovementType.MOVE.getValue());
            System.out.println(align.toString());

            return api.apiGamesGameIdMovePlayerPlayerIdPost(newMove, gameID, playerID).getId();
        } catch (ApiException e) {
            System.out.println(e.getResponseBody());
        }
        return null;
    }

    public static String makeAlign(DefaultApi api, String gameID, String playerID, LocalRobot robot) {
        try {
            Scanner input = new Scanner(System.in);
            String intendedMove;
            NewMove newMove = new NewMove();
            System.out.println("Where u wanna align?");
            AskForDirection.whichDirection();

            intendedMove = input.nextLine();

            Align align = Align.NW;

            for (Directions direction : Directions.values()) {
                if (intendedMove.equalsIgnoreCase(direction.key)) {
                    align = InvertDirections.invertDirection(direction);
                }
            }

            robot.setIndex(robot.getIndex());
            robot.setAlign(align);
            newMove.setAlign(align);
            newMove.setPlayerId(playerID);
            newMove.setMapIndex(BigDecimal.valueOf(robot.getIndex()));
            newMove.setMovementType(MovementType.ALIGN);

            System.out.println("NewMove MapIndex" +newMove.getMapIndex());

            return api.apiGamesGameIdMovePlayerPlayerIdPost(newMove, gameID, playerID).getId();
        }
        catch (ApiException e) {
            System.out.println(e.getResponseBody());
        }
        return null;
    }

    public static String endMove(DefaultApi api, String gameID, String playerId, LocalRobot robot) throws ApiException {
        NewMove newMove = new NewMove();

        robot.setIndex(robot.getIndex());
        newMove.setAlign(robot.getAlign());
        newMove.setPlayerId(playerId);
        newMove.setMapIndex(BigDecimal.valueOf(robot.getIndex()));
        newMove.setMovementType(MovementType.END);

        return api.apiGamesGameIdMovePlayerPlayerIdPost(newMove, gameID, playerId).getId();
    }

    public static String attack(DefaultApi api, String gameId, String playerId, String mapId, LocalRobot robotOne) {
        return "UwU";
    }

    public static List<Move> getMovesAfter(DefaultApi api, String moveID) throws ApiException {
        return api.apiGamesGameIdMoveGet(moveID);
    }
}
