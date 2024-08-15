import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingCar extends JPanel implements ActionListener {
    private Timer timer; // Timer to handle the animation
    private int carX = 0; // Car's horizontal position
    private final int carY = 100; // Car's vertical position
    private final int carWidth = 100; // Car's width
    private final int carHeight = 50; // Car's height
    private final int carSpeed = 5; // Speed at which the car moves

    public MovingCar() {
        timer = new Timer(30, this); // Create a timer that triggers every 30ms
        timer.start(); // Start the timer
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the car (a simple rectangle in this case)
        g.setColor(Color.RED);
        g.fillRect(carX, carY, carWidth, carHeight);

        // Optionally, draw wheels
        g.setColor(Color.BLACK);
        g.fillOval(carX + 10, carY + carHeight - 20, 20, 20);
        g.fillOval(carX + carWidth - 30, carY + carHeight - 20, 20, 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update car position
        carX += carSpeed;

        // Reset car position if it moves off the screen
        if (carX > getWidth()) {
            carX = -carWidth;
        }

        // Repaint the panel
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Car Animation");
        MovingCar movingCarPanel = new MovingCar();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600); // Set the size of the window
        frame.add(movingCarPanel); // Add the custom panel to the frame
        frame.setVisible(true); // Make the window visible
    }
}

 