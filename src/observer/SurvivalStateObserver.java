package observer;

import com.sun.javafx.beans.annotations.NonNull;
import world.character.info.SurvivalState;

/**
 * Created by epasquale on 4/2/17.
 */
public class SurvivalStateObserver extends Observer<SurvivalState> {

    /**
     * Default constructor
     *
     * @param subject the subject object
     */
    public SurvivalStateObserver(@NonNull final Subject<SurvivalState> subject) {
        super(subject);
    }

    @Override
    public void update() {

    }
}
