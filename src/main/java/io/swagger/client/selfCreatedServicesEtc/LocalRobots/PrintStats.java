package io.swagger.client.selfCreatedServicesEtc.LocalRobots;

public class PrintStats {
    public static void printStats(LocalRobot robot1, LocalRobot robot2) {
        System.out.println("\n                   YOUR STATS ");
        System.out.println("        "+robot1.getName()+" ("+robot1.getAvatar()+")               "+robot2.getName()+" ("+robot2.getAvatar()+")");

        System.out.println("HEALTH:    "+robot1.getHp()+"                        "+robot2.getHp());
        System.out.println("DAMAGE:    "+robot1.getDamage()+"                        "+robot2.getDamage());
        System.out.println("RANGE:     "+robot1.getRange()+"                        "+robot2.getRange());
        System.out.println("MOVEMENT:  "+robot1.getMovementPoints()+"                       "+robot2.getMovementPoints());
    }
}
