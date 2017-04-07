package world.terrain.type;

import java.net.URL;

/**
 * Created by epasquale on 3/24/17.
 */
public class Stone extends AbstractSurface {
    private static final String KEY = "S";
    private static final String PATH = "/floor_stone.png";

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    protected String getSoundPath() {
        return "/sound/footstep_stone.wav";
    }

    @Override
    URL getFilePath() {
        return getClass().getResource(PATH);
    }
}
