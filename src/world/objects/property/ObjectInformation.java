package world.objects.property;


import world.terrain.maps.Map;

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
    public ObjectInformation(final Map map, final ImageIcon imageIcon) {
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
