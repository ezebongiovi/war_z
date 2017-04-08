package environment.window;


import environment.manager.SessionManager;
import world.terrain.maps.Map;
import world.character.behaviour.TerrainPanelListener;
import world.objects.AbstractObject;
import world.terrain.config.Configuration;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by epasquale on 3/24/17.
 */
public class TerrainPanel extends JPanel implements TerrainPanelListener {

    private final Map mMap;
    private Point mPoint;

    /**
     * Default constructor
     *
     * @param map       the map
     * @param dimension the panel size
     */
    public TerrainPanel(final Map map, final Dimension dimension) {
        setPreferredSize(dimension);
        setLocation(0, 0);
        mMap = map;

        map.setTerrainPanelListener(this);
    }

    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        final Configuration configuration = mMap.getTerrain().getConfiguration();

        translate(g);

        int row = 0;
        int col = 0;

        for (int index = 0; index < configuration.getTerrainSurface().size(); index++) {
            final Image image = configuration.getTerrainSurface().get(index).getImageIcon().getImage();


            if (col == mMap.getTerrain().getConfiguration().getSize().x) {
                col = 0;
                row++;
            }

            g.drawImage(image, image.getWidth(null) * col,
                    image.getHeight(null) * row, null);

            col++;
        }

        final java.util.List<AbstractObject> orderedObjects = mMap.getObjects();
        orderedObjects.add(SessionManager.getInstance().getLoggedCharacter());

        Collections.sort(orderedObjects, new Comparator<AbstractObject>() {
            @Override
            public int compare(final AbstractObject o1, final AbstractObject o2) {
                return ((Integer) o1.getCollisionCircle().getCollisionPosition().y)
                        .compareTo((o2.getCollisionCircle().getCollisionPosition().y));
            }
        });

        for (final AbstractObject object : orderedObjects) {

            g.drawImage(object.getObjectInformation().getImageIcon().getImage(), (int) object
                            .getCollisionCircle().getPosition().getX(),
                    (int) object.getCollisionCircle().getPosition().getY(), this);
        }
        orderedObjects.remove(SessionManager.getInstance().getLoggedCharacter());
    }

    private void translate(final Graphics g) {
        if (mPoint == null) {
            return;
        }

        final Graphics copy = g.create();

        copy.translate(mPoint.x * -1 + g.getClipBounds().width / 2,
                mPoint.y * -1 + g.getClipBounds().height / 2);

        final Rectangle bounds = copy.getClipBounds();

        int xTranslation = mPoint.x * -1 + g.getClipBounds().width / 2;
        int yTranslation = mPoint.y * -1 + g.getClipBounds().height / 2;

        if (bounds.getX() <= 0) {
            xTranslation = (int) g.getClipBounds().getX();
        }

        if (bounds.getX() >= bounds.getWidth()) {
            xTranslation = (int) bounds.getWidth() * -1;
        }

        if (bounds.getY() <= 0) {
            yTranslation = (int) g.getClipBounds().getY();
        }

        if (bounds.getY() >= bounds.getHeight()) {
            yTranslation = (int) bounds.getHeight() * -1;
        }

        g.translate(xTranslation, yTranslation);
    }

    public void drawFromPoint(final Point point) {
        mPoint = point;

        repaint();
    }

    @Override
    public String getName() {
        return "TERRAIN";
    }
}