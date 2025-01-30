package io.swagger.client.selfCreatedServicesEtc.Game;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Align;
import io.swagger.client.model.Move;
import io.swagger.client.model.PlayerRobot;
import io.swagger.client.selfCreatedServicesEtc.Directions.Directions;
import io.swagger.client.selfCreatedServicesEtc.LocalRobots.LocalRobot;

import java.util.List;

public class GameStart {
    public static void startGame(DefaultApi api, String gameId, String mapId, String playerOneId, String playerTwoId)
            throws InterruptedException, ApiException {

        if (GameController.waitForStart(api, gameId)) {
            List<Move> firstMoves = api.apiGamesGameIdMoveGet(gameId);

            LocalRobot robotOne = new LocalRobot();
            LocalRobot robotTwo = new LocalRobot();

            List<PlayerRobot> playerRobots = api.apiGamesGameIdGet(gameId).getPlayer();

            String robotOneId = playerRobots.get(0).getRobotId();
            String robotTwoId = playerRobots.get(1).getRobotId();

            robotOne.setMovementPoints(api.apiRobotsRobotIdGet(robotOneId).getMovementRate());
            robotOne.setHp(api.apiRobotsRobotIdGet(robotOneId).getHealth().intValue());
            robotOne.setDamage(api.apiRobotsRobotIdGet(robotOneId).getAttackDamage().intValue());
            robotOne.setRange(api.apiRobotsRobotIdGet(robotOneId).getAttackRange().intValue());
            robotOne.setDirection(Directions.NORTH);

            robotTwo.setMovementPoints(api.apiRobotsRobotIdGet(robotTwoId).getMovementRate());
            robotTwo.setHp(api.apiRobotsRobotIdGet(robotTwoId).getHealth().intValue());
            robotTwo.setDamage(api.apiRobotsRobotIdGet(robotTwoId).getAttackDamage().intValue());
            robotTwo.setRange(api.apiRobotsRobotIdGet(robotTwoId).getAttackRange().intValue());
            robotTwo.setDirection(Directions.NORTH);

            String firstRobotId, secondRobotId, firstPlayerId, secondPlayerId;
            LocalRobot firstRobot, secondRobot;

            if (TurnOrder.getStartingRobot(robotOne, robotTwo) == 1) {
                firstRobot = robotOne;
                secondRobot = robotTwo;
                firstRobotId = robotOneId;
                secondRobotId = robotTwoId;
                firstPlayerId = playerOneId;
                secondPlayerId = playerTwoId;
                firstRobot.setName("Enemy");
                firstRobot.setAvatar("E");
                secondRobot.setName("You");
                secondRobot.setAvatar("Y");
            } else {
                firstRobot = robotTwo;
                secondRobot = robotOne;
                firstRobotId = robotTwoId;
                secondRobotId = robotOneId;
                firstPlayerId = playerTwoId;
                secondPlayerId = playerOneId;
                firstRobot.setName("You");
                firstRobot.setAvatar("Y");
                secondRobot.setName("Enemy");
                secondRobot.setAvatar("E");
            }

            firstRobot.setIndex(firstMoves.get(0).getMapIndex().intValue());
            firstRobot.setLastMoveId(firstMoves.get(0).getId());
            secondRobot.setIndex(firstMoves.get(1).getMapIndex().intValue());
            secondRobot.setLastMoveId(firstMoves.get(1).getId());
            firstRobot.setAlign(Align.N);
            secondRobot.setAlign(Align.N);

            MainGame.playGame(api, gameId, mapId, firstRobotId, firstPlayerId, secondRobotId, secondPlayerId, firstRobot, secondRobot);
        }
    }
}
