package io.swagger.client.selfCreatedServicesEtc;

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
import io.swagger.client.selfCreatedServicesEtc.Services.MapServices;

public class ExecuteEnemyMove {
    public static void enemyMove(DefaultApi api, LocalRobot robot, String gameId) throws ApiException {
        Move move = api.apiGamesGameIdGet(gameId).getMoves().getLast();
        String mapId = api.apiGamesGameIdGet(gameId).getMap();
        int index = robot.getIndex();

        if (move.getMovementType().equals(MovementType.ALIGN)) {
            for (Align alignment : Align.values()) {
                if (alignment.getValue().equals(move.getAlign().getValue())) {
                    robot.setAlign(alignment);
                }
            }

        } else if (move.getMovementType().equals(MovementType.MOVE)) {
            double mapSizeX = (double) api.apiMapsMapIdGet(mapId).get("mapSizeX");
            int[] currCoordinates = MapServices.getCoordinates(index, (int) mapSizeX);
            int[] newCoordinates = new int[2];

            for (Directions direction : Directions.values()) {
                if (robot.getAlign().getValue().equals(direction.freddyKey)) {
                    newCoordinates[0] = currCoordinates[0] + direction.x;
                    newCoordinates[1] = currCoordinates[1] + direction.y;
                }
            }

            int newMapIndex = MapServices.coordinatesToMapIndex((int) mapSizeX, newCoordinates);
            robot.setAlign(robot.getAlign());
            robot.setIndex(newMapIndex);
        }
    }
}
