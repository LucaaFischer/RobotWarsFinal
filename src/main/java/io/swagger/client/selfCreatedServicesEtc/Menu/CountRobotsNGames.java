package io.swagger.client.selfCreatedServicesEtc.Menu;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Game;
import io.swagger.client.model.Robot;

import java.util.List;

public class CountRobotsNGames {
    public static void findTrash(DefaultApi api) throws ApiException {
        int countGames = 0;
        int countRobots = 0;

        //List<Game> games = api.apiGamesGet();
        List<Robot> robots = api.apiRobotsGet();
        /*for (Game game : games) {
            countGames++;
        }*/

        for (Robot robot : robots) {
            countRobots++;
        }

        System.out.println("Robots: " + countRobots);
        //System.out.println("Games: " + countGames);
    }
}
