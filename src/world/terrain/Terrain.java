package world.terrain;


import world.terrain.config.Configuration;
import world.terrain.type.AbstractSurface;


/**
 * Created by epasquale on 3/23/17.
 */
public class Terrain {

    private final Configuration mConfiguration;

    /**
     * Default constructor
     *
     * @param configuration the terrain configuration contains the map information
     */
    public Terrain(final Configuration configuration) {
        mConfiguration = configuration;
    }

    public Configuration getConfiguration() {
        return mConfiguration;
    }

    /**
     * Uses the received axis values for calculating the surface type loaded at the given
     * position
     *
     * @param x the x axis position
     * @param y the y axis position
     * @return the type of surface loaded at given position
     */
    public AbstractSurface getSurfaceTypeByCoords(final int x, final int y) {
        return AbstractSurface.getTypeByKey(mConfiguration.getTerrainMatrix()[y / AbstractSurface.DEFAULT_WIDTH]
                [x / AbstractSurface.DEFAULT_HEIGHT]);
    }
}
