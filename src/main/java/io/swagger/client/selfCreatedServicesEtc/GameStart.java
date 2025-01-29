package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Move;
import io.swagger.client.model.PlayerRobot;

import java.util.List;

public class GameStart {
    public static void startGame(DefaultApi api, String gameId, String mapId)
            throws InterruptedException, ApiException {

        if (GameController.waitForStart(api, gameId)) {
            List<Move> firstMoves = api.apiGamesGameIdMoveGet(gameId);

            LocalRobot robotOne = new LocalRobot();
            LocalRobot robotTwo = new LocalRobot();

            List<PlayerRobot> playerRobots = api.apiGamesGameIdGet(gameId).getPlayer();

            String robotOneId = playerRobots.get(0).getRobotId();
            String robotTwoId = playerRobots.get(1).getRobotId();
            String playerOneId = playerRobots.get(0).getPlayerId();
            String playerTwoId = playerRobots.get(1).getPlayerId();

            robotOne.setName("You");
            robotOne.setAvatar("Y");
            robotOne.setMovementPoints(api.apiRobotsRobotIdGet(robotOneId).getMovementRate());
            robotOne.setHp(api.apiRobotsRobotIdGet(robotOneId).getHealth().intValue());
            robotOne.setDamage(api.apiRobotsRobotIdGet(robotOneId).getAttackDamage().intValue());
            robotOne.setRange(api.apiRobotsRobotIdGet(robotOneId).getAttackRange().intValue());

            robotTwo.setName("Enemy");
            robotTwo.setAvatar("E");
            robotTwo.setMovementPoints(api.apiRobotsRobotIdGet(robotTwoId).getMovementRate());
            robotTwo.setHp(api.apiRobotsRobotIdGet(robotTwoId).getHealth().intValue());
            robotTwo.setDamage(api.apiRobotsRobotIdGet(robotTwoId).getAttackDamage().intValue());
            robotTwo.setRange(api.apiRobotsRobotIdGet(robotTwoId).getAttackRange().intValue());

            String firstRobotId, secondRobotId, firstPlayerId, secondPlayerId;
            LocalRobot firstRobot, secondRobot;

            if (TurnOrder.getStartingRobot(robotOne, robotTwo) == 1) {
                firstRobot = robotOne;
                secondRobot = robotTwo;
                firstRobotId = robotOneId;
                secondRobotId = robotTwoId;
                firstPlayerId = playerOneId;
                secondPlayerId = playerTwoId;
            } else {
                firstRobot = robotTwo;
                secondRobot = robotOne;
                firstRobotId = robotTwoId;
                secondRobotId = robotOneId;
                firstPlayerId = playerTwoId;
                secondPlayerId = playerOneId;
            }

            firstRobot.setIndex(firstMoves.get(0).getMapIndex().intValue());
            secondRobot.setIndex(firstMoves.get(1).getMapIndex().intValue());

            MainGame.playGame(api, gameId, mapId, firstRobotId, firstPlayerId, secondRobotId, secondPlayerId, firstRobot, secondRobot);
        }
    }
}
