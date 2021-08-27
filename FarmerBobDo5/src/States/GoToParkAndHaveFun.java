package States;

import Util.ConsoleColors;
import farmer.BaseFarmer;

public class GoToParkAndHaveFun implements State{
    public State runState(BaseFarmer baseFarmer){
        System.out.println(ConsoleColors.PURPLE_BRIGHT + "Estou no parque e me divertindo");
        if (baseFarmer.isHappy())
            return new GoHomeAndSleepTilRested();
        baseFarmer.haveFun();
        return this;
    }
}
