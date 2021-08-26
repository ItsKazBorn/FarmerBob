package States;

import Util.ConsoleColors;
import farmer.BaseFarmer;

public class QuenchHunger implements State {
    @Override
    public State runState(BaseFarmer baseFarmer) {
        System.out.println();
        if (baseFarmer.isFull())
            return new EnterMineAndDigForNugget();
        baseFarmer.eat();
        return this;
    }
}
