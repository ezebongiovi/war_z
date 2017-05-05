package world.character.info;

import com.sun.istack.internal.NotNull;
import observer.ItemObserver;
import observer.Subject;
import world.objects.items.AbstractItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by epasquale on 4/8/17.
 */
public class Inventory extends Subject<AbstractItem> {

    public static final int INVENTORY_DEFAULT_SPACE = 5;
    private int mSpace = INVENTORY_DEFAULT_SPACE;
    private final List<AbstractItem> mItems = new ArrayList<>();
    private final List<ItemObserver> mObserversList = new ArrayList<>();

    public Inventory() {

    }

    /**
     * Ads an item to the inventory
     *
     * @param item the item being added
     * @return whether the item could be added or not to the inventory
     */
    public boolean addItem(@NotNull final AbstractItem item) {
        if (mItems.size() < mSpace) {
            mItems.add(item);

            notifyAllObservers();
            return true;
        }

        return false;
    }

    /**
     * Removes an item from the inventory
     *
     * @param item the item being removed
     */
    public void removeItem(@NotNull final AbstractItem item) {
        mItems.remove(item);
    }

    public List<AbstractItem> getItems() {
        return mItems;
    }

    public void setSpace(final int space) {
        mSpace = space;
    }

    public void addObserver(@NotNull final ItemObserver itemObserver) {
        mObserversList.add(itemObserver);
    }
}
