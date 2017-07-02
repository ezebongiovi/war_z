package world.character;

import com.sun.istack.internal.NotNull;
import world.behaviour.EnemyBehaviour;
import world.objects.AbstractObject;
import world.objects.interaction.ObjectInteraction;
import world.objects.property.ObjectInformation;

import java.awt.*;

public class Enemy extends AbstractObject implements EnemyBehaviour {

    /**
     * Default constructor
     *
     * @param position          the object's position in map
     * @param objectInformation the object's information
     */
    public Enemy(@NotNull final Point position, @NotNull final ObjectInformation objectInformation) {
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

    @Override
    protected ObjectInteraction getInteraction() {
        return null;
    }

    @Override
    protected String getObjectName() {
        return null;
    }
}
