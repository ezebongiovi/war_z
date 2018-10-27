package world.attachments;

import world.objects.AbstractObject;
import world.objects.property.ObjectInformation;

import java.awt.*;

public abstract class Attachment extends AbstractObject {

    /**
     * Default constructor
     *
     * @param position          the object's position in map
     * @param objectInformation the object's information
     */
    public Attachment(final Point position, final ObjectInformation objectInformation) {
        super(position, objectInformation);
    }

    /**
     * Called when being attached
     */
    public abstract void onAttach();

    /**
     * Called when being detached
     */
    public abstract void onDetach();
}
