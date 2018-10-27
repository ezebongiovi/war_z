package world.objects.items;

import com.sun.istack.internal.NotNull;
import world.behaviour.ItemBehaviour;
import world.objects.AbstractObject;
import world.objects.interaction.ItemInteraction;
import world.objects.interaction.ObjectInteraction;
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
    public AbstractItem(@NotNull final Point position, @NotNull final ObjectInformation objectInformation) {
        super(position, objectInformation);
    }

    @Override
    protected Point getCollisionPosition(@NotNull final Point position) {
        return new Point(position.x + getObjectInformation().getImageIcon().getIconWidth() / 2,
                position.y + getObjectInformation().getImageIcon().getIconHeight() / 2);
    }

    @Override
    protected int getCollisionRadius() {
        return 5;
    }

    public abstract ImageIcon getThumbnail();

    @Override
    protected ObjectInteraction getInteraction() {
        return new ItemInteraction(this);
    }
}
