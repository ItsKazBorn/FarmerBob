package States;
import Farmer.Farmer;

public class VisitBankAndDepositGold implements State<Farmer> {
    public void enter(Farmer Farmer) {
        System.out.println("Let's save these nuggets in the bank...");
    }

    public void execute (Farmer farmer) {
        System.out.println("Today I deposited " + farmer.getPocketMoney() + " nuggets");
        farmer.depositGold();

        if (farmer.isTired())
            farmer.changeState(new GoHomeAndSleepTilRested());
        else
            farmer.changeState(new EnterMineAndDigForNugget());
    }

    public void exit (Farmer farmer) {
        System.out.println("Thanks again for keeping my gold safe!");
    }
}
