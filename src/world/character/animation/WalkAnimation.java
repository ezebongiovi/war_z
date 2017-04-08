package world.character.animation;


import world.character.control.Controls;
import world.character.type.DefaultType;

import java.net.URL;

/**
 * Created by epasquale on 3/26/17.
 */
public class WalkAnimation {

    public enum AnimationType {
        WALK_LEFT, STOP_LEFT, WALK_LEFT_2,
        WALK_RIGHT, STOP_RIGHT, WALK_RIGHT_2,
        WALK_UP, STOP_UP, WALK_UP_2,
        WALK_DOWN, STOP_DOWN, WALK_DOWN_2
    }

    private final DefaultType mType;
    private AnimationType mState = AnimationType.STOP_DOWN;
    private AnimationType mNextState = AnimationType.WALK_DOWN;

    /**
     * Default constructor
     *
     * @param type the type of character being used
     */
    public WalkAnimation(final DefaultType type) {
        mType = type;
    }

    public URL onMove(final Controls.Directions direction) {
        if (direction.equals(Controls.Directions.DOWN)) {
            if (!mState.equals(AnimationType.STOP_DOWN) && !mState.equals(AnimationType.WALK_DOWN)
                    && !mState.equals(AnimationType.WALK_DOWN_2)) {
                mState = AnimationType.STOP_DOWN;
                mNextState = AnimationType.WALK_DOWN;
            } else if (mState.equals(AnimationType.STOP_DOWN)) {
                mState = mNextState;
            } else if (mState.equals(AnimationType.WALK_DOWN)) {
                mState = AnimationType.STOP_DOWN;
                mNextState = AnimationType.WALK_DOWN_2;
            } else if (mState.equals(AnimationType.WALK_DOWN_2)) {
                mState = AnimationType.STOP_DOWN;
                mNextState = AnimationType.WALK_DOWN;
            }
        } else if (direction.equals(Controls.Directions.LEFT)) {
            if (!mState.equals(AnimationType.WALK_LEFT) && !mState.equals(AnimationType.STOP_LEFT)
                    && !mState.equals(AnimationType.WALK_LEFT_2)) {
                mState = AnimationType.STOP_LEFT;
                mNextState = AnimationType.WALK_LEFT;
            } else if (mState.equals(AnimationType.STOP_LEFT)) {
                mState = mNextState;
            } else if (mState.equals(AnimationType.WALK_LEFT)) {
                mState = AnimationType.STOP_LEFT;
                mNextState = AnimationType.WALK_LEFT_2;
            } else if (mState.equals(AnimationType.WALK_LEFT_2)) {
                mState = AnimationType.STOP_LEFT;
                mNextState = AnimationType.WALK_LEFT;
            }
        } else if (direction.equals(Controls.Directions.RIGHT)) {
            if (!mState.equals(AnimationType.WALK_RIGHT) && !mState.equals(AnimationType.STOP_RIGHT)
                    && !mState.equals(AnimationType.WALK_RIGHT_2)) {
                mState = AnimationType.STOP_RIGHT;
                mNextState = AnimationType.WALK_RIGHT;
            } else if (mState.equals(AnimationType.STOP_RIGHT)) {
                mState = mNextState;
            } else if (mState.equals(AnimationType.WALK_RIGHT)) {
                mState = AnimationType.STOP_RIGHT;
                mNextState = AnimationType.WALK_RIGHT_2;
            } else if (mState.equals(AnimationType.WALK_RIGHT_2)) {
                mState = AnimationType.STOP_RIGHT;
                mNextState = AnimationType.WALK_RIGHT;
            }
        } else if (direction.equals(Controls.Directions.UP)) {
            if (!mState.equals(AnimationType.WALK_UP) && !mState.equals(AnimationType.STOP_UP)
                    && !mState.equals(AnimationType.WALK_UP_2)) {
                mState = AnimationType.STOP_UP;
                mNextState = AnimationType.WALK_UP;
            } else if (mState.equals(AnimationType.STOP_UP)) {
                mState = mNextState;
            } else if (mState.equals(AnimationType.WALK_UP)) {
                mState = AnimationType.STOP_UP;
                mNextState = AnimationType.WALK_UP_2;
            } else if (mState.equals(AnimationType.WALK_UP_2)) {
                mState = AnimationType.STOP_UP;
                mNextState = AnimationType.WALK_UP;
            }
        }

        return getClass().getResource(mType.getWalkSpritePath(mState));
    }
}
