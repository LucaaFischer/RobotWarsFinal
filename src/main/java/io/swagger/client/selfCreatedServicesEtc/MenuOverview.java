package io.swagger.client.selfCreatedServicesEtc;

import java.util.Scanner;

public class MenuOverview {
    public static int overview() {
        Scanner input = new Scanner(System.in);

        System.out.println("What u wanna do?" +
                " 1. See all Games " +
                " 2. See specific Game " +
                " 3. Create Game" +
                " 4. Join Game" +
                " 5. See every robot in da whole universe" +
                " 6. See a single robot" +
                " 7. Create new Robot");

        return input.nextInt();
    }
}
