package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Align;
import io.swagger.client.model.Move;
import io.swagger.client.model.MovementType;
import io.swagger.client.model.NewMove;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class MoveServices {
    public List<Move> getMoveAfter(DefaultApi api, String moveID) throws ApiException {
        return api.apiGamesGameIdMoveGet(moveID);
    }

    public static String makeMove(DefaultApi api, String gameID, String playerID, String mapId, LocalRobot robotTurn) throws ApiException {
        Scanner input = new Scanner(System.in);
        int index = robotTurn.getIndex();

        double mapSizeX = (double) api.apiMapsMapIdGet(mapId).get("mapSizeX");
        double mapSize = (double) api.apiMapsMapIdGet(mapId).get("mapSize");

        int[] currCoordinates = MapServices.getCoordinates(index, (int) mapSizeX);
        int[] newCoordinates = new int[2];

        NewMove newMove = new NewMove();

        System.out.println("Where u wanna move?");
        System.out.println("North (W) \n" +
                "North-East (E) \n" +
                "East (D) \n" +
                "South-East (X) \n" +
                "South (S) \n" +
                "South-West (Y) \n" +
                "West (A) \n" +
                "North-West (Q) \n \n" +
                "or stay on current field (B)");

        String intendedMove = input.nextLine();
        Align align = Align.NW;

        for (Directions direction : Directions.values()) {
            if(intendedMove.equalsIgnoreCase(direction.key)) {
                newCoordinates[0] = currCoordinates[0] + direction.x;
                newCoordinates[1] = currCoordinates[1] + direction.y;
                align = invertDirection(direction);
            }
        }

        BigDecimal newMapIndex = BigDecimal.valueOf(MapServices.coordinatesToMapIndex((int)mapSizeX, newCoordinates));
        robotTurn.setIndex(newMapIndex.intValue());
        newMove.setMapIndex(newMapIndex);
        newMove.setPlayerId(playerID);
        newMove.setMovementType(MovementType.MOVE);
        newMove.setAlign(align);


        System.out.println(playerID);
        System.out.println(MovementType.MOVE.getValue());
        System.out.println(align.toString());

        return api.apiGamesGameIdMovePlayerPlayerIdPost(newMove, gameID, playerID).getId();
    }

    public void makeAlign(DefaultApi api, String gameID, String playerID) throws ApiException {
        NewMove newMove = new NewMove();
        System.out.println("Where u wanna align?");
        System.out.println("North (W) \n" +
                "North-East (E) \n" +
                "East (D) \n" +
                "South-East (X) \n" +
                "South (S) \n" +
                "South-West (Y) \n" +
                "West (A) \n" +
                "North-West (Q) \n \n" +
                "or stay on current field (B)");

        newMove.setMapIndex(newMove.getMapIndex());
        //newMove.setAlign(invertAlignment());
        api.apiGamesGameIdMovePlayerPlayerIdPost(newMove, gameID, playerID);
    }

    public static List<Move> getMovesAfter(DefaultApi api, String moveID) throws ApiException {
        return api.apiGamesGameIdMoveGet(moveID);
    }

    public static Align invertDirection(Directions alignment) {
        for (Align align : Align.values()) {
            if (Objects.equals(alignment.freddyKey, align.getValue())) {
                return align;
            }
        }
        return null;
    }

    public static Directions invertAlign(Align align) {
        for (Directions direction : Directions.values()) {
            if (Objects.equals(direction.freddyKey, align.getValue())) {
                return direction;
            }
        }
        return null;
    }
}
