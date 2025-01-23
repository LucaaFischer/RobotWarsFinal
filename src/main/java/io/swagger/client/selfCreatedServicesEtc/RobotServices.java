package io.swagger.client.selfCreatedServicesEtc;

import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.NewRobot;
import io.swagger.client.model.Robot;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RobotServices {
    public static void createRobot(DefaultApi api, Scanner input) throws ApiException {
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

    public static List<Robot> getRobots(DefaultApi api) throws ApiException {
        try {
            List<Robot> robotList = api.apiRobotsGet();
            return robotList;
        } catch (ApiException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Robot getSpecificBot(Scanner input, DefaultApi api, List<Robot> robots) throws ApiException {
        String inputId;
        List<String> idList = new ArrayList<>();

        for (Robot robot : robots) {
            idList.add(robot.getId());
        }

        do {
            System.out.println("Which robot u wanna see?");
            inputId = input.nextLine();
        } while (!validId(inputId, idList));

        return api.apiRobotsRobotIdGet(inputId);
    }

    public static boolean validId(String input, List<String> idList) {
        return idList.contains(input);
    }
}