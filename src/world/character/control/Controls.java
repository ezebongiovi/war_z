package world.character.control;

import environment.manager.SessionManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by epasquale on 3/24/17.
 */
public class Controls implements KeyListener {

    public enum Directions {
        LEFT, UP, RIGHT, DOWN
    }

    @Override
    public void keyTyped(final KeyEvent e) {

    }

    @Override
    public void keyPressed(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            SessionManager.getInstance().getLoggedCharacter().onMove(Directions.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            SessionManager.getInstance().getLoggedCharacter().onMove(Directions.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            SessionManager.getInstance().getLoggedCharacter().onMove(Directions.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            SessionManager.getInstance().getLoggedCharacter().onMove(Directions.DOWN);
        }
    }

    @Override
    public void keyReleased(final KeyEvent e) {

    }
}
