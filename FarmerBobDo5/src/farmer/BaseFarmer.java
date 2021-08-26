package farmer;

import Util.ConsoleColors;

import java.util.SortedMap;

public class BaseFarmer {
    private final float MinThirsty = 10;
    private final float MaxThirsty = 50;
    private final float MaxNuggets = 50;
    private final float MinWealthy = 20;
    private final float MaxWealthy = 50;
    public float currentMoney = 0;
    private float Nuggets;
    private float Thirsty;
    private float Wealthy;
    public BaseFarmer() {
        this(0, 50, 50);
    }
    public BaseFarmer(float nuggets, float thirsty, float wealthy) {
        Nuggets = nuggets;
        Thirsty = thirsty;
        Wealthy = wealthy;
    }

    private BaseFarmer addNuggets(float value) {
        var newValue = Nuggets+value;
        if (newValue>=MaxNuggets){
            newValue = MaxNuggets;
        }else if(newValue<=0){
            newValue = 0;
        }
        Nuggets = newValue;
        return this;
    }

    private BaseFarmer addWealthy(float value) {
        var newValue = Wealthy+value;
        if (newValue>=MaxWealthy){
            newValue = MaxWealthy;
        }else if(newValue<=MinWealthy){
            newValue = MinWealthy;
        }
        Wealthy = newValue;
        return this;
    }

    private BaseFarmer addThirsty(float value) {
        var newValue = Thirsty+value;
        if (newValue>=MaxThirsty){
            newValue = MaxThirsty;
        }else if(newValue<=MinThirsty){
            newValue = MinThirsty;
        }
        Thirsty = newValue;
        return this;
    }

    public boolean imFull() {
        return Thirsty >= MaxThirsty;
    }

    public boolean isThirsty() {
        return Thirsty <= MinThirsty;
    }

    public boolean isPocketFull() {
        return Nuggets >= MaxNuggets;
    }

    public boolean isWealthy() {
        return Wealthy <= MinWealthy;
    }

    public boolean isRested() {
        return Wealthy >= MaxWealthy;
    }

    public BaseFarmer drink() {
        if (buyDrink(3f))
            return printState();
        System.out.println("Não tenho dinheiro :C");
        System.exit(1);
        return this;
    }

    private boolean buyDrink(float valueDrink) {
        if(currentMoney >= valueDrink){
            addCurrentMoney(-valueDrink).addThirsty(5);
            return true;
        }else if (Nuggets >= valueDrink) {
            addNuggets(-valueDrink).addThirsty(5);
            return true;
        }
        return false;
    }

    private BaseFarmer addCurrentMoney(float value) {
        currentMoney += value;
        return this;
    }

    public BaseFarmer mining() {
        return addThirsty(-2.5f).addNuggets(3f).addWealthy(-1f).printState();
    }

    public BaseFarmer sleep() {

        return addWealthy(3f).printState();
    }

    public BaseFarmer deposityMoney() {
        return addCurrentMoney(Nuggets).addNuggets(-Nuggets).printState();
    }

    private BaseFarmer printState() {
        System.out.println(this);
        return this;
    }

    @Override
    public String toString() {
        return ConsoleColors.BLACK_BOLD+"{" +
                "Nuggets=" + Nuggets +
                ", Thirsty=" + Thirsty +
                ", Wealthy=" + Wealthy +
                ", currentMoney=" + currentMoney +
                "}";
    }

}
