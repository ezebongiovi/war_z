package environment.window;

import com.sun.istack.internal.NotNull;
import world.character.info.Inventory;

import javax.swing.*;
import java.awt.*;

/**
 * Created by epasquale on 4/21/17.
 */
public class InventoryPanel extends JPanel {
    private static final int COLS = 2;
    private final Inventory mInventory;

    public InventoryPanel(@NotNull final Inventory inventory) {
        mInventory = inventory;

        initialize();
    }

    private void initialize() {
        removeAll();

        final GridLayout gridLayout = new GridLayout(mInventory.getSpace() / COLS, COLS);
        setLayout(gridLayout);

        setPreferredSize(new Dimension(200, 800));
        gridLayout.preferredLayoutSize(this);

        for (int i = 0; i < mInventory.getSpace(); i++) {
            if (mInventory.getItems().isEmpty() || mInventory.getItems().size() <= i
                    || mInventory.getItems().get(i) == null) {
                final JLabel label = new JLabel();
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                label.setText("Empty");
                add(label, i);
            } else {
                final JLabel label = new JLabel();
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                label.setIcon(mInventory.getItems().get(i).getThumbnail());
                add(label);
            }
        }

        updateUI();
    }

    public void update() {
        initialize();
    }
}
