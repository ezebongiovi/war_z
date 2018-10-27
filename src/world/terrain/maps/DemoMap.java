package world.terrain.maps;

import world.objects.AbstractObject;
import world.objects.RoseTree;
import world.objects.RoseTreeSkinny;
import world.objects.Tree;
import world.objects.items.BackPack.BackPack;
import world.objects.items.BackPack.BackPackType;
import world.objects.property.ObjectInformation;
import world.terrain.type.Dirt;
import world.terrain.type.Grass;
import world.terrain.type.Stone;

import javax.swing.*;
import java.awt.*;

/**
 * Created by epasquale on 3/24/17.
 */
public class DemoMap extends Map {

    private static final String NAME = "Demo";

    @Override
    protected AbstractObject[] getMapObjects() {
        return new AbstractObject[]{new Tree(new Point(400, 300), new ObjectInformation(new ImageIcon(getClass().getResource(Tree.PATH)))),
                new RoseTree(new Point(500, 300), new ObjectInformation(new ImageIcon(getClass().getResource(RoseTree.PATH)))),
                new RoseTreeSkinny(new Point(500, 400), new ObjectInformation(new ImageIcon(getClass().getResource(RoseTreeSkinny.PATH)))),
                new BackPack(BackPackType.Type.SMALL, new Point(100, 150), new ObjectInformation(new ImageIcon(getClass().getResource(BackPack.THUMBNAIL_PATH)))),
                new BackPack(BackPackType.Type.SMALL, new Point(200, 150), new ObjectInformation(new ImageIcon(getClass().getResource(BackPack.THUMBNAIL_PATH)))),
                new BackPack(BackPackType.Type.SMALL, new Point(300, 150), new ObjectInformation(new ImageIcon(getClass().getResource(BackPack.THUMBNAIL_PATH)))),
                        new BackPack(BackPackType.Type.SMALL, new Point(400, 150), new ObjectInformation(new ImageIcon(getClass().getResource(BackPack.THUMBNAIL_PATH)))),
                        new BackPack(BackPackType.Type.SMALL, new Point(500, 150), new ObjectInformation(new ImageIcon(getClass().getResource(BackPack.THUMBNAIL_PATH))))};
    }

    @Override
    public String getKey() {
        return NAME;
    }

    @Override
    protected String[][] getMatrix() {
        return new String[][]{
                {Grass.KEY, Dirt.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY},
                {Grass.KEY, Dirt.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY},
                {Grass.KEY, Dirt.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY},
                {Grass.KEY, Dirt.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Stone.KEY, Stone.KEY, Stone.KEY, Grass.KEY, Stone.KEY, Stone.KEY, Stone.KEY, Grass.KEY, Stone.KEY, Stone.KEY, Stone.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY},
                {Grass.KEY, Grass.KEY, Dirt.KEY, Grass.KEY, Grass.KEY, Dirt.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Stone.KEY, Grass.KEY, Stone.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY},
                {Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Stone.KEY, Stone.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Stone.KEY, Grass.KEY, Grass.KEY, Stone.KEY, Stone.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY},
                {Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Stone.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Stone.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Stone.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY},
                {Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Stone.KEY, Stone.KEY, Stone.KEY, Grass.KEY, Stone.KEY, Stone.KEY, Stone.KEY, Grass.KEY, Stone.KEY, Stone.KEY, Stone.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY},
                {Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY},
                {Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY},
                {Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY},
                {Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY},
                {Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY},
                {Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY, Grass.KEY}
        };
    }
}
