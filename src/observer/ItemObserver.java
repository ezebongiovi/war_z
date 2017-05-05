package observer;

import com.sun.istack.internal.NotNull;
import world.objects.items.AbstractItem;

/**
 * Created by epasquale on 4/21/17.
 */
public class ItemObserver extends Observer<AbstractItem> {

    /**
     * Default constructor
     *
     * @param subject the subject object
     */
    public ItemObserver(@NotNull final Subject<AbstractItem> subject) {
        super(subject);
    }

    @Override
    public void update() {

    }
}
