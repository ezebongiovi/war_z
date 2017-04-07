package world.terrain;

import world.Map;
import world.objects.AbstractObject;
import world.objects.RoseTree;
import world.objects.RoseTreeSkinny;
import world.objects.Tree;
import world.objects.property.ObjectInformation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by epasquale on 3/24/17.
 */
public class DemoMap extends Map {

    private static final String NAME = "Demo";

    @Override
    protected AbstractObject[] getMapObjects() {
        return new AbstractObject[]{new Tree(new Point(400, 300), new ObjectInformation(this,
                new ImageIcon(getClass().getResource(Tree.PATH)))),
                new RoseTree(new Point(500, 300), new ObjectInformation(this,
                        new ImageIcon(getClass().getResource(RoseTree.PATH)))),
                new RoseTreeSkinny(new Point(500, 400), new ObjectInformation(this,
                        new ImageIcon(getClass().getResource(RoseTreeSkinny.PATH))))};
    }

    @Override
    public String getKey() {
        return NAME;
    }

    @Override
    protected String[][] getMatrix() {
        return new String[][]{
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "S", "S", "S", "G", "S", "S", "S", "G", "S", "S", "S", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "S", "G", "G", "G", "G", "G", "S", "G", "S", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "S", "S", "G", "G", "G", "S", "G", "G", "S", "S", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "S", "G", "G", "G", "S", "G", "G", "G", "S", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "S", "S", "S", "G", "S", "S", "S", "G", "S", "S", "S", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"},
                {"G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G", "G"}
        };
    }
}
