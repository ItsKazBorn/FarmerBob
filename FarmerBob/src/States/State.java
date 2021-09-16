package States;

import Farmer.Farmer;

public interface State<NPC> {
    public void enter (NPC f);

    public void execute(NPC f);

    public void exit (NPC f);
}
