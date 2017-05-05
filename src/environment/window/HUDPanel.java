package environment.window;


import observer.ItemObserver;
import observer.Subject;
import observer.SurvivalStateObserver;
import world.character.info.CharacterInformation;
import world.character.info.SurvivalState;
import world.objects.items.AbstractItem;

import javax.swing.*;
import java.awt.*;

/**
 * Created by epasquale on 3/30/17.
 */
public class HUDPanel extends JPanel {

    private final Subject<SurvivalState> mSurvivalSubject;
    private final Subject<AbstractItem> mItemSubject;
    private final CharacterInformation mCharacterInformation;
    private JProgressBar mHealthBar;
    private JProgressBar mHungryBar;
    private JProgressBar mHydratationBar;
    private InventoryPanel mInventoryPanel;

    /**
     * Default constructor
     *
     * @param characterInformation information being displayed
     */
    public HUDPanel(final CharacterInformation characterInformation) {
        mCharacterInformation = characterInformation;
        mSurvivalSubject = characterInformation.getSurvivalState();
        mSurvivalSubject.setState(characterInformation.getSurvivalState());
        mItemSubject = characterInformation.getInventory();
        mInventoryPanel = new InventoryPanel(characterInformation.getInventory());

        characterInformation.getSurvivalState().addObserver(new SurvivalStateObserver(mSurvivalSubject) {
            @Override
            public void update() {
                updateSurvivalStates();
            }
        });

        characterInformation.getInventory().addObserver(new ItemObserver(mItemSubject) {
            @Override
            public void update() {
                mInventoryPanel.update();
            }
        });

        setPreferredSize(new Dimension(200, 200));

        initializeSurvivalStates();

        add(mInventoryPanel);
    }

    private void initializeSurvivalStates() {
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        setLocation(100, 100);
        setBackground(Color.DARK_GRAY);

        final SurvivalState survivalState = mSurvivalSubject.getState();

        System.out.println("Vida " + mSurvivalSubject.getState().getCurrentProperties().getHealth());

        // Adding Health label
        final JLabel healthLabel = new JLabel("Vida");
        healthLabel.setForeground(Color.WHITE);

        final JLabel hungryLabel = new JLabel("Hambre");
        hungryLabel.setForeground(Color.WHITE);

        final JLabel hydratationLabel = new JLabel("Hidratación");
        hydratationLabel.setForeground(Color.WHITE);

        // Adding Health view
        mHealthBar = new JProgressBar();
        mHealthBar.setMaximum(survivalState.getMaxProperties().getHealth());
        mHealthBar.setValue(survivalState.getCurrentProperties().getHealth());
        mHealthBar.setVisible(true);
        mHealthBar.setStringPainted(true);
        mHealthBar.setString(survivalState.getCurrentProperties().getHealth() + "/"
                + survivalState.getMaxProperties().getHealth());
        mHealthBar.setForeground(Color.RED);

        // Adding Health view
        mHungryBar = new JProgressBar();
        mHungryBar.setMaximum(survivalState.getMaxProperties().getHungry());
        mHungryBar.setValue(survivalState.getCurrentProperties().getHungry());
        mHungryBar.setVisible(true);
        mHungryBar.setStringPainted(true);
        mHungryBar.setString(survivalState.getCurrentProperties().getHungry() + "/"
                + survivalState.getMaxProperties().getHungry());
        mHungryBar.setForeground(Color.RED);

        // Adding Health view
        mHydratationBar = new JProgressBar();
        mHydratationBar.setMaximum(survivalState.getMaxProperties().getHealth());
        mHydratationBar.setValue(survivalState.getCurrentProperties().getHealth());
        mHydratationBar.setVisible(true);
        mHydratationBar.setStringPainted(true);
        mHydratationBar.setString(survivalState.getCurrentProperties().getHealth() + "/"
                + survivalState.getMaxProperties().getHealth());
        mHydratationBar.setForeground(Color.RED);

        add(healthLabel);
        add(mHealthBar);
        add(hungryLabel);
        add(mHungryBar);
        add(hydratationLabel);
        add(mHydratationBar);
    }

    private void updateSurvivalStates() {
        mHealthBar.setString(mSurvivalSubject.getState().getCurrentProperties().getHealth() + "/"
                + mSurvivalSubject.getState().getMaxProperties().getHealth());
        mHealthBar.setValue(mSurvivalSubject.getState().getCurrentProperties().getHealth());

        mHungryBar.setString(mSurvivalSubject.getState().getCurrentProperties().getHungry() + "/"
                + mSurvivalSubject.getState().getMaxProperties().getHungry());

        mHungryBar.setValue(mSurvivalSubject.getState().getCurrentProperties().getHungry());

        mHydratationBar.setString(mSurvivalSubject.getState().getCurrentProperties().getHydratation() + "/"
                + mSurvivalSubject.getState().getMaxProperties().getHydratation());

        mHydratationBar.setValue(mSurvivalSubject.getState().getCurrentProperties().getHydratation());
    }
}
