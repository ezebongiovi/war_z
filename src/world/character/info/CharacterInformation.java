package world.character.info;


import com.sun.istack.internal.NotNull;
import world.character.type.DefaultType;
import world.objects.property.ObjectInformation;
import world.terrain.maps.Map;

import javax.swing.*;

/**
 * Created by epasquale on 3/24/17.
 */
public class CharacterInformation extends ObjectInformation {

    private final String id;
    private final int mMovementSpeed;
    private final DefaultType mType;
    private final SurvivalState survivalState;
    private final Inventory mInventory;
    private final Map mMap;

    /**
     * Default hidden constructor
     *
     * @param builder the information's builder
     */
    private CharacterInformation(final Builder builder) {
        super(builder.imageIcon);
        id = builder.id;
        mMap = builder.map;
        mType = builder.type;
        mMovementSpeed = builder.movementSpeed;
        survivalState = builder.survivalState == null ? SurvivalState.STARTER_STATE : builder.survivalState;
        mInventory = builder.inventory;
    }

    public Map getMap() {
        return mMap;
    }

    public int getMovementSpeed() {
        return mMovementSpeed;
    }

    public DefaultType getType() {
        return mType;
    }

    public String getId() {
        return id;
    }

    public void onIconChanged(final ImageIcon imageIcon) {
        mImageIcon = imageIcon;
    }

    public SurvivalState getSurvivalState() {
        return survivalState;
    }

    public Inventory getInventory() {
        return mInventory;
    }

    public static final class Builder {
        private Map map;
        private int movementSpeed;
        private String id;
        private ImageIcon imageIcon;
        private DefaultType type;
        private SurvivalState survivalState;
        private Inventory inventory = new Inventory();

        public Builder setMap(final Map map) {
            this.map = map;
            return this;
        }

        public Builder setMovementSpeed(final int movementSpeed) {
            this.movementSpeed = movementSpeed * 20;
            return this;
        }

        public Builder setId(final String id) {
            this.id = id;
            return this;
        }

        public Builder setImageIcon(final ImageIcon imageIcon) {
            this.imageIcon = imageIcon;
            return this;
        }

        public Builder setSurvivalState(final SurvivalState survivalState) {
            this.survivalState = survivalState;
            return this;
        }

        public Builder setType(final DefaultType type) {
            this.type = type;
            return this;
        }

        public Builder setInventory(@NotNull final Inventory inventory) {
            this.inventory = inventory;
            return this;
        }

        public CharacterInformation build() {
            if (this.map == null) {
                throw new AssertionError("Every character needs a place to start." +
                        "Map or position are null");
            }

            return new CharacterInformation(this);
        }
    }
}
