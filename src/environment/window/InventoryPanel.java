package environment.window;

import com.sun.istack.internal.NotNull;
import world.character.info.Inventory;

import javax.swing.*;
import java.awt.*;

/**
 * Created by epasquale on 4/21/17.
 */
public class InventoryPanel extends JPanel {
    private static final int ROWS = 4;
    private static final int COLS = 3;
    private final Inventory mInventory;

    public InventoryPanel(@NotNull final Inventory inventory) {
        mInventory = inventory;

        initialize();
    }

    private void initialize() {
        setLayout(new GridLayout(4, 3));

        for (int i = 0; i < ROWS * COLS; i++) {
            if (mInventory.getItems().isEmpty() || mInventory.getItems().size() <= i) {
                add(new JLabel("Empty"));
            } else {
                final JLabel label = new JLabel("Sarasa");
                label.setIcon(mInventory.getItems().get(i).getThumbnail());
                add(label);
            }
        }
    }

    public void update() {
        removeAll();
        initialize();
    }
}
