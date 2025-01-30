package io.swagger.client;

import io.swagger.client.api.DefaultApi;
import io.swagger.client.selfCreatedServicesEtc.LocalRobots.LocalRobot;
import io.swagger.client.selfCreatedServicesEtc.Services.MapServices;

public class CheckAttackPossible {
    public static boolean attackPossible(DefaultApi api, String mapId, LocalRobot robotTurn, LocalRobot robotNotTurn) throws ApiException {
        double mapSizeX = (double) api.apiMapsMapIdGet(mapId).get("mapSizeX");
        int tempX = MapServices.getCoordinates(robotTurn.getIndex(),(int) mapSizeX)[0];
        int tempY = MapServices.getCoordinates(robotTurn.getIndex(), (int) mapSizeX)[1];

        int robotNotTurnX = MapServices.getCoordinates(robotNotTurn.getIndex(), (int) mapSizeX)[0];
        int robotNotTurnY = MapServices.getCoordinates(robotNotTurn.getIndex(), (int) mapSizeX)[1];

        for (int i = 1; i <= robotTurn.getRange(); i++) {
            tempX += robotTurn.getDirection().x;
            tempY += robotTurn.getDirection().y;
            if (tempX == robotNotTurnX && tempY == robotNotTurnY) {
                return true;
            }
        }
        return false;
    }
}
