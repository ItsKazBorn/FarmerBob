public class FarmerBob {

    public State state = State.GoHomeAndSleepTilRested;

    //region Farmer Bob Stats
    private int thirst = 100;
    private int maxThirst = 100;

    private int fatigue = 0;
    private int maxFatigue = 100;

    private int bankMoney = 0;
    private int pocketGold = 0;
    private int maxPocketGold = 50;
    //endregion

    //region Getters & Setters
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
    //endregion

    public State CheckState () {
        return state;
    }
    private void ChangeState (State newState) {
        state = newState;
    }

    //region Actions
    public void Mine () {
        pocketGold += 1;
        fatigue += 1;
        thirst -= 5;
        if (thirst <= 0) { ChangeState(State.QuenchThirst); }
        if (pocketGold >= maxPocketGold || fatigue >= maxFatigue) { ChangeState(State.VisitBankAndDepositGold); }
    }

    public void Rest () {
        fatigue -= 1;
        if (fatigue <= 0) { ChangeState(State.EnterMineAndDigForNugget); }
    }

    public void DepositGold () {
        pocketGold -= 1;
        bankMoney += 1;
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
    //endregion

    public void PrintStats () {
        //System.out.println(">>>>>--------> STATS <--------<<<<<");
        System.out.println("Bank Money:   " + bankMoney);
        System.out.println("Pocket Money: " + pocketGold + " / " + maxPocketGold);
        System.out.println("Thirst:       " + thirst +  " / " + maxThirst);
        System.out.println("Fatigue:      " + fatigue + " / " + maxFatigue);
        System.out.println("====================================");
    }
}
