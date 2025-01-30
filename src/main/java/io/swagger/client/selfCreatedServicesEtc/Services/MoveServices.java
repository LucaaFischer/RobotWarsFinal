package io.swagger.client.selfCreatedServicesEtc.Services;

import io.swagger.client.ApiException;
import io.swagger.client.CheckAttackPossible;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Align;
import io.swagger.client.model.Move;
import io.swagger.client.model.MovementType;
import io.swagger.client.model.NewMove;
import io.swagger.client.selfCreatedServicesEtc.AttackNotPossible;
import io.swagger.client.selfCreatedServicesEtc.Combat.FightController;
import io.swagger.client.selfCreatedServicesEtc.Combat.FightView;
import io.swagger.client.selfCreatedServicesEtc.Directions.AskForDirection;
import io.swagger.client.selfCreatedServicesEtc.Directions.Directions;
import io.swagger.client.selfCreatedServicesEtc.Directions.InvertDirections;
import io.swagger.client.selfCreatedServicesEtc.Game.MainGame;
import io.swagger.client.selfCreatedServicesEtc.LocalRobots.LocalRobot;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class MoveServices {
    public List<Move> getMoveAfter(DefaultApi api, String moveID) throws ApiException {
        return api.apiGamesGameIdMoveGet(moveID);
    }

    public static String makeMove(DefaultApi api, String gameID, String playerID, String mapId, LocalRobot robot) {
        Scanner input = new Scanner(System.in);
        int index = robot.getIndex();

        try {
            double mapSizeX = (double) api.apiMapsMapIdGet(mapId).get("mapSizeX");
            int[] currCoordinates = MapServices.getCoordinates(index, (int) mapSizeX);
            int[] newCoordinates = new int[2];
            Align align = Align.NW;

            System.out.println("Where u wanna move?");
            AskForDirection.whichDirection();

            String intendedMove = input.nextLine();

            for (Directions direction : Directions.values()) {
                if (intendedMove.equalsIgnoreCase(direction.key)) {
                    newCoordinates[0] = currCoordinates[0] + direction.x;
                    newCoordinates[1] = currCoordinates[1] + direction.y;
                    align = InvertDirections.invertDirection(direction);
                }
            }

            int newMapIndex = MapServices.coordinatesToMapIndex((int) mapSizeX, newCoordinates);

            NewMove newMove = newMoveTemplate(playerID, newMapIndex, align, MovementType.MOVE);
            String moveId = api.apiGamesGameIdMovePlayerPlayerIdPost(newMove, gameID, playerID).getId();

            robot.setIndex(newMapIndex);
            robot.setAlign(align);

            return moveId;

        } catch (ApiException e) {
            System.out.println(e.getResponseBody());
        }
        return null;
    }

    public static String makeAlign(DefaultApi api, String gameID, String playerId, LocalRobot robot) {
        try {
            Scanner input = new Scanner(System.in);
            String intendedMove;
            System.out.println("Where u wanna align?");
            AskForDirection.whichDirection();

            intendedMove = input.nextLine();

            Align align = Align.NW;

            for (Directions direction : Directions.values()) {
                if (intendedMove.equalsIgnoreCase(direction.key)) {
                    align = InvertDirections.invertDirection(direction);
                    robot.setDirection(direction);
                }
            }

            robot.setIndex(robot.getIndex());
            robot.setAlign(align);

            NewMove newMove = newMoveTemplate(playerId, robot.getIndex(), align, MovementType.ALIGN);

            return api.apiGamesGameIdMovePlayerPlayerIdPost(newMove, gameID, playerId).getId();

        } catch (ApiException e) {
            System.out.println(e.getResponseBody());
        }
        return null;
    }

    public static String attack(DefaultApi api, String gameId, String playerId, String mapId, LocalRobot robotTurn, LocalRobot robotNotTurn) {
        String moveId = null;
        try {
            if (CheckAttackPossible.attackPossible(api, mapId, robotTurn, robotNotTurn)) {
                FightController.fight(robotTurn, robotNotTurn);

                NewMove newMove = newMoveTemplate(playerId, robotTurn.getIndex(), robotTurn.getAlign(), MovementType.ATTACK);

                moveId = api.apiGamesGameIdMovePlayerPlayerIdPost(newMove, gameId, playerId).getId();
            } else {
                AttackNotPossible.message();
            }
        } catch (ApiException e) {
            System.out.println(e.getResponseBody());
        }
        return moveId;
    }

    public static String endMove(DefaultApi api, String gameID, String playerId, LocalRobot robot) {
        try {
            NewMove newMove = newMoveTemplate(playerId, robot.getIndex(), robot.getAlign(), MovementType.END);
            return api.apiGamesGameIdMovePlayerPlayerIdPost(newMove, gameID, playerId).getId();
        } catch (ApiException e) {
            System.out.println(e.getResponseBody());
        }
        return null;
    }

    public static List<Move> getMovesAfter(DefaultApi api, String gameId, String moveId) throws ApiException {
        return api.apiGamesGameIdMoveMoveIdAfterGet(gameId, moveId);
    }

    public static NewMove newMoveTemplate(String playerId, int newMapIndex, Align align, MovementType movementType) {
        NewMove newMove = new NewMove();
        newMove.setPlayerId(playerId);
        newMove.setMapIndex(BigDecimal.valueOf(newMapIndex));
        newMove.setAlign(align);
        newMove.setMovementType(movementType);

        return newMove;
    }
}
