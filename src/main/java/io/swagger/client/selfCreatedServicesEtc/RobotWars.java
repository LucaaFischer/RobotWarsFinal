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
            GameCreation.create(api);
        } else if (choice == 4) {
            JoiningGame.join(api);
        } else if (choice == 5) {
            System.out.println(RobotServices.getRobots(api));
        } else if (choice == 6) {
           System.out.println(RobotServices.getSpecificBot(input, api, Objects.requireNonNull(RobotServices.getRobots(api))));
        } else if (choice == 7) {
            RobotServices.createRobot(api, input);
        }
    }

    public static void startGame(DefaultApi api, String gameId, String mapId)
            throws InterruptedException, ApiException {

        if(GameController.waitForStart(api, gameId)) {
            double indexRobotTwo = (double) api.apiMapsMapIdGet(mapId).get("mapSize");

            LocalRobot robotOne = new LocalRobot(0);
            LocalRobot robotTwo = new LocalRobot((int)indexRobotTwo -1);

            List<String> robotIds = new ArrayList<>();
            List<String> playerIds = new ArrayList<>();
            List<PlayerRobot> robots = api.apiGamesGameIdGet(gameId).getPlayer();
            for (PlayerRobot robot: robots) {
                robotIds.add(robot.getRobotId());
                playerIds.add(robot.getPlayerId());
            }

            String robotOneId = robotIds.get(0);
            robotOne.setMovementPoints(api.apiRobotsRobotIdGet(robotOneId).getMovementRate());

            String robotTwoId = robotIds.get(1);
            robotTwo.setMovementPoints(api.apiRobotsRobotIdGet(robotTwoId).getMovementRate());

            String playerOneId = playerIds.get(0);
            String playerTwoId = playerIds.get(1);

            if (TurnOrder.getStartingRobot(api, robotOneId, robotTwoId) == 1) {
                GameController.turn(api, gameId, playerOneId, mapId, robotOneId, robotOne);
            } else {
                GameController.turn(api, gameId, playerTwoId, mapId, robotTwoId, robotTwo);
            }
        }
    }
}



