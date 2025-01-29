package io.swagger.client.selfCreatedServicesEtc.AskForIDs;

import java.util.Scanner;

public class AskForMapID {
    public static String askForMapID() {
        Scanner input = new Scanner(System.in);
        System.out.println("MapId: ");

        return input.nextLine();
    }
}
