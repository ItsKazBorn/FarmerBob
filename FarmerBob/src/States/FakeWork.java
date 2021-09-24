package States;

import Farmer.Billy;
import Farmer.EntityManager;
import Message.*;

import java.util.Random;

public class FakeWork implements State<Billy>{

    private static FakeWork intance = null;

    private FakeWork() {}

    public static FakeWork getInstance(){
        if (intance == null)
            intance = new FakeWork();
        return intance;
    }

    public void enter(Billy billy) {

    }


    public void execute(Billy billy) {
        System.out.println("Of course I'm working...");
        System.out.println("I am mean working at the farm");

        Random r = new Random();
        int rand = r.nextInt(2);
        if (rand == 1){
            //Should work or not??
        }
        else {
            billy.getStateMachine().changeState(LookAtTheWeather.getInstance());
        }
    }


    public void exit(Billy billy) {
        MessageDispatcher.getInstance().dispatchMessage(billy, EntityManager.getInstance().getEntity("Bob"), "JobsDone!", null);
    }

    public boolean onMessage(Billy billy, Message msg) {
        return false;
    }
}
