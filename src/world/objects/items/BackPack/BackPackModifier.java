package world.objects.items.BackPack;

import world.character.Character;
import world.character.info.Inventory;
import world.objects.interaction.ItemInteraction;
import world.terrain.maps.Map;

/**
 * Created by epasquale on 6/27/17.
 */
public class BackPackModifier extends ItemInteraction<BackPack> {

    /**
     * Default constructor
     *
     * @param map
     * @param backPack the interactor object
     */
    public BackPackModifier(final Map map, final BackPack backPack) {
        super(map, backPack);
    }

    @Override
    public void interact(final Character character) {
        super.interact(character);
        final Inventory inventory = character.getCharacterInformation().getInventory();

        inventory.setSpace(inventory.getSpace() + BackPackType.getSize(getObject().getType()));
    }
}
