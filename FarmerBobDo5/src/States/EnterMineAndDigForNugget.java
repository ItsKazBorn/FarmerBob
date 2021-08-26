package States;

import Util.ConsoleColors;
import farmer.BaseFarmer;

public class EnterMineAndDigForNugget implements State{
    @Override
    public State runState(BaseFarmer baseFarmer) {
        System.out.println(ConsoleColors.RED_BOLD+"Estou em na mina");
        if (baseFarmer.isPocketFull() || baseFarmer.isWealthy())
            return new VisitBankAndDepositGold();
        if (baseFarmer.isThirsty() || baseFarmer.isHungry())
            return new VisitBankAndAskForMoney();
        baseFarmer.mining();
        return this;
    }
}