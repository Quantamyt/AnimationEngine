package dev.quantam.animation.easings;

/**
 * A collection of easing functions for animations.
 *
 * @author quantam
 * @since v1.0
 */
public class EaseFunctions {

    /**
     * Linear easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float linear(float x) {
        return x;
    }

    /**
     * Ease-in sine easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeInSine(float x) {
        return (float) (1.0 - Math.cos(x * Math.PI / 2.0));
    }

    /**
     * Ease-out sine easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeOutSine(float x) {
        return (float) Math.sin(x * Math.PI / 2.0);
    }

    /**
     * Ease-in-out sine easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeInOutSine(float x) {
        return (float) (-(Math.cos(Math.PI * x) - 1.0) / 2.0);
    }

    /**
     * Ease-in cubic easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeInCubic(float x) {
        return x * x * x;
    }

    /**
     * Ease-out cubic easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeOutCubic(float x) {
        return (float) (1.0 - Math.pow(1.0 - x, 3.0));
    }

    /**
     * Ease-in-out cubic easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeInOutCubic(float x) {
        return (float) (x < 0.5 ? 4.0 * x * x * x : 1.0 - Math.pow(-2.0 * x + 2.0, 3.0) / 2.0);
    }

    /**
     * Ease-in quintic easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeInQuint(float x) {
        return x * x * x * x * x;
    }

    /**
     * Ease-out quintic easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeOutQuint(float x) {
        return (float) (1.0 - Math.pow(1.0 - x, 5.0));
    }

    /**
     * Ease-in-out quintic easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeInOutQuint(float x) {
        return x < 0.5 ? 16.0f * x * x * x * x * x : 1.0f - (float) Math.pow(-2.0 * x + 2.0, 5.0) / 2.0f;
    }

    /**
     * Ease-in quadratic easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeInQuad(float x) {
        return x * x;
    }

    /**
     * Ease-out quadratic easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeOutQuad(float x) {
        return 1.0f - (1.0f - x) * (1.0f - x);
    }

    /**
     * Ease-in-out quadratic easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeInOutQuad(float x) {
        return x < 0.5 ? 2.0f * x * x : 1.0f - (float) Math.pow(-2.0 * x + 2.0, 2.0) / 2.0f;
    }

    /**
     * Ease-in quartic easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeInQuart(float x) {
        return x * x * x * x;
    }

    /**
     * Ease-out quartic easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeOutQuart(float x) {
        return 1.0f - (float) Math.pow(1.0 - x, 4.0);
    }

    /**
     * Ease-in-out quartic easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeInOutQuart(float x) {
        return x < 0.5 ? 8.0f * x * x * x * x : 1.0f - (float) Math.pow(-2.0 * x + 2.0, 4.0) / 2.0f;
    }

    /**
     * Ease-in exponential easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeInExpo(float x) {
        return x == 0.0f ? 0.0f : (float) Math.pow(2.0, 10.0 * (x - 1.0));
    }

    /**
     * Ease-out exponential easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeOutExpo(float x) {
        return x == 1.0f ? 1.0f : (float) (-Math.pow(2.0, -10.0 * x) + 1.0);
    }

    /**
     * Ease-in-out exponential easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeInOutExpo(float x) {
        if (x == 0.0f) return 0.0f;
        if (x == 1.0f) return 1.0f;
        return x < 0.5f ? (float) (Math.pow(2.0, 20.0 * x - 10.0) / 2.0) : (float) (2.0 - Math.pow(2.0, -20.0 * x + 10.0) / 2.0);
    }

    /**
     * Ease-in elastic easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeInElastic(float x) {
        return x == 0.0f ? 0.0f : x == 1.0f ? 1.0f : (float) (-Math.pow(2.0, 10.0 * x - 10.0) * Math.sin((x * 10.0 - 10.75) * (2.0 * Math.PI) / 3.0));
    }

    /**
     * Ease-out elastic easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeOutElastic(float x) {
        return x == 0.0f ? 0.0f : x == 1.0f ? 1.0f : (float) (Math.pow(2.0, -10.0 * x) * Math.sin((x * 10.0 - 0.75) * (2.0 * Math.PI) / 3.0) + 1.0);
    }

    /**
     * Ease-in-out elastic easing function.
     *
     * @param x The input value between 0.0 and 1.0.
     * @return The eased output value.
     */
    public static float easeInOutElastic(float x) {
        if (x == 0.0f) return 0.0f;
        if (x == 1.0f) return 1.0f;
        return x < 0.5f ?
                (float) (-Math.pow(2.0, 20.0 * x - 10.0) * Math.sin((20.0 * x - 11.125) * (2.0 * Math.PI) / 4.5) / 2.0) :
                (float) (Math.pow(2.0, -20.0 * x + 10.0) * Math.sin((20.0 * x - 11.125) * (2.0 * Math.PI) / 4.5) / 2.0 + 1.0);
    }
    // you can add more ease functions if needed!
}
