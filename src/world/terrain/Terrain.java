package world.terrain;

import com.sun.javafx.beans.annotations.NonNull;
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
    public Terrain(@NonNull final Configuration configuration) {
        mConfiguration = configuration;
    }

    public Configuration getConfiguration() {
        return mConfiguration;
    }

    public AbstractSurface getTypeByCoords(final int x, final int y) {
        return AbstractSurface.getTypeByKey(mConfiguration.getTerrainMatrix()[y / 128][x / 128]);
    }
}
