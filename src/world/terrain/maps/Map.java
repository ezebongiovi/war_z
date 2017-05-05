package world.terrain.maps;


import environment.manager.SessionManager;
import world.character.Character;
import world.behaviour.TerrainPanelListener;
import world.objects.AbstractObject;
import world.objects.property.CollisionCircle;
import world.terrain.Terrain;
import world.terrain.config.Configuration;
import world.terrain.type.AbstractSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by epasquale on 3/23/17.
 */
public abstract class Map {

    private final Terrain mTerrain;
    private final List<AbstractObject> mObjects = new ArrayList<>();

    private TerrainPanelListener mTerrainPanelListener;

    /**
     * Default constructor
     */
    public Map() {
        mTerrain = new Terrain(new Configuration.Builder()
                .withKeyConfiguration(getMatrix()).build());

        for (final AbstractObject object : getMapObjects()) {
            addObject(object);
        }
    }

    protected abstract AbstractObject[] getMapObjects();

    /**
     * Called for adding a character to the map
     *
     * @param object the character being added
     */
    public void addObject(final AbstractObject object) {
        mObjects.add(object);

        if (mTerrainPanelListener != null) {
            mTerrainPanelListener.drawFromPoint(SessionManager.getInstance().getLoggedCharacter()
                    .getCollisionCircle().getPosition());
        }
    }

    /**
     * Called when a character has moved
     *
     * @param character the character which has moved
     */
    public void onCharacterMoved(final Character character) {
        /*
            When the character moves we clean the interactable objects list for being refreshing the list
            and add them back if its needed.
         */
        character.clearInteractableObjects();

        for (final AbstractObject object : mObjects) {
            final CollisionCircle objectCollision = object.getCollisionCircle();
            final CollisionCircle characterCollision = character.getCollisionCircle();

            if (objectCollision.getRadius() > 0) {
                /*
                    If the object drawn has collision we handle collision. Otherwise
                    there's no collision to handle
                 */
                final double dx = objectCollision.getCollisionPosition().getX() - characterCollision.getCollisionPosition().getX();
                final double dy = objectCollision.getCollisionPosition().getY() - characterCollision.getCollisionPosition().getY();
                final double distance = Math.sqrt(dx * dx + dy * dy);

                if (distance < objectCollision.getRadius() + characterCollision.getRadius()) {
                    // Collision detected
                    character.undoStep();

                    /*
                        Adds the interactable object to characters interactable objects for handling when user
                        presses de Action button.
                     */
                    if (object.getObjectInteraction() != null) {
                        character.addInteractableObject(object);
                    }
                }
            }
        }

        if (mTerrainPanelListener != null) {
            mTerrainPanelListener.drawFromPoint(SessionManager.getInstance().getLoggedCharacter()
                    .getCollisionCircle().getPosition());
        }

        // Plays ground sound
        mTerrain.getSurfaceTypeByCoords(character.getCollisionCircle().getCollisionPosition().x,
                character.getCollisionCircle().getCollisionPosition().y).playSound();
    }

    public void removeObject(final AbstractObject object) {
        mObjects.remove(object);
        mTerrainPanelListener.reDraw();
    }

    public Terrain getTerrain() {
        return mTerrain;
    }

    public abstract String getKey();

    protected abstract String[][] getMatrix();

    public void setTerrainPanelListener(final TerrainPanelListener terrainPanelListener) {
        mTerrainPanelListener = terrainPanelListener;
    }

    private AbstractSurface getFloorObjectByCoords(final int x, final int y) {
        return mTerrain.getSurfaceTypeByCoords(x, y);
    }

    public List<AbstractObject> getObjects() {
        return mObjects;
    }
}
