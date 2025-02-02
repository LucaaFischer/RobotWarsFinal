package io.swagger.client.selfCreatedServicesEtc.Combat;

import io.swagger.client.selfCreatedServicesEtc.LocalRobots.LocalRobot;
import io.swagger.client.selfCreatedServicesEtc.LocalRobots.PrintStats;

public class FightController {
    public static void fight(LocalRobot robotTurn, LocalRobot robotNotTurn) {
        FightView.attackMessage();

        robotNotTurn.setHp(robotNotTurn.getHp() - robotTurn.getDamage());

        if (checkWin(robotTurn, robotNotTurn)) {
            checkWinner(robotTurn, robotNotTurn);
        } else {
            FightView.noWinnerMessage();
            PrintStats.printStats(robotTurn, robotNotTurn);
        }
    }

    //------------------------------------------------------------Überprüfen OB es einen Gewinner gibt--------------------------------------------------------------------
    public static boolean checkWin(LocalRobot robot1, LocalRobot robot2) {
        return robot1.getHp() <= 0 || robot2.getHp() <= 0;
    }

    //----------------------------------------------------------------Prüfen WER gewonnen hat-------------------------------------------------------------------------------
    public static String checkWinner(LocalRobot robot1, LocalRobot robot2) {
        String winner = "";
        if (robot1.getHp() <= 0 && robot2.getHp() <= 0) {
            winner = "U both died lmao";
        } else if (robot1.getHp() <= 0) {
            winner = robot1.getName();
        } else if (robot2.getHp() <= 0) {
            winner = robot1.getName();
        }
        return winner;
    }
}

