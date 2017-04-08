package world.terrain.config;


import world.terrain.type.AbstractSurface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by epasquale on 3/24/17.
 */
public class Configuration {

    private final String[][] mTerrainMatrix;

    private Configuration(final Builder builder) {
        this.mTerrainMatrix = builder.keyConfiguration;
    }

    public List<AbstractSurface> getTerrainSurface() {
        final List<AbstractSurface> config = new ArrayList<>();

        for (final String[] row : mTerrainMatrix) {

            for (final String col : row) {
                config.add(AbstractSurface.getTypeByKey(col));
            }
        }

        return config;
    }

    public String[][] getTerrainMatrix() {
        return mTerrainMatrix;
    }

    public Point getSize() {
        return new Point(mTerrainMatrix[0].length, mTerrainMatrix.length);
    }

    public static final class Builder {

        private String[][] keyConfiguration;

        public Builder() {

        }

        public Builder withKeyConfiguration(final String[][] keyConfiguration) {
            this.keyConfiguration = keyConfiguration;
            return this;
        }

        public Configuration build() {
            return new Configuration(this);
        }
    }
}
