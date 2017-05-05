package environment;

import com.sun.istack.internal.Nullable;
import environment.manager.SessionManager;
import environment.window.GameFrame;
import world.character.Character;
import world.character.control.Controls;
import world.character.info.CharacterInformation;
import world.character.type.DefaultType;
import world.terrain.maps.DemoMap;
import world.terrain.type.AbstractSurface;

import javax.swing.*;
import java.awt.*;

/**
 * Created by epasquale on 3/23/17.
 */
public class Main {

    /**
     * Environment initialization
     *
     * @param args the arguments
     */
    public static void main(@Nullable final String[] args) {
        AbstractSurface.initialize();


        final DemoMap demoMap = new DemoMap();

        SessionManager.getInstance().login(new Point(0, 0),
                new CharacterInformation.Builder().setId("ezebongiovi")
                .setMap(demoMap).setMovementSpeed(1)
                .setImageIcon(new ImageIcon(SessionManager.getInstance().getCharacterIcon()))
                .setType(new DefaultType(DefaultType.CharacterName.NICK)).build());

        final GameFrame gameFrame = GameFrame.getInstance(demoMap, new Controls());
        gameFrame.setWindowConfiguration(GameFrame.WindowType.FULLSCREEN);
        gameFrame.setVisible(true);
    }
}
