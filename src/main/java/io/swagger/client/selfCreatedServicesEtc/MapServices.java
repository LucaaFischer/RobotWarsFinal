package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;

import java.io.IOException;
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
        System.out.println("Hellow");
        //System.out.println(getMap(api, mapID));

    }
}
