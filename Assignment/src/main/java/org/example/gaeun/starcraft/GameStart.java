package org.example.gaeun.starcraft;


public class GameStart {

    private static boolean isFinished = false;
    public static void setFinished() {
        isFinished = true;
    }

    public static void gameStart() {
        Starcraft starcraft = new Starcraft();
        User user = new User();
        Computer computer = new Computer();

        User.userChoiceUnit();
        Computer.comChoiceUnit();

        starcraft.printStatus();

        while(!isFinished) {
            user.attackUser();
            starcraft.printStatus();
            computer.attackComputer();
            starcraft.printStatus();
        }

    }
    public static void main(String[] args) {
        gameStart();
    }
}
