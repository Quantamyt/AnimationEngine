package dev.quantam.animation.demo;

import dev.quantam.animation.easings.EaseFunctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A demonstration of multiple animations using Java Swing.
 * This class extends JPanel and implements ActionListener
 * to animate various properties of a shape.
 *
 * @author quantam
 * @since v1.0
 */
public class AnimationDemo extends JPanel implements ActionListener {

    private int circleX, circleY; // Position of the circle
    private float progressX, progressY, progressScale, progressColor; // Progress for animations
    private float animationTimeX, animationTimeY, animationTimeScale, animationTimeColor; // Animation times
    private boolean forwardX, forwardY, forwardScale, forwardColor; // Direction flags for animations
    private Color circleColor; // Color of the circle

    /**
     * Constructs an AnimationDemo instance.
     * Initializes properties and starts the animation timer.
     */
    public AnimationDemo() {
        circleX = 100;
        circleY = 100;
        circleColor = Color.RED;

        // Start the animation timer (roughly 60 FPS)
        Timer timer = new Timer(16, this);
        timer.start();
    }

    /**
     * Updates the position of the circle based on the animation progress.
     */
    private void updatePosition() {
        this.circleX = (int) (100 + 600 * progressX); // Horizontal movement
        this.circleY = (int) (100 + 400 * progressY); // Vertical movement
    }

    /**
     * Updates the scale of the circle based on the animation progress.
     */
    private void updateScale() {
        // Scale from 50 to 200
        float scaleFactor = 50 + 150 * progressScale;
        setPreferredSize(new Dimension((int) scaleFactor, (int) scaleFactor));
        revalidate(); // Ensure layout updates correctly
    }

    /**
     * Updates the color of the circle based on the animation progress.
     */
    private void updateColor() {
        int r = (int) (255 * progressColor); // Red component
        int g = (int) (255 * (1 - progressColor)); // Green component
        circleColor = new Color(r, g, 0); // Transition from red to green
    }

    /**
     * Overrides the paintComponent method to draw the animation on the panel.
     *
     * @param g The Graphics object used for drawing.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(circleColor);
        int diameter = getWidth() / 5; // Diameter based on panel width
        g.fillOval(circleX, circleY, diameter, diameter); // Draw a circle

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString(String.format("X Progress: %.2f", progressX), 20, 30);
        g.drawString(String.format("Y Progress: %.2f", progressY), 20, 50);
        g.drawString(String.format("Scale Progress: %.2f", progressScale), 20, 70);
        g.drawString(String.format("Color Progress: %.2f", progressColor), 20, 90);
    }

    /**
     * Handles the actionPerformed event from the Timer.
     * Updates the animation state and repaints the panel.
     *
     * @param e The ActionEvent triggered by the timer.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        float deltaTime = 0.016F; // Time elapsed per frame (roughly 16 ms)

        // Update X position animation
        if (forwardX) {
            animationTimeX += deltaTime;
            if (animationTimeX >= 2.0F) {
                animationTimeX = 2.0F;
                forwardX = false;
            }
        } else {
            animationTimeX -= deltaTime;
            if (animationTimeX <= 0.0F) {
                animationTimeX = 0.0F;
                forwardX = true;
            }
        }
        progressX = EaseFunctions.easeInOutQuad(animationTimeX / 2.0F);

        // Update Y position animation
        if (forwardY) {
            animationTimeY += deltaTime;
            if (animationTimeY >= 2.0F) {
                animationTimeY = 2.0F;
                forwardY = false;
            }
        } else {
            animationTimeY -= deltaTime;
            if (animationTimeY <= 0.0F) {
                animationTimeY = 0.0F;
                forwardY = true;
            }
        }
        progressY = EaseFunctions.easeInOutCubic(animationTimeY / 2.0F);

        // Update scale animation
        if (forwardScale) {
            animationTimeScale += deltaTime;
            if (animationTimeScale >= 2.0F) {
                animationTimeScale = 2.0F;
                forwardScale = false;
            }
        } else {
            animationTimeScale -= deltaTime;
            if (animationTimeScale <= 0.0F) {
                animationTimeScale = 0.0F;
                forwardScale = true;
            }
        }
        progressScale = EaseFunctions.easeInOutQuart(animationTimeScale / 2.0F);
        updateScale();

        // Update color animation
        if (forwardColor) {
            animationTimeColor += deltaTime;
            if (animationTimeColor >= 2.0F) {
                animationTimeColor = 2.0F;
                forwardColor = false;
            }
        } else {
            animationTimeColor -= deltaTime;
            if (animationTimeColor <= 0.0F) {
                animationTimeColor = 0.0F;
                forwardColor = true;
            }
        }
        progressColor = EaseFunctions.easeInOutExpo(animationTimeColor / 2.0F);
        updateColor();

        repaint(); // Trigger repaint to update the animation
    }

    /**
     * The main entry point for the animation demo application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Animation Demo");
        AnimationDemo panel = new AnimationDemo();
        frame.add(panel);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
