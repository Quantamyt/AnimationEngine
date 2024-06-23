package dev.quantam.demo;

import dev.quantam.easings.EaseFunctions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A simple animation demonstration using Java Swing.
 * This class extends JPanel and implements ActionListener
 * to animate a red circle moving back and forth horizontally,
 * with progress displayed in the center, along with x, y position counters and FPS counter.
 *
 * @author quantam
 * @since 23-06-2024
 */
public class AnimationApp extends JPanel implements ActionListener {

    private int circleX, circleY;
    private float progress;
    private float animationTime = 0;
    private boolean forward = true;
    private int frameCount = 0;
    private long startTime;
    private float fps = 0;

    /**
     * Constructs an AnimationApp instance.
     * Initializes circle position and starts the animation timer.
     */
    public AnimationApp() {
        circleX = 100;
        circleY = 100;

        // Start the animation timer (roughly 60 FPS)
        Timer timer = new Timer(16, this);
        timer.start();

        // Schedule a task to update FPS every second
        Timer fpsTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fps = frameCount;
                frameCount = 0;
            }
        });
        fpsTimer.start();

        // Record the start time for FPS calculation
        startTime = System.currentTimeMillis();
    }

    /**
     * Updates the position of the circle based on the animation progress.
     *
     * @param progress The current progress of the animation (0.0 to 1.0).
     */
    private void updatePosition(float progress) {
        this.progress = progress;
        this.circleX = (int) (100 + 600 * progress); // Move the circle horizontally
    }

    /**
     * Overrides the paintComponent method to draw the animation on the panel.
     *
     * @param g The Graphics object used for drawing.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(circleX, circleY, 50, 50); // Draw a red circle

        // Draw progress text in the center of the panel
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString(String.format("Progress: %.2f", progress), getWidth() / 2 - 75, getHeight() / 2);

        // Draw X and Y position counters
        g.drawString(String.format("X: %d", circleX), 20, 30);
        g.drawString(String.format("Y: %d", circleY), 20, 50);

        // Draw FPS counter
        g.drawString(String.format("FPS: %.2f", fps), getWidth() - 100, 30);
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

        // Update animation time and direction
        if (forward) {
            animationTime += deltaTime;
            if (animationTime >= 2.0F) {
                animationTime = 2.0F;
                forward = false;
            }
        } else {
            animationTime -= deltaTime;
            if (animationTime <= 0.0F) {
                animationTime = 0.0F;
                forward = true;
            }
        }

        // Calculate easing progress and update circle position
        float progress = EaseFunctions.easeInOutCubic(animationTime / 2.0F);
        updatePosition(progress);

        // Increment frame count for FPS calculation
        frameCount++;

        repaint(); // Trigger repaint to update the animation
    }

    /**
     * The main entry point for the animation application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Animation Example");
        AnimationApp panel = new AnimationApp();
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
