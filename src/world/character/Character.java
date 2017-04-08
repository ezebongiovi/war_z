package world.character;


import world.character.animation.WalkAnimation;
import world.character.behaviour.CharacterBehaviour;
import world.character.control.Controls;
import world.character.info.CharacterInformation;
import world.objects.AbstractObject;

import javax.swing.*;
import java.awt.*;

/**
 * Created by epasquale on 3/24/17.
 */
public class Character extends AbstractObject implements CharacterBehaviour {

    private final WalkAnimation mWalkAnimation;
    private final CharacterInformation mCharacterInformation;

    // Last two steps made by the character
    private final Point[] steps = new Point[2];


    /**
     * Default constructor for character object
     *
     * @param position             the position in map
     * @param characterInformation the information about this character
     */
    public Character(final Point position, final CharacterInformation characterInformation) {
        super(position, characterInformation);
        mCharacterInformation = characterInformation;
        mWalkAnimation = new WalkAnimation(characterInformation.getType());
    }

    @Override
    public void onMove(final Controls.Directions direction) {
        Point newLocation = null;
        switch (direction) {
            case LEFT:
                newLocation = new Point(getCollisionCircle().getPosition().x - mCharacterInformation.getMovementSpeed(),
                        getCollisionCircle().getPosition().y);
                break;
            case UP:
                newLocation = new Point(getCollisionCircle().getPosition().x,
                        getCollisionCircle().getPosition().y - mCharacterInformation.getMovementSpeed());
                break;
            case RIGHT:
                newLocation = new Point(getCollisionCircle().getPosition().x + mCharacterInformation.getMovementSpeed(),
                        getCollisionCircle().getPosition().y);
                break;
            case DOWN:
                newLocation = new Point(getCollisionCircle().getPosition().x,
                        getCollisionCircle().getPosition().y + mCharacterInformation.getMovementSpeed());
                break;
        }

        steps[0] = getCollisionCircle().getPosition();
        steps[1] = newLocation;

        mCharacterInformation.onIconChanged(new ImageIcon(mWalkAnimation.onMove(direction)));

        getCollisionCircle().setLocation(newLocation);
        mCharacterInformation.getMap().onCharacterMoved(this);
    }

    @Override
    public void receiveDamage(final int damage) {
        mCharacterInformation.getSurvivalState().receiveDamage(damage);
    }

    public CharacterInformation getCharacterInformation() {
        return mCharacterInformation;
    }

    public void undoStep() {
        getCollisionCircle().setLocation(steps[0]);
        mCharacterInformation.getMap().onCharacterMoved(this);
    }

    @Override
    protected Point getCollisionPosition(final Point position) {
        return new Point(position.x + getObjectInformation().getImageIcon().getIconWidth() / 2,
                position.y + getObjectInformation().getImageIcon().getIconHeight());
    }

    @Override
    protected int getCollisionRadius() {
        return 10;
    }
}
