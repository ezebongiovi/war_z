package world.objects;

import com.sun.javafx.beans.annotations.NonNull;
import world.objects.property.ObjectInformation;

import java.awt.*;

/**
 * Created by epasquale on 3/26/17.
 */
public class Tree extends AbstractObject {

    public static final String PATH = "/forest/pine.png";

    /**
     * Default constructor
     *
     * @param position          the position in map
     * @param objectInformation the object's information
     */
    public Tree(@NonNull final Point position, @NonNull final ObjectInformation objectInformation) {
        super(position, objectInformation);
    }

    @Override
    protected Point getCollisionPosition(@NonNull final Point position) {
        return new Point(position.x + (getObjectInformation().getImageIcon().getIconWidth() / 2) + 15,
                position.y + getObjectInformation().getImageIcon().getIconHeight());
    }

    @Override
    protected int getCollisionRadius() {
        return 5;
    }
}
