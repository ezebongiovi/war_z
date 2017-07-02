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
    private final Map mMap;

    /**
     * Default constructor
     *
     * @param object the interactor object
     */
    public ItemInteraction(@NotNull final Map map, @NotNull final T object) {
        super(object);
        mObject = object;
        mMap = map;
    }

    @Override
    public void interact(@NotNull final Character character) {
        if (character.getCharacterInformation().getInventory().addItem(mObject)) {
            mMap.removeObject(mObject);
        }
    }

    protected T getObject() {
        return mObject;
    }

    protected Map getMap() {
        return mMap;
    }
}
