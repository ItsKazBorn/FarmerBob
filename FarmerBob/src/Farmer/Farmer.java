package Farmer;
import States.GoHomeAndSleepTilRested;
import States.State;

public class Farmer {

    // region Farmer Stats
    private State currentState = new GoHomeAndSleepTilRested();

    private int Thirst = 0;
    private int MaxThirst = 100;

    private int Fatigue = 0;
    private int MaxFatigue = 100;

    private int BankMoney = 0;
    private int PocketMoney = 0;
    private int MaxPocketMoney = 50;

    public int getPocketMoney() { return PocketMoney; }
    // endregion

    public void changeState(State newState) {
        currentState.exit(this);
        currentState = newState;
        currentState.enter(this);
    }
    public void runCurrentState () {
        currentState.execute(this);
    }

    // region State checkers
    public boolean isQuenched () { return Thirst >= MaxThirst; }
    public boolean isThirsty () { return Thirst <= 0; }

    public boolean isRested () { return Fatigue <= 0; }
    public boolean isTired () { return Fatigue >= MaxFatigue; }

    public boolean isPocketFull () { return PocketMoney >= MaxPocketMoney; }
    // endregion

    // region adders
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
    // endregion
}
