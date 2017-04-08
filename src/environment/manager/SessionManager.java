package environment.manager;

import com.sun.istack.internal.Nullable;
import world.character.Character;
import world.character.info.CharacterInformation;

import java.awt.*;
import java.net.URL;

/**
 * Created by epasquale on 3/24/17.
 */
public class SessionManager {
    private static SessionManager INSTANCE;
    private Character mCharacter;

    private SessionManager() {

    }

    public static SessionManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SessionManager();
        }

        return INSTANCE;
    }

    /**
     * Called when user has successfully logged in
     *
     * @param characterInformation the character information
     */
    public void login(final Point position, final CharacterInformation characterInformation) {
        mCharacter = new Character(position, characterInformation);
    }

    @Nullable
    public Character getLoggedCharacter() {
        return mCharacter;
    }

    public URL getCharacterIcon() {
        //TODO: Buscar una mejor manera de resolver esto
        return getClass().getResource("/player.png");
    }
}
