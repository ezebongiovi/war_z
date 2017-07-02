package world.objects.interaction;

import com.sun.istack.internal.NotNull;
import world.objects.AbstractObject;

/**
 * Created by epasquale on 4/11/17.
 */
public class ObjectInteraction<T extends AbstractObject> {

    private final AbstractObject mObject;

    /**
     * Default constructor
     *
     * @param object the interactor object
     */
    ObjectInteraction(@NotNull final AbstractObject object) {
        mObject = object;
    }

    /**
     * Calls the interaction to be executed
     *
     * @param object the object interacting
     */
    public void interact(@NotNull final T object) {
        mObject.getObjectInteraction().interact(object);
    }
}
