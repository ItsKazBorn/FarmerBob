package States;

import Farmer.Farmer;

public class VisitBankAndDepositGold implements State {

    private static VisitBankAndDepositGold instance = null;

    private VisitBankAndDepositGold() {}

    public static VisitBankAndDepositGold getInstance(){
        if (instance == null)
            instance = new VisitBankAndDepositGold();
        return instance;
    }

    public void enter(Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "Let's save these nuggets in the bank...");
    }

    public void execute (Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "Today I deposited " + farmer.getPocketMoney() + " nuggets");
        farmer.depositGold();

        if (farmer.isTired())
            farmer.changeState(GoHomeAndSleepTilRested.getInstance());
        else
            farmer.changeState(EnterMineAndDigForNugget.getInstance());
    }

    public void exit (Farmer farmer) {
        System.out.println(farmer.getName() + " says: " + "Thanks again for keeping my gold safe!");
    }
}
