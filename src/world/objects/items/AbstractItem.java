package world.objects.items;

import com.sun.istack.internal.NotNull;
import world.behaviour.ItemBehaviour;
import world.objects.AbstractObject;
import world.objects.property.ObjectInformation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by epasquale on 4/8/17.
 */
public abstract class AbstractItem extends AbstractObject implements ItemBehaviour {

    /**
     * Default constructor
     *
     * @param position          the object's position in map
     * @param objectInformation the object's information
     */
    public AbstractItem(@NotNull Point position, @NotNull ObjectInformation objectInformation) {
        super(position, objectInformation);
    }

    @Override
    protected Point getCollisionPosition(@NotNull final Point position) {
        return null;
    }

    @Override
    protected int getCollisionRadius() {
        return 0;
    }

    public abstract ImageIcon getThumbnail();
}
