package io.swagger.client.selfCreatedServicesEtc.Menu;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.selfCreatedServicesEtc.AskForIDs.AskForMapID;
import io.swagger.client.selfCreatedServicesEtc.Services.GameServices;

public class GameCreation {
    public static void create(DefaultApi api) throws ApiException, InterruptedException {
        String mapId = AskForMapID.askForMapID();

        String gameId = GameServices.createGame(api, mapId);
        System.out.println("GameID: " + gameId);

        JoiningGame.join(api);
    }
}
