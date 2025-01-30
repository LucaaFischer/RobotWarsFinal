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
    public static void wait(DefaultApi api, String gameId, String moveId, LocalRobot enemyRobot, LocalRobot yourRobot, String playerId, int movementThisTurn)
            throws ApiException {
        do {
            if (moveId.equals(MoveServices.getMovesAfter(api, gameId, moveId).getLast().getId())) {
                wait(api, gameId, moveId, enemyRobot, yourRobot, playerId, movementThisTurn);
            } else {
                List<Move> moves = MoveServices.getMovesAfter(api, gameId, moveId);
                moveId = moves.getLast().getId();

                enemyRobot.setLastMoveId(moveId);
                ExecuteEnemyMove.enemyMove(api, enemyRobot, gameId);
                MapServices.printMap(api, gameId, enemyRobot, yourRobot);
                System.out.println(moveId);
                System.out.println("Enemy made move: " + moves.getLast().getMovementType());
                movementThisTurn--;
                if(moves.getLast().getMovementType().equals(MovementType.END) && moves.size() > 1) {
                    movementThisTurn = 0;
                }
            }
        } while (movementThisTurn > 0);

        MoveServices.endMove(api, gameId, playerId, enemyRobot);
    }
}
