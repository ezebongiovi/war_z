package world.objects.items;

import com.sun.istack.internal.NotNull;
import world.objects.property.ObjectInformation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by epasquale on 4/20/17.
 */
public class BackPack extends AbstractItem {

    public static final String THUMBNAIL_PATH = "/items/backpack.png";

    /**
     * Default constructor
     *
     * @param position          the object's position in map
     * @param objectInformation the object's information
     */
    public BackPack(@NotNull final Point position, @NotNull final ObjectInformation objectInformation) {
        super(position, objectInformation);
    }

    @Override
    protected String getObjectName() {
        return "Back Pack";
    }

    @Override
    public ImageIcon getThumbnail() {
        return new ImageIcon(getClass().getResource(THUMBNAIL_PATH));
    }
}
