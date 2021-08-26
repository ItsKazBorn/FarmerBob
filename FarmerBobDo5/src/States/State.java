package States;

import farmer.BaseFarmer;

public interface State {
    State runState(BaseFarmer baseFarmer);
}
