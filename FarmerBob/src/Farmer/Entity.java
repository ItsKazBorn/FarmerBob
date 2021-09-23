package Farmer;

import States.StateMachine;

public abstract class Entity {
    private String name;

    protected StateMachine stateMachine;

    public Entity(String name)  {
        this.name  = name;

        //EntityManager.getInstance().registerEntity(this)
    }

    public String getName () {
        return name;
    }

    public abstract void update ();
}
