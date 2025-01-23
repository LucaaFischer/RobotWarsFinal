package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Game;

import java.io.IOException;

public class GameController {
    public static void playGame(DefaultApi api, String gameId) throws IOException, InterruptedException, ApiException {
        while(!api.apiGamesGameIdGet(gameId).getStatus().equals(Game.StatusEnum.STARTED)) {
            System.out.println(api.apiGamesGameIdGet(gameId).getStatus());
            Thread.sleep(5000);
        }

        System.out.println("Hellow");
        //MapServices.printMap(api, mapID);
    }
}
