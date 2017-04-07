package environment.window;

import com.sun.javafx.beans.annotations.NonNull;
import environment.manager.SessionManager;
import world.Map;
import world.character.control.Controls;

import javax.swing.*;
import java.awt.*;

/**
 * Created by epasquale on 3/23/17.
 */
public class GameFrame extends JFrame {

    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private static GameFrame INSTANCE;
    private final Controls mControls;

    /**
     * Window configuration
     */
    public enum WindowType {
        FULLSCREEN, WINDOWED;

    }

    private GameFrame(@NonNull final Map map, @NonNull final Controls controls) {
        mControls = controls;
        setLayout(new BorderLayout());

        add(new TerrainPanel(map, getSize()), BorderLayout.CENTER);
        add(new HUDPanel(SessionManager.getInstance().getLoggedCharacter().getCharacterInformation()),
                BorderLayout.EAST);

        addKeyListener(controls);
    }

    /**
     * Factory method for a singleton frame. By default it's going to be configured
     * as a windowed view
     *
     * @return the singleton
     */
    public static GameFrame getInstance(@NonNull final Map map, @NonNull final Controls controls) {
        if (INSTANCE == null) {
            INSTANCE = new GameFrame(map, controls);

            INSTANCE.setWindowConfiguration(WindowType.WINDOWED);
            INSTANCE.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            INSTANCE.setResizable(false);
            INSTANCE.setAutoRequestFocus(true);
            INSTANCE.setLocationRelativeTo(null);
        }

        return INSTANCE;
    }

    /**
     * Sets a window configuration whether to be full screen or windowed mode
     *
     * @param windowType the window type
     */
    public void setWindowConfiguration(@NonNull final WindowType windowType) {
        if (WindowType.FULLSCREEN.equals(windowType)) {
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            setUndecorated(true);
        } else {
            setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        }
    }
}
