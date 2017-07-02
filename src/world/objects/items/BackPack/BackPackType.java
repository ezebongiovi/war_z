package world.objects.items.BackPack;

import com.sun.istack.internal.NotNull;

/**
 * Created by epasquale on 7/1/17.
 */
public class BackPackType {

    public enum Type {
        SMALL, MEDIUM, BIG, MILITAR;
    }

    /**
     * Determines the size of backpack by it's type
     * @param type
     * @return
     */
    public static int getSize(@NotNull final Type type) {
        switch (type) {
            case SMALL:
                return 5;
            case MEDIUM:
                return 10;
            case BIG:
                return 15;
            case MILITAR:
                return 20;
            default:
                return 0;
        }
    }
}
