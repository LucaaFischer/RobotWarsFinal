package io.swagger.client.selfCreatedServicesEtc.AskForIDs;

import java.util.Scanner;

public class AskForGameID {
    public static String askForID() {
        Scanner input = new Scanner(System.in);
        System.out.println("GameID?");

        return input.nextLine();
    }
}
