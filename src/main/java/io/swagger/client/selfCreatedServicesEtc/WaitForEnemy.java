package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Move;
import io.swagger.client.model.MovementType;
import io.swagger.client.selfCreatedServicesEtc.LocalRobots.LocalRobot;
import io.swagger.client.selfCreatedServicesEtc.Services.MapServices;
import io.swagger.client.selfCreatedServicesEtc.Services.MoveServices;

import java.util.List;

public class WaitForEnemy {
    public static void wait(DefaultApi api, String gameId, String moveId, LocalRobot enemyRobot, LocalRobot yourRobot, int movementThisTurn, int counter)
            throws ApiException {
        do {
            List<Move> moves = MoveServices.getMovesAfter(api, gameId, moveId);

            if (moves.isEmpty() || moveId.equals(moves.getLast().getId())) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                continue;
            }

            System.out.println("Enemy's turn. Waiting for move...");
            moveId = moves.getLast().getId();
            enemyRobot.setLastMoveId(moveId);
            ExecuteEnemyMove.enemyMove(api, enemyRobot, gameId);
            MapServices.printMap(api, gameId, enemyRobot, yourRobot);
            System.out.println("\nEnemy made move: " + moves.getLast().getMovementType());
            System.out.println("He's now on Field " +moves.getLast().getMapIndex());
            movementThisTurn--;

            if (moves.getLast().getMovementType().equals(MovementType.END) && counter > 0) {
                break;
            }

            counter++;
        } while (movementThisTurn > 0);
    }
}
