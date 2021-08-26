package States;

import Util.ConsoleColors;
import farmer.BaseFarmer;

public class QuenchHunger implements State {
    @Override
    public State runState(BaseFarmer baseFarmer) {
        System.out.println(ConsoleColors.BLUE_BOLD+"Estou comendo");
        if (baseFarmer.isFull())
            return new EnterMineAndDigForNugget();
        baseFarmer.eat();
        return this;
    }
}
