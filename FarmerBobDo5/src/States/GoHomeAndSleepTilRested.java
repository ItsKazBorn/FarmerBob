package States;

import Util.ConsoleColors;
import farmer.BaseFarmer;

public class GoHomeAndSleepTilRested implements State{
    @Override
    public State runState(BaseFarmer baseFarmer) {
        System.out.println(ConsoleColors.CYAN_BOLD + "Estou em casa");
        if (baseFarmer.isSad())
            return new GoToParkAndHaveFun();
        if (baseFarmer.isRested())
            return new EnterMineAndDigForNugget();
        baseFarmer.sleep();
        return this;
    }
}
