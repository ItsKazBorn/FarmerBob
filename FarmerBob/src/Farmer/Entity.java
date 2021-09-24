package Farmer;

import Message.Message;
import States.StateMachine;

public abstract class Entity {

    private static int nextID = 0;
    private int id;

    private String name;

    protected String location;
    protected StateMachine stateMachine;

    public Entity(String name)  {
        this.name  = name;
        this.id = nextID;
        nextID += 1;
        EntityManager.getInstance().registerEntity(this);
    }

    public void setLocation(String location)  {
        this.location = location;
    }

    public String getName () {
        return name;
    }

    public StateMachine getStateMachine () { return stateMachine; }

    public abstract void update ();

    public boolean handleMessage(Message msg) {
        return stateMachine.handleMessage(msg);
    }

    public int getId () {
        return id;
    }
}
