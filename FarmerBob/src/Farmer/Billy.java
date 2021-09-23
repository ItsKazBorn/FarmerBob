package Farmer;

import States.LookAtTheWeather;
import States.StateMachine;

public class Billy extends Entity {

    private String location;

    public Billy () {
        super("Billy");
        location = "Farm";

        stateMachine  = new StateMachine<Billy>(this);
        stateMachine.setCurrentState(LookAtTheWeather.getInstance());
//        stateMachine.setGlobalState(BillyGlobalState.getInstance());
    }


    @Override
    public void update() {
        stateMachine.update();
    }
}
