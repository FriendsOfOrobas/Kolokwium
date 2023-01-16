import java.util.ArrayList;
import java.util.Random;
import java.awt.*;
public class Square {
    private int x;
    private int y;
    private int size = 10;
    private int dy;
    private int dx;
    private Random random = new Random();
    private Thread thread;
    private Panel panel;
    public Square(Panel panel){
        this.panel = panel;
        this.x = random.nextInt(60)*10;
        this.y = 0;
        this.dy = 10;
        this.dx = 0;
        thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                panel.repaint();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });
        thread.start();
    }

    public void checkerCollision(){
        ArrayList<Square> sqs = (ArrayList<Square>) panel.getSquares().clone();
        sqs.remove(this);
        for(Square sq : sqs){
            if(y+10 == sq.y || y+10==600){
                dy=0;
                panel.addSquare();
                thread.stop();
            }
        }
    }
    public void update() {
        checkerCollision();
        this.x += this.dx;
        this.y += this.dy;
    }
    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, size, size);
    }
}
