package States;

import Util.ConsoleColors;
import farmer.BaseFarmer;

public class QuenchThirst implements State{
    @Override
    public State runState(BaseFarmer baseFarmer) {
        System.out.println(ConsoleColors.BLUE_BOLD+"Estou no bar");
        if (baseFarmer.imFull())
            return new EnterMineAndDigForNugget();
        baseFarmer.drink();
        return this;
    }
}
