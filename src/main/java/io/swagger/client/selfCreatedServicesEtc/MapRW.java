package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.model.MapMapItems;

import java.util.List;

public class MapRW {
    private String id;
    private int mapSizeX;
    private int mapSize;
    private List<MapMapItems> mapItems;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMapSizeX() {
        return mapSizeX;
    }

    public void setMapSizeX(int mapSizeX) {
        this.mapSizeX = mapSizeX;
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public List<MapMapItems> getMapItems() {
        return mapItems;
    }

    public void setMapItems(List<MapMapItems> mapItems) {
        this.mapItems = mapItems;
    }
}
