package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.PlayerRobot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class RobotWars {
    public static void main(String[] args) throws ApiException, IOException, InterruptedException {
        Scanner input = new Scanner(System.in);
        DefaultApi api = new DefaultApi();

        System.out.println("What u wanna do?" +
                " 1. See all Games " +
                " 2. See specific Game " +
                " 3. Create Game" +
                " 4. Join Game" +
                " 5. See every robot in da whole universe" +
                " 6. See a single robot" +
                " 7. Create new Robot");

        int choice = input.nextInt();

        input.nextLine();

        if (choice == 1) {
            System.out.println(GameServices.getAllGames(api));

        } else if (choice == 2) {
            System.out.println("GameID?");
            String gameID = input.nextLine();
            System.out.println(GameServices.getGame(api, gameID));
        }

        else if (choice == 3) {
            System.out.println("MapId: ");
            String mapId = input.nextLine();
            System.out.println("Which robot u wanna use?: ");
            String robotId = input.nextLine();

            String gameId = GameServices.createGame(api, mapId);
            System.out.println("GameID: " +gameId);

            String playerId = GameServices.joinGame(api, gameId, robotId);

            startGame(api, gameId, mapId, playerId);

        } else if (choice == 4) {
            System.out.println("Enter gameId");
            String gameId = input.nextLine();
            System.out.println("Enter robotId");
            String robotId = input.nextLine();

            String playerId = GameServices.joinGame(api, gameId, robotId);
            String mapId = api.apiGamesGameIdGet(gameId).getMap();

            startGame(api, gameId, mapId, playerId);

        } else if (choice == 5) {
            System.out.println(RobotServices.getRobots(api));

        } else if (choice == 6) {
           System.out.println(RobotServices.getSpecificBot(input, api, Objects.requireNonNull(RobotServices.getRobots(api))));

        } else if (choice == 7) {
            RobotServices.createRobot(api, input);
        }
    }

    private static void startGame(DefaultApi api, String gameId, String mapId, String playerId)
            throws IOException, InterruptedException, ApiException {

        if(GameController.waitForStart(api, gameId)) {
            double indexRobotTwo = (double) api.apiMapsMapIdGet(mapId).get("mapSize");

            LocalRobot robotOne = new LocalRobot(1);
            LocalRobot robotTwo = new LocalRobot((int)indexRobotTwo);

            List<String> robotIds = new ArrayList<>();
            List<PlayerRobot> robots = api.apiGamesGameIdGet(gameId).getPlayer();
            for (PlayerRobot robot: robots) {
                robotIds.add(robot.getRobotId());
            }

            String robotOneIdD = robotIds.get(0);
            String robotTwoIdD = robotIds.get(1);

           GameController.playGame(api, gameId, playerId, mapId, robotOneIdD, robotTwoIdD, robotOne, robotTwo);
        }
    }
}



