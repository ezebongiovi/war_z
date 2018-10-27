package world.objects.interaction;

import com.sun.istack.internal.NotNull;
import world.character.Character;
import world.objects.items.AbstractItem;
import world.terrain.maps.Map;

/**
 * Created by epasquale on 4/20/17.
 */
public class ItemInteraction<T extends AbstractItem> extends ObjectInteraction<Character> {

    private final T mObject;

    /**
     * Default constructor
     *
     * @param object the interactor object
     */
    public ItemInteraction(@NotNull final T object) {
        super(object);
        mObject = object;
    }

    protected T getObject() {
        return mObject;
    }
}
