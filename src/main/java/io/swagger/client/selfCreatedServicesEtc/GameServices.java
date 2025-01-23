package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.*;

import java.util.List;

public class GameServices {
    public static String createGame(DefaultApi api, String mapId) throws ApiException {
        NewGame newGame = new NewGame();
        newGame.setMapId(mapId);

        return api.apiGamesGamePost(newGame).getId();
    }

    public static void joinGame(DefaultApi api, String gameId, String robotId) {
        JoinGame joinGame = new JoinGame();
        joinGame.setRobotId(robotId);
        try {
            api.apiGamesGameIdJoinPost(joinGame, gameId);
            System.out.println("Sucessfully joined game: " + gameId);
        }
        catch (ApiException e) {
            System.out.println(e.getMessage());
        }
    }
    public static List<Game> getAllGames(DefaultApi api) throws ApiException {
        return api.apiGamesGet();
    }

    public static Game getGame(DefaultApi api, String gameId) throws ApiException {
       return api.apiGamesGameIdGet(gameId);
    }
}
