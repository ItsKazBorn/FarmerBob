package Farmer;

import Global.FarmerGlobalState;
import States.EnterMineAndDigForNugget;
import States.StateMachine;

public class Bob extends Entity {



    private int Thirst = 0;
    private int MaxThirst = 100;

    private int Fatigue = 0;
    private int MaxFatigue = 100;

    private int BankMoney = 0;
    private int PocketMoney = 0;
    private int MaxPocketMoney = 50;

    private String location;

    public Bob () {
        super("Bob");
        Thirst = 0;
        Fatigue = 0;
        BankMoney = 0;
        PocketMoney = 0;
        location = "Mine";

        stateMachine = new StateMachine<Bob>(this);
        stateMachine.setCurrentState(EnterMineAndDigForNugget.getInstance());
//        stateMachine.setGlobalState(BobGlobalState.getInstance());
    }

    @Override
    public void update() {
        stateMachine.update();
    }
}
