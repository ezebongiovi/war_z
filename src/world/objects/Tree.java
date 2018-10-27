package world.objects;


import world.objects.interaction.ObjectInteraction;
import world.objects.property.ObjectInformation;

import java.awt.*;

/**
 * Created by epasquale on 3/26/17.
 */
public class Tree extends AbstractObject {

    public static final String PATH = "/environment/objects/forest/pine.png";

    /**
     * Default constructor
     *
     * @param position          the position in map
     * @param objectInformation the object's information
     */
    public Tree(final Point position, final ObjectInformation objectInformation) {
        super(position, objectInformation);
    }

    @Override
    protected Point getCollisionPosition(final Point position) {
        return new Point(position.x + (getObjectInformation().getImageIcon().getIconWidth() / 2) - 5,
                position.y + getObjectInformation().getImageIcon().getIconHeight());
    }

    @Override
    protected int getCollisionRadius() {
        return 5;
    }

    @Override
    protected ObjectInteraction getInteraction() {
        return null;
    }

    @Override
    protected String getObjectName() {
        return "Tree";
    }
}
