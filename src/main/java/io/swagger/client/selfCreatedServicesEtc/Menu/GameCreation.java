package io.swagger.client.selfCreatedServicesEtc.Menu;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.selfCreatedServicesEtc.AskForIDs.AskForMapID;
import io.swagger.client.selfCreatedServicesEtc.AskForIDs.AskForRobotID;
import io.swagger.client.selfCreatedServicesEtc.Game.GameStart;
import io.swagger.client.selfCreatedServicesEtc.Services.GameServices;

public class GameCreation {
    public static void create(DefaultApi api) throws ApiException, InterruptedException {
        String mapId = AskForMapID.askForMapID();

        String robotId = AskForRobotID.askForRobotID();

        String gameId = GameServices.createGame(api, mapId);
        System.out.println("GameID: " + gameId);

        String playerId = GameServices.joinGame(api, gameId, robotId);
        System.out.println("PlayerID: " + playerId);

        GameStart.startGame(api, gameId, mapId);
    }
}
