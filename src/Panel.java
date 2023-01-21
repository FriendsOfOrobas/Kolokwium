import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel extends JPanel {
    private ArrayList<Square> squares;
    public Panel(){
        squares = new ArrayList<Square>();
        squares.add(new Square(this));
    }

    public void addSquare(){squares.add(new Square(this));}

    @Override
    public void paintComponent(Graphics g) {
        repaint();
        for (Square sq : squares) {
            sq.draw(g);
        }
    }

    public ArrayList<Square> getSquares(){
        return squares;
    }
    public void update() {

        for (Square sq : squares) {
                sq.update();
        }
        repaint();
    }
}
