package world.character.behaviour;

import com.sun.javafx.beans.annotations.NonNull;
import world.character.control.Controls;

/**
 * Created by epasquale on 3/24/17.
 */
public interface CharacterBehaviour {
    void onMove(@NonNull Controls.Directions direction);

    void receiveDamage(final int damage);
}
