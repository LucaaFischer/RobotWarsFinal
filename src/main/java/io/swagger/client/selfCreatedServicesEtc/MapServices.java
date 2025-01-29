package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.MapMapItems;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MapServices {
    public static String[] printMap(DefaultApi api, String gameId, LocalRobot robot, LocalRobot robotTwo) throws ApiException {
        String mapID = api.apiGamesGameIdGet(gameId).getMap();
        List<Map<String, Object>> mapItems = (List<Map<String, Object>>) api.apiMapsMapIdGet(mapID).get("mapItems");

        double mapSize = (double) api.apiMapsMapIdGet(mapID).get("mapSize");
        double mapSizeX = (double) api.apiMapsMapIdGet(mapID).get("mapSizeX");
        String[] gameMap = new String[(int) mapSize];

        Arrays.fill(gameMap, "[   ]");

        for (Map<String, Object> item : mapItems) {
            int index = ((Double) item.get("index")).intValue();
            String type = (String) item.get("type");
            if (type.equals(MapMapItems.TypeEnum.WALL.toString())) {
                gameMap[index] = "[///]";
            }
        }

        int index = 0;
        for (int i = 0; i < mapSize / mapSizeX; i++) {
            System.out.println();
            for (int j = 0; j < mapSizeX; j++) {
                if (index == robot.getIndex() || index == robotTwo.getIndex()) {
                    System.out.print("[ R ]");
                } else {
                    System.out.print(gameMap[index]);
                }
                index++;
            }
        }
        return gameMap;
    }

    public static int[] getCoordinates(int index, int mapSizeX) {
        int x = index % mapSizeX;
        int y = index / mapSizeX;

        return new int[]{x, y};
    }

    public static int coordinatesToMapIndex(int mapSizeX, int[] coordinates) {
        return coordinates[1] * mapSizeX + coordinates[0];
    }

    public static List<Map> getMaps(DefaultApi api) throws ApiException {
        return api.apiMapsGet();
    }

    public static Map getMap(DefaultApi api, String mapID) throws ApiException {
        return api.apiMapsMapIdGet(mapID);
    }
}
