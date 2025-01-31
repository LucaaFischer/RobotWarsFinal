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
    public static void startGame(DefaultApi api, String gameId, String mapId) throws InterruptedException, ApiException {

        if (GameController.waitForStart(api, gameId)) {
            List<Move> firstMoves = api.apiGamesGameIdMoveGet(gameId);

            LocalRobot robotOne = new LocalRobot();
            LocalRobot robotTwo = new LocalRobot();

            List<PlayerRobot> playerRobots = api.apiGamesGameIdGet(gameId).getPlayer();

            String robotOneId = playerRobots.get(0).getRobotId();
            String robotTwoId = playerRobots.get(1).getRobotId();
            String playerOneId = playerRobots.get(0).getPlayerId();
            String playerTwoId = playerRobots.get(1).getPlayerId();

            setRobotStats(api, robotOne, robotOneId);
            setRobotStats(api, robotTwo, robotTwoId);

            String firstPlayerId, secondPlayerId;
            LocalRobot firstRobot, secondRobot;

            if (TurnOrder.getStartingRobot(robotOne, robotTwo) == 1) {
                firstRobot = robotOne;
                secondRobot = robotTwo;
                firstPlayerId = playerOneId;
                secondPlayerId = playerTwoId;
                firstRobot.setName("Enemy");
                firstRobot.setAvatar("E");
                secondRobot.setName("You");
                secondRobot.setAvatar("Y");

            } else {
                firstRobot = robotTwo;
                secondRobot = robotOne;
                firstPlayerId = playerTwoId;
                secondPlayerId = playerOneId;
                firstRobot.setName("You");
                firstRobot.setAvatar("Y");
                secondRobot.setName("Enemy");
                secondRobot.setAvatar("E");
            }

            firstRobot.setIndex(firstMoves.getFirst().getMapIndex().intValue());
            firstRobot.setLastMoveId(firstMoves.getFirst().getId());
            firstRobot.setAlign(Align.N);

            secondRobot.setIndex(firstMoves.getLast().getMapIndex().intValue());
            secondRobot.setLastMoveId(firstMoves.getLast().getId());
            secondRobot.setAlign(Align.N);

            MainGame.playGame(api, gameId, mapId, firstPlayerId, secondPlayerId, firstRobot, secondRobot);
        }
    }

    public static void setRobotStats(DefaultApi api, LocalRobot robot, String robotId) throws ApiException {
        robot.setMovementPoints(api.apiRobotsRobotIdGet(robotId).getMovementRate());
        robot.setHp(api.apiRobotsRobotIdGet(robotId).getHealth().intValue());
        robot.setDamage(api.apiRobotsRobotIdGet(robotId).getAttackDamage().intValue());
        robot.setRange(api.apiRobotsRobotIdGet(robotId).getAttackRange().intValue());
        robot.setDirection(Directions.NORTH);
    }
}
