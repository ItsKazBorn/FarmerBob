package Farmer;

import Global.BobGlobalState;
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

    private boolean billyWorked = false;

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
        stateMachine.setGlobalState(BobGlobalState.getInstance());
    }

    @Override
    public void update() {
        stateMachine.update();
    }

    public boolean billyWorked() { return billyWorked; }
    public void setBillyWorked(boolean billyWorked) {
        this.billyWorked = billyWorked;
    }

    public int getPocketMoney() { return PocketMoney; }

    public boolean isQuenched () { return Thirst >= MaxThirst; }
    public boolean isThirsty () { return Thirst <= 0; }

    public boolean isRested () { return Fatigue <= 0; }
    public boolean isTired () { return Fatigue >= MaxFatigue; }

    public boolean isPocketFull () { return PocketMoney >= MaxPocketMoney; }

    public void addNugget (int value) { PocketMoney += value; }

    public void depositGold () {
        BankMoney += PocketMoney;
        addNugget(-PocketMoney);
    }

    public void addThirst (int value) {
        var newValue = Thirst + value;
        if (newValue >= MaxThirst)
            newValue = MaxThirst;
        else if (newValue <= 0)
            newValue = 0;
        Thirst = newValue;
    }

    public void addFatigue (int value) {
        var newValue = Fatigue + value;
        if (newValue >= MaxFatigue)
            newValue = MaxFatigue;
        else if (newValue <= 0)
            newValue = 0;
        Fatigue = newValue;
    }
}
