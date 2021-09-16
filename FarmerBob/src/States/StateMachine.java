package States;

public class StateMachine<NPC> {

    private NPC myOwner;

    private State<NPC> currentState;

    private State<NPC> previousState;

    private State<NPC> globalState;

    public StateMachine(NPC owner) {
        myOwner = owner;
        currentState = null;
        previousState = null;
        globalState = null;
    }

    public void setCurrentState (State<NPC> s) {
        currentState = s;
    }

    public void setGlobalState (State<NPC> s) {
        globalState = s;
    }

    public void setPreviousState (State<NPC> s) {
        previousState = s;
    }

    public void update () {
        if (globalState != null) {
            globalState.execute(myOwner);
        }

        if (currentState != null) {
            currentState.execute(myOwner);
        }
    }

    public void changeState (State<NPC> newState) {
        previousState = currentState;
        currentState.exit(myOwner);
        currentState = newState;
        currentState.enter(myOwner);
    }

    public void revertToPreviousState () {
        changeState(previousState);
    }

    public State<NPC> getCurrentState () {
        return currentState;
    }

    public State<NPC> getGlobalState () {
        return globalState;
    }

    public State<NPC> getPreviousState () {
        return previousState;
    }
}
