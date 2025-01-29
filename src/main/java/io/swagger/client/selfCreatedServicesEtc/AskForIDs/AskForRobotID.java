package io.swagger.client.selfCreatedServicesEtc.AskForIDs;

import java.util.Scanner;

public class AskForRobotID {
    public static String askForRobotID() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter robotId");

        return input.nextLine();
    }
}
