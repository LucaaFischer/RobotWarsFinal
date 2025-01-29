package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.selfCreatedServicesEtc.AskForIDs.AskForGameID;

import java.util.*;

public class RobotWars {
    public static void main(String[] args) throws ApiException, InterruptedException {
        DefaultApi api = new DefaultApi();
        int choice = MenuOverview.overview();

        if (choice == 1) {
            System.out.println(GameServices.getAllGames(api));

        } else if (choice == 2) {
            String gameID = AskForGameID.askForID();
            System.out.println(GameServices.getGame(api, gameID));
        }

        else if (choice == 3) {
            GameCreation.create(api);

        } else if (choice == 4) {
            JoiningGame.join(api);

        } else if (choice == 5) {
            System.out.println(RobotServices.getRobots(api));

        } else if (choice == 6) {
           System.out.println(RobotServices.getSpecificBot(api, Objects.requireNonNull(RobotServices.getRobots(api))));

        } else if (choice == 7) {
            RobotServices.createRobot(api);
        }
    }
}



