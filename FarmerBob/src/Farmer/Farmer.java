package Farmer;
import Global.FarmerGlobalState;
import States.EnterMineAndDigForNugget;
import States.GoHomeAndSleepTilRested;
import States.State;
import States.StateMachine;

public class Farmer {
    // region Farmer Stats
    private StateMachine stateMachine;

    private String Name;

    private int Thirst = 0;
    private int MaxThirst = 100;

    private int Fatigue = 0;
    private int MaxFatigue = 100;

    private int BankMoney = 0;
    private int PocketMoney = 0;
    private int MaxPocketMoney = 50;

    public StateMachine<Farmer> getStateMachine(){
        return stateMachine;
    }

    public String getName() { return Name; }
    public int getPocketMoney() { return PocketMoney; }
    // endregion

    public Farmer(String name, State currentState) {
        this.Name = name;
        stateMachine = new StateMachine<Farmer>(this);
        stateMachine.setCurrentState(currentState);
        stateMachine.setGlobalState(FarmerGlobalState.getInstance());
    }

    public void changeState(State newState) {
        stateMachine.changeState(newState);
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

    public void runCurrentState() {
        stateMachine.update();
    }
    // endregion
}
