package dev.quantam;

import java.util.ArrayList;
import java.util.List;

/**
 * A manager class that handles multiple animations.
 *
 * @author quantam
 * @since 23-06-2024
 */
public class AnimationManager {

    private List<AnimationEngine> animations = new ArrayList<>();

    /**
     * Adds an animation to the manager.
     *
     * @param animation The animation to add.
     */
    public void addAnimation(AnimationEngine animation) {
        animations.add(animation);
    }

    /**
     * Updates all animations managed by this manager.
     *
     * @param deltaTime The time elapsed since the last update, in seconds.
     */
    public void update(float deltaTime) {
        for (AnimationEngine animation : animations) {
            animation.update(deltaTime);
        }

        animations.removeIf(animation -> !animation.isRunning());
    }
}
