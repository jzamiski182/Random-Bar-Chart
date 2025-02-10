import javax.swing.JFrame;

public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Random Bar Chart");
        BarChart chart = new BarChart();

        frame.add(chart);
        frame.setSize(550, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
