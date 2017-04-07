package world.objects.property;

import com.sun.javafx.beans.annotations.NonNull;
import world.Map;

import javax.swing.*;

/**
 * Created by epasquale on 3/26/17.
 */
public class ObjectInformation {

    protected final Map mMap;
    protected ImageIcon mImageIcon;

    /**
     * Default constructor
     *
     * @param map             the map to where it's being attached
     */
    public ObjectInformation(@NonNull final Map map, @NonNull final ImageIcon imageIcon) {
        mMap = map;
        mImageIcon = imageIcon;
    }

    public Map getMap() {
        return mMap;
    }

    public ImageIcon getImageIcon() {
        return mImageIcon;
    }
}
