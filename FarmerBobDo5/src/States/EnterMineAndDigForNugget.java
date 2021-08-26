package States;

import Util.ConsoleColors;
import farmer.BaseFarmer;

public class EnterMineAndDigForNugget implements State{
    @Override
    public State runState(BaseFarmer baseFarmer) {
        System.out.println(ConsoleColors.RED_BOLD+"Estou em na mina");
        if (baseFarmer.isPocketFull() || baseFarmer.isWealthy())
            return new VisitBankAndDepositGold();
        if (baseFarmer.isThirsty())
            return new QuenchThirst();
        baseFarmer.mining();
        return this;
    }
}