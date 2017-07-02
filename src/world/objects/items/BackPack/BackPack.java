package world.objects.items.BackPack;

import com.sun.istack.internal.NotNull;
import world.objects.interaction.ObjectInteraction;
import world.objects.items.AbstractItem;
import world.objects.property.ObjectInformation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by epasquale on 4/20/17.
 */
public class BackPack extends AbstractItem {

    public static final String THUMBNAIL_PATH = "/items/backpack.png";
    private final BackPackType.Type mType;

    /**
     * Default constructor
     *
     * @param type              the {@code BackPackType.Type}
     * @param position          the object's position in map
     * @param objectInformation the object's information
     */
    public BackPack(@NotNull final BackPackType.Type type, @NotNull final Point position,
                    @NotNull final ObjectInformation objectInformation) {
        super(position, objectInformation);
        mType = type;
    }

    public BackPackType.Type getType() {
        return mType;
    }

    @Override
    protected String getObjectName() {
        return "Back Pack";
    }

    @Override
    public ImageIcon getThumbnail() {
        return new ImageIcon(getClass().getResource(THUMBNAIL_PATH));
    }

    @Override
    protected ObjectInteraction getInteraction() {
        return new BackPackModifier(getObjectInformation().getMap(), this);
    }
}
