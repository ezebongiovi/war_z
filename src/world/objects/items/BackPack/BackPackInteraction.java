package world.objects.items.BackPack;

import world.character.Character;
import world.character.info.Inventory;
import world.objects.interaction.ItemInteraction;
import world.terrain.maps.Map;

/**
 * Created by epasquale on 6/27/17.
 */
public class BackPackInteraction extends ItemInteraction<BackPack> {

    /**
     * Default constructor
     *
     * @param backPack the interactor object
     */
    public BackPackInteraction(final BackPack backPack) {
        super(backPack);
    }

    @Override
    public void interact(final Character character) {
        character.pickUp(getObject());
    }
}
