
enum State {
    EnterMineAndDigForNugget,
    VisitBankAndDepositGold,
    GoHomeAndSleepTilRested,
    QuenchThirst;
}

public class FarmerBob {

    public State state = State.GoHomeAndSleepTilRested;

    private int thirst = 100;
    private int maxThirst = 100;

    private int fatigue = 0;
    private int maxFatigue = 100;

    private int bankMoney = 0;
    private int pocketGold = 0;
    private int maxPocketGold = 50;

    public int getThirst() {
        return thirst;
    }
    public void setThirst(int thirst) {
        this.thirst = thirst;
    }
    public int getFatigue() {
        return fatigue;
    }
    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }
    public int getPocketGold() {
        return pocketGold;
    }
    public void setPocketGold(int pocketGold) {
        this.pocketGold = pocketGold;
    }
    public int getMaxThirst() {
        return maxThirst;
    }
    public int getMaxFatigue() {
        return maxFatigue;
    }
    public int getMaxPocketGold() {
        return maxPocketGold;
    }
    public State CheckState () {
        return state;
    }
    private void ChangeState (State newState) {
        state = newState;
    }

    public void Mine () {
        pocketGold += 1;
        fatigue += 1;
        thirst -= 5;
        if (thirst <= 0) { ChangeState(State.QuenchThirst); }
        if (pocketGold >= maxPocketGold) { ChangeState(State.VisitBankAndDepositGold); }
    }

    public void Rest () {
        fatigue -= 1;
        if (fatigue <= 0) { ChangeState(State.EnterMineAndDigForNugget); }
    }

    public void DepositGold () {
        pocketGold -= 10;
        bankMoney += 10;
        if (pocketGold <= 0)  {
            if (fatigue < maxFatigue) {
                ChangeState(State.EnterMineAndDigForNugget);
            }
            else { ChangeState(State.GoHomeAndSleepTilRested); }
        }
    }

    public void Drink () {
        thirst += 20;
        pocketGold -= 1;
        if (thirst >= maxThirst) { ChangeState(State.EnterMineAndDigForNugget); }
    }
}
