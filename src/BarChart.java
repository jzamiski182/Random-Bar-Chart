import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.BasicStroke;
import java.util.Random;

public class BarChart extends JPanel
{
    private JButton button;
    private JPanel panel;

    public BarChart()
    {
        setLayout(new BorderLayout());

        button = new JButton("Redraw");
        panel = new JPanel(new FlowLayout());

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                repaint();
            }
        });
        button.setPreferredSize(new Dimension(510, 25));

        panel.add(button);
        add(panel, BorderLayout.PAGE_END);
    }

    @Override
    protected void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        drawGrid(graphics);
        drawBars(graphics);
    }

    private void drawGrid(Graphics graphics)
    {
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setStroke(new BasicStroke(1.2f));

        // drawing 10 X 10 grid
        for (int i = 0; i < 110; i += 10) {
            // drawing vertical lines
            graphics2D.drawLine(120 + (i * 3), 40, 120 + (i * 3), 340);

            // drawing horizontal lines
            graphics2D.drawLine(120, 40 + (i * 3), 420, 40 + (i * 3));
        }
    }

    private void drawBars(Graphics graphics)
    {
        Random rand = new Random();
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics2D.setStroke(new BasicStroke(10.0f));
        for (int i = 0; i < 60; i += 5) {
            // sets each RGB value to a random number between 0 and 255 inclusive
            graphics2D.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
            // sets a random height for each bar
            graphics2D.drawLine(150 + (i * 4), rand.nextInt(310 - 60) + 60, 150 + (i * 4), 334);
        }
    }
}
