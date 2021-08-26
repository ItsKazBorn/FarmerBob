package farmer;

import Util.ConsoleColors;

import java.util.SortedMap;

public class BaseFarmer {
    private final float MinThirsty = 10;
    private final float MaxThirsty = 50;
    private final float MinHunger  = 10;
    private final float MaxHunger  = 50;
    private final float MaxNuggets = 50;
    private final float MinWealthy = 20;
    private final float MaxWealthy = 50;
    private final float MinHappiness = 5;
    private final float MaxHappiness = 30;
    private final float MinSadness = 0;
    private final float MaxSadness = 30;
    public float currentMoney = 0;
    private float Nuggets;
    private float Thirsty;
    private float Hunger;
    private float Wealthy;
    private float Sadness;
    private float Hapiness;

    public BaseFarmer() {
        this(0, 50, 50, 0, 30);
    }
    public BaseFarmer(float nuggets, float thirsty, float wealthy, float sadness, float hapiness) {
        Nuggets = nuggets;
        Thirsty = thirsty;
        Wealthy = wealthy;
        Sadness = sadness;
        Hapiness = hapiness;
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

    private BaseFarmer addHunger (float value) {
        var newValue = Hunger+value;
        if (newValue >= MaxHunger)
            newValue = MaxHunger;
        else if (newValue <= MinHunger)
            newValue = MinHunger;
        Hunger = newValue;
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

    public boolean hasMoney (float amount) {
        if (currentMoney >= amount)
            return true;
        else if (Nuggets >= amount)
            return true;
        return false;
    }

    private BaseFarmer addSadness(float value) {
        var newValue = Sadness+value;
        if (newValue>=MaxSadness){
            newValue = MaxSadness;
        }else if (newValue<=MinSadness){
            newValue = MinSadness;
        }
        Sadness = newValue;
        return this;
    }

    private BaseFarmer addHapiness(float value) {
        var newValue = Hapiness+value;
        if (newValue>=MaxHappiness){
            newValue = MaxHappiness;
        }else if (newValue<=MinHappiness){
            newValue = MinHappiness;
        }
        Hapiness = newValue;
        return this;
    }

    public boolean isFull () { return Hunger >= MaxHunger; }

    public boolean isHungry() { return Hunger <= MinHunger; }

    public boolean imFull() {
        return Thirsty >= MaxThirsty;
    }

    public boolean isSad() {
        return Sadness >= MaxSadness;
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
        addSadness(4);
        if (buyDrink(3f))
            return printState();
        System.out.println("Não tenho dinheiro :C");
        System.exit(1);
        return this;
    }

    public BaseFarmer eat () {
        if (buyFood(3f))
            return printState();
        System.out.println("Não tenho dinheiro :C");
        System.exit(1);
        return this;
    }

    public boolean buyFood(float valueFood) {
        if (currentMoney >= valueFood) {
            addCurrentMoney(-valueFood).addHunger(5);
            return true;
        } else if (Nuggets >= valueFood) {
            addNuggets(-valueFood).addHunger(5);
            return true;
        }
        return false;
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

    public BaseFarmer borrowMoney (float amount) { return addCurrentMoney(-amount).printState(); }

    private BaseFarmer printState() {
        System.out.println(this);
        return this;
    }

    @Override
    public String toString() {
        return ConsoleColors.BLACK_BOLD+"{" +
                "Nuggets=" + Nuggets +
                ", Thirsty=" + Thirsty +
                ", Hunger =" + Hunger +
                ", Happy =" + Hunger +
                ", Wealthy=" + Wealthy +
                ", currentMoney=" + currentMoney +
                "}";
    }

}
