package States;

import Util.ConsoleColors;
import farmer.BaseFarmer;

public class VisitBankAndAskForMoney implements State {
    @Override
    public State runState(BaseFarmer baseFarmer) {
        System.out.println();
        if (!baseFarmer.hasMoney(3f * 8f)) {
            System.out.println(ConsoleColors.RED_BOLD + "Emprestei dinheiro..." );
            System.out.println(ConsoleColors.GREEN_BOLD+"Dinheiro atual: "+baseFarmer.borrowMoney(3f * 8f).currentMoney);
        }
        if (baseFarmer.isThirsty())
            return new QuenchThirst();
        else if (baseFarmer.isHungry())
            return new QuenchHunger();
        return new EnterMineAndDigForNugget();
    }
}
