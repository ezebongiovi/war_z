package world.character.behaviour;


import world.character.control.Controls;

/**
 * Created by epasquale on 3/24/17.
 */
public interface CharacterBehaviour {
    void onMove(Controls.Directions direction);

    void receiveDamage(final int damage);
}
