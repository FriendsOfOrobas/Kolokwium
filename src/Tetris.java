import javax.swing.*;
import java.awt.*;
public class Tetris {

        private JFrame frame;
        private Panel panel;
        private Timer timer;
        public Tetris() {
            timer = new Timer(50, e -> panel.update());
            frame = new JFrame("Tetris");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            panel = new Panel();
            frame.add(panel);
            frame.setVisible(true);
        }

        public void start(){
            timer.start();
        }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Tetris tetris = new Tetris();
            tetris.start();
        });
    }
}