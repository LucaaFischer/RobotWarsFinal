package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;

import java.io.IOException;
import java.util.Scanner;

public class GameCreation {
    public static void create(DefaultApi api) throws ApiException, InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("MapId: ");
        String mapId = input.nextLine();
        System.out.println("Which robot u wanna use?: ");
        String robotId = input.nextLine();

        String gameId = GameServices.createGame(api, mapId);
        System.out.println("GameID: " + gameId);

        String playerId = GameServices.joinGame(api, gameId, robotId);
        System.out.println("PlayerID: " + playerId);

        RobotWars.startGame(api, gameId, mapId);
    }
}
