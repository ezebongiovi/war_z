package world.character.type;

import com.sun.javafx.beans.annotations.NonNull;
import world.character.animation.WalkAnimation;

/**
 * Created by epasquale on 3/26/17.
 */
public class DefaultType {

    private final CharacterName mCharacterName;

    public enum CharacterName {
        NICK, STEVE, SHAILA
    }

    public DefaultType(@NonNull final CharacterName characterName) {
        mCharacterName = characterName;
    }

    /**
     * Builds the character's asset path
     *
     * @param type          the asset direction being loaded
     * @return the path to the asset
     */
    public String getWalkSpritePath(@NonNull final WalkAnimation.AnimationType type) {
        final String name = mCharacterName.toString().toLowerCase();
        final String direction = type.toString().toLowerCase();
        return "/players/" + name + "/" + direction + ".png";
    }
}
