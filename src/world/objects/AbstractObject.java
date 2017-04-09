package world.objects;


import com.sun.istack.internal.NotNull;
import world.objects.property.CollisionCircle;
import world.objects.property.ObjectInformation;

import java.awt.*;

/**
 * Created by epasquale on 3/26/17.
 */
public abstract class AbstractObject extends Component {
    private final ObjectInformation objectInformation;
    private final CollisionCircle collisionCircle;

    /**
     * Default constructor
     *
     * @param position          the object's position in map
     * @param objectInformation the object's information
     */
    public AbstractObject(@NotNull final Point position, @NotNull final ObjectInformation objectInformation) {
        this.objectInformation = objectInformation;
        this.collisionCircle = new CollisionCircle(position, getCollisionPosition(position), getCollisionRadius());
    }

    public ObjectInformation getObjectInformation() {
        return this.objectInformation;
    }

    public CollisionCircle getCollisionCircle() {
        return collisionCircle;
    }

    protected abstract Point getCollisionPosition(final Point position);

    protected abstract int getCollisionRadius();
}
