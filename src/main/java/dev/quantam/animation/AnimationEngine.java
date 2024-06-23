package dev.quantam.animation;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * A class that manages an animation with a specified duration,
 * easing function, and update callback.
 *
 * @author quantam
 * @since v1.0
 */
public class AnimationEngine {

    private float duration;
    private float elapsed;
    private Consumer<Float> updateCallback;
    private Function<Float, Float> easingFunction;
    private boolean running;

    /**
     * Constructs an AnimationEngine with the given parameters.
     *
     * @param duration       The duration of the animation in seconds.
     * @param updateCallback The callback function to update the animation progress.
     * @param easingFunction The easing function to apply for smooth animation.
     */
    public AnimationEngine(float duration, Consumer<Float> updateCallback, Function<Float, Float> easingFunction) {
        this.duration = duration;
        this.updateCallback = updateCallback;
        this.easingFunction = easingFunction;
        this.elapsed = 0;
        this.running = false;
    }

    /**
     * Starts the animation.
     */
    public void start() {
        this.running = true;
    }

    /**
     * Stops the animation.
     */
    public void stop() {
        this.running = false;
    }

    /**
     * Updates the animation progress based on the elapsed time.
     *
     * @param deltaTime The time elapsed since the last update, in seconds.
     */
    public void update(float deltaTime) {
        if (!running) return;

        elapsed += deltaTime;
        if (elapsed > duration) {
            elapsed = duration;
            running = false;
        }

        float progress = easingFunction.apply(elapsed / duration);
        updateCallback.accept(progress);
    }

    /**
     * Checks if the animation is currently running.
     *
     * @return true if the animation is running, false otherwise.
     */
    public boolean isRunning() {
        return running;
    }
}
