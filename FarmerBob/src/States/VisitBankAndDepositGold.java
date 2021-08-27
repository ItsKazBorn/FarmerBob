package States;

import Farmer.Farmer;

public class VisitBankAndDepositGold implements State {
    public void enter(Farmer Farmer) {
        System.out.println("Let's save these nuggets in the bank...");
    }

    public void execute (Farmer farmer) {

    }

    public void exit (Farmer farmer) {
        System.out.println("Thanks again for securing my gold!");
    }
}
