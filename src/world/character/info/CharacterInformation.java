package world.character.info;

import com.sun.javafx.beans.annotations.NonNull;
import world.Map;
import world.character.type.DefaultType;
import world.objects.property.ObjectInformation;

import javax.swing.*;

/**
 * Created by epasquale on 3/24/17.
 */
public class CharacterInformation extends ObjectInformation {

    private final String id;
    private final int mMovementSpeed;
    private final DefaultType mType;
    private final SurvivalState survivalState;

    /**
     * Default hidden constructor
     *
     * @param builder the information's builder
     */
    private CharacterInformation(@NonNull final Builder builder) {
        super(builder.map, builder.imageIcon);
        id = builder.id;
        mType = builder.type;
        mMovementSpeed = builder.movementSpeed;
        survivalState = builder.survivalState == null ? SurvivalState.STARTER_STATE : builder.survivalState;
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

    public void onIconChanged(@NonNull final ImageIcon imageIcon) {
        mImageIcon = imageIcon;
    }

    public SurvivalState getSurvivalState() {
        return survivalState;
    }

    public static final class Builder {
        private Map map;
        private int movementSpeed;
        private String id;
        private ImageIcon imageIcon;
        private DefaultType type;
        private SurvivalState survivalState;

        public Builder setMap(@NonNull final Map map) {
            this.map = map;
            return this;
        }

        public Builder setMovementSpeed(final int movementSpeed) {
            this.movementSpeed = movementSpeed * 20;
            return this;
        }

        public Builder setId(@NonNull final String id) {
            this.id = id;
            return this;
        }

        public Builder setImageIcon(@NonNull final ImageIcon imageIcon) {
            this.imageIcon = imageIcon;
            return this;
        }

        public Builder setSurvivalState(@NonNull final SurvivalState survivalState) {
            this.survivalState = survivalState;
            return this;
        }

        public Builder setType(@NonNull final DefaultType type) {
            this.type = type;
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
