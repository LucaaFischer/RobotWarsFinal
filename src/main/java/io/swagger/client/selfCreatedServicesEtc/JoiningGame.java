package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.selfCreatedServicesEtc.AskForIDs.AskForGameID;
import io.swagger.client.selfCreatedServicesEtc.AskForIDs.AskForRobotID;

public class JoiningGame {
    public static void join(DefaultApi api) throws ApiException, InterruptedException {
        String gameId = AskForGameID.askForID();
        String robotId = AskForRobotID.askForRobotID();

        String playerTwoId = GameServices.joinGame(api, gameId, robotId);
        System.out.println("PlayerIDTwo: " +playerTwoId);
        String mapId = api.apiGamesGameIdGet(gameId).getMap();

        GameStart.startGame(api, gameId, mapId);
    }
}
