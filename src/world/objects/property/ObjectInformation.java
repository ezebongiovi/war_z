package world.objects.property;


import javax.swing.*;

/**
 * Created by epasquale on 3/26/17.
 */
public class ObjectInformation {

    protected ImageIcon mImageIcon;

    /**
     * Default constructor
     */
    public ObjectInformation(final ImageIcon imageIcon) {
        mImageIcon = imageIcon;
    }

    public ImageIcon getImageIcon() {
        return mImageIcon;
    }
}
