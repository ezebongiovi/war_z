package world.character.info;

import com.sun.javafx.beans.annotations.NonNull;
import observer.Observer;
import observer.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by epasquale on 4/2/17.
 */
public class SurvivalState extends Subject<SurvivalState> {

    public static final SurvivalState STARTER_STATE = new SurvivalState(new SurvivalProperties.Builder().build(),
            new SurvivalProperties.Builder().build());
    private final SurvivalProperties maxProperties;
    private final SurvivalProperties currentProperties;
    private final List<Observer<SurvivalState>> observers = new ArrayList<>();
    private LifeState lifeState;

    public enum LifeState {
        ALIVE, DEAD
    }

    /**
     * Character's survival state
     *
     * @param maxProperties     the max possible value for every survival property
     * @param currentProperties the current value for every survival property
     */
    public SurvivalState(@NonNull final SurvivalProperties maxProperties,
                         @NonNull final SurvivalProperties currentProperties) {
        this.maxProperties = maxProperties;
        this.currentProperties = currentProperties;
        this.lifeState = getCurrentProperties().getHealth() > 0 ? LifeState.ALIVE : LifeState.DEAD;

        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(stateHandler, 0, 5000);
    }

    public SurvivalProperties getMaxProperties() {
        return maxProperties;
    }

    public SurvivalProperties getCurrentProperties() {
        return currentProperties;
    }

    public void receiveDamage(final int damage) {
        if (getCurrentProperties().health - damage >= 0) {
            getCurrentProperties().health -= damage;

            // Life state
            this.lifeState = getCurrentProperties().getHealth() > 0
                    ? LifeState.ALIVE : LifeState.DEAD;

            setState(this);
        }
    }

    public void addObserver(@NonNull final Observer<SurvivalState> observer) {
        this.observers.add(observer);
    }

    private TimerTask stateHandler = new TimerTask() {

        @Override
        public void run() {

            if (getCurrentProperties().getHungry() - 1 < 0) {
                getCurrentProperties().hungry = 0;
                receiveDamage(1);
                SurvivalState.this.setState(SurvivalState.this);
            } else {
                getCurrentProperties().hungry -= 1;
                SurvivalState.this.setState(SurvivalState.this);
            }

            if (getCurrentProperties().getHydratation() - 1 < 0) {
                getCurrentProperties().hydratation = 0;
                receiveDamage(1);
                SurvivalState.this.setState(SurvivalState.this);
            } else {
                getCurrentProperties().hydratation -= 1;
                SurvivalState.this.setState(SurvivalState.this);
            }
        }
    };
}
