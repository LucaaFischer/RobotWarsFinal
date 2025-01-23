package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.MapMapItems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MapServices {
    public static List<Map> getMaps(DefaultApi api) throws ApiException {
        return api.apiMapsGet();
    }

    public static Map getMap(DefaultApi api, String mapID) throws ApiException {
        return api.apiMapsMapIdGet(mapID);
    }

    public static void printMap(DefaultApi api, String mapID) throws ApiException {
        List<Map<String, Object>> mapItems = (List<Map<String, Object>>) api.apiMapsMapIdGet(mapID).get("mapItems");
        double mapSize = (double) api.apiMapsMapIdGet(mapID).get("mapSize");
        double mapSizeX = (double) api.apiMapsMapIdGet(mapID).get("mapSizeX");
        String[] gameMap = new String[(int) mapSize];

        Arrays.fill(gameMap, "[   ]");

        for (Map<String, Object> item : mapItems) {
            int index = ((Double) item.get("index")).intValue();
            String type = (String) item.get("type");
            if (type.equals(MapMapItems.TypeEnum.ROBOT.toString())) {
                gameMap[index] = "[ R ]";
            } else if (type.equals(MapMapItems.TypeEnum.WALL.toString())) {
                gameMap[index] = "[///]";
            }
        }
        int index = 0;
        for (int i = 0; i < mapSize / mapSizeX; i++) {
            System.out.println();
            for (int j = 0; j < mapSizeX; j++) {
                System.out.print(gameMap[index]);
                index++;
            }
        }
    }
}
