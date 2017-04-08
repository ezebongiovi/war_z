package environment.window;


import observer.Subject;
import observer.SurvivalStateObserver;
import world.character.info.CharacterInformation;
import world.character.info.SurvivalState;

import javax.swing.*;
import java.awt.*;

/**
 * Created by epasquale on 3/30/17.
 */
public class HUDPanel extends JPanel {

    private final Subject<SurvivalState> mSubject;
    private CharacterInformation mCharacterInformation;
    private JProgressBar mHealthBar;
    private JProgressBar mHungryBar;
    private JProgressBar mHydratationBar;

    /**
     * Default constructor
     *
     * @param characterInformation information being displayed
     */
    public HUDPanel(final CharacterInformation characterInformation) {
        mCharacterInformation = characterInformation;
        mSubject = characterInformation.getSurvivalState();
        mSubject.setState(characterInformation.getSurvivalState());

        characterInformation.getSurvivalState().addObserver(new SurvivalStateObserver(mSubject) {
            @Override
            public void update() {
                updatePanel();
            }
        });

        setPreferredSize(new Dimension(200, 200));

        initialize();
    }

    private void initialize() {
        setVisible(true);
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        setLocation(100, 100);
        setBackground(Color.DARK_GRAY);

        final SurvivalState survivalState = mSubject.getState();

        System.out.println("Vida " + mSubject.getState().getCurrentProperties().getHealth());

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

    private void updatePanel() {
        mHealthBar.setString(mSubject.getState().getCurrentProperties().getHealth() + "/"
                + mSubject.getState().getMaxProperties().getHealth());
        mHealthBar.setValue(mSubject.getState().getCurrentProperties().getHealth());

        mHungryBar.setString(mSubject.getState().getCurrentProperties().getHungry() + "/"
                + mSubject.getState().getMaxProperties().getHungry());

        mHungryBar.setValue(mSubject.getState().getCurrentProperties().getHungry());

        mHydratationBar.setString(mSubject.getState().getCurrentProperties().getHydratation() + "/"
                + mSubject.getState().getMaxProperties().getHydratation());

        mHydratationBar.setValue(mSubject.getState().getCurrentProperties().getHydratation());
    }
}
