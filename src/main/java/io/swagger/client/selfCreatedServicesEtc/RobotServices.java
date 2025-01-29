package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.NewRobot;
import io.swagger.client.model.Robot;
import io.swagger.client.selfCreatedServicesEtc.AskForIDs.AskForRobotID;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RobotServices {
    public static void createRobot(DefaultApi api) throws ApiException {
        Scanner input = new Scanner(System.in);
        NewRobot newRobot = new NewRobot();

        System.out.println("Name: ");
        newRobot.setName(input.nextLine());
        System.out.println("AD: ");
        newRobot.setAttackDamage(BigDecimal.valueOf(input.nextInt()));
        System.out.println("HP: ");
        newRobot.setHealth(BigDecimal.valueOf(input.nextInt()));
        System.out.println("MovementRate: ");
        newRobot.setMovementRate(BigDecimal.valueOf(input.nextInt()));
        System.out.println("Range: ");
        newRobot.attackRange(BigDecimal.valueOf(input.nextInt()));

        System.out.println(api.apiRobotsRobotPost(newRobot));
    }

    public static List<Robot> getRobots(DefaultApi api) {
        try {
            List<Robot> robotList = api.apiRobotsGet();
            return robotList;
        } catch (ApiException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Robot getSpecificBot(DefaultApi api, List<Robot> robots) throws ApiException {
        String robotId = "";
        List<String> idList = new ArrayList<>();

        for (Robot robot : robots) {
            idList.add(robot.getId());
        }

        do {
             robotId = AskForRobotID.askForRobotID();
        } while (!validId(robotId, idList));

        return api.apiRobotsRobotIdGet(robotId);
    }

    public static boolean validId(String input, List<String> idList) {
        return idList.contains(input);
    }
}