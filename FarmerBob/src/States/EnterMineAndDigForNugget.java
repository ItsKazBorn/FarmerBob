package States;

import Farmer.Farmer;

import java.util.Random;

public class EnterMineAndDigForNugget implements State {

    public void enter(Farmer Farmer) {
        System.out.println("Let's go mine");
    }

    public void execute (Farmer farmer) {
        System.out.println("Mining away!");

        // Mine
        Random r = new Random();
        int rand = r.nextInt(3);
        if (rand == 1) {
            System.out.println("A gold nugget! So shiny!");
            farmer.addNugget(1);
        }

        // Gain Stats
        farmer.addFatigue(5);
        farmer.addThirst(5);

        // Check for New State
        if (farmer.isPocketFull() || farmer.isTired())
            farmer.changeState(new VisitBankAndDepositGold());

        if (farmer.isThirsty())
            farmer.changeState(new QuenchThirst());
    }

    public void exit (Farmer farmer) {
        System.out.println("That's all for now...");
    }
}
