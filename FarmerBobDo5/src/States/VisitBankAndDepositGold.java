package States;

import Util.ConsoleColors;
import farmer.BaseFarmer;

public class VisitBankAndDepositGold implements State{
    @Override
    public State runState(BaseFarmer baseFarmer) {
        System.out.println(ConsoleColors.GREEN_BOLD+"Estou no banco");
        System.out.println(ConsoleColors.GREEN_BOLD+"Dinheiro atual: "+baseFarmer.deposityMoney().currentMoney);
        if (baseFarmer.isWealthy())
            return new GoHomeAndSleepTilRested();
        return new EnterMineAndDigForNugget();
    }
}
