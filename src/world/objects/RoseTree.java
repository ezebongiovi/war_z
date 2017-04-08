package world.objects;


import world.objects.property.ObjectInformation;

import java.awt.*;

/**
 * Created by epasquale on 3/29/17.
 */
public class RoseTree extends AbstractObject {

    public static final String PATH = "/forest/tree_rose.png";

    /**
     * Default constructor
     *
     * @param position          the object's position in map
     * @param objectInformation the object's information
     */
    public RoseTree(final Point position, final ObjectInformation objectInformation) {
        super(position, objectInformation);
    }

    @Override
    protected Point getCollisionPosition(Point position) {
        return new Point(position.x + (getObjectInformation().getImageIcon().getIconWidth() / 2) + 25,
                position.y + getObjectInformation().getImageIcon().getIconHeight());
    }

    @Override
    protected int getCollisionRadius() {
        return 5;
    }
}
