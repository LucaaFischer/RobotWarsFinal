package io.swagger.client.selfCreatedServicesEtc.Menu;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.PlayerRobot;
import io.swagger.client.selfCreatedServicesEtc.AskForIDs.AskForGameID;
import io.swagger.client.selfCreatedServicesEtc.AskForIDs.AskForRobotID;
import io.swagger.client.selfCreatedServicesEtc.Game.GameStart;
import io.swagger.client.selfCreatedServicesEtc.Services.GameServices;

import java.util.List;

public class JoiningGame {
    public static void join(DefaultApi api, String gameId) throws ApiException, InterruptedException {
        String robotId = AskForRobotID.askForRobotID();

        String yourPlayerId = GameServices.joinGame(api, gameId, robotId);
        System.out.println("PlayerID: " +yourPlayerId);
        String mapId = api.apiGamesGameIdGet(gameId).getMap();

        GameStart.startGame(api, gameId, mapId, yourPlayerId);
    }
}
