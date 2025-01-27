package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;

import java.util.Scanner;

public class JoiningGame {
    public static void join(DefaultApi api) throws ApiException, InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter gameId");
        String gameId = input.nextLine();
        System.out.println("Enter robotId");
        String robotId = input.nextLine();

        String playerTwoId = GameServices.joinGame(api, gameId, robotId);
        System.out.println("PlayerIDTwo: " +playerTwoId);
        String mapId = api.apiGamesGameIdGet(gameId).getMap();

        RobotWars.startGame(api, gameId, mapId);
    }
}
