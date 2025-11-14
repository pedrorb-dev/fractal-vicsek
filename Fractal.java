import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Fractal extends JFrame {
    private Timer timer;
    private int paso = 0;
    public Fractal() {
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        timer = new Timer(1300, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paso++;
                if (paso > 4) timer.stop();
                repaint();
            }
        });
        timer.start();

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (timer.isRunning()) {
                        timer.stop();
                    } else {
                        timer.start();
                    }
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        dibujarFractal(g, getWidth()/2, 0, getWidth() / 4, getHeight() / 4);

        if(paso>=1) {
            g.setColor(Color.white);
            super.paint(g);
            g.setColor(Color.black);
            dibujarFractal(g, getWidth()/2, 1, getWidth() / 4 + 50, getHeight() / 4 + 50);
        }
        if(paso>=2) {
            g.setColor(Color.white);
            super.paint(g);
            g.setColor(Color.black);
            dibujarFractal(g, getWidth()/2, 2, getWidth() / 4 + 60, getHeight() / 4 + 60);
        }
        if(paso>=3) {
            g.setColor(Color.white);
            super.paint(g);
            g.setColor(Color.black);
            dibujarFractal(g, getWidth()/2, 3, getWidth() / 4 + 70, getHeight() / 4 + 70);
        }
        if(paso>=4) {
            g.setColor(Color.white);
            super.paint(g);
            g.setColor(Color.black);
            dibujarFractal(g, getWidth()/2, 4, getWidth() / 4 + 80, getHeight() / 4 + 80);
        }
        if(paso>=5) {
            g.setColor(Color.white);
            super.paint(g);
            g.setColor(Color.black);
            dibujarFractal(g, getWidth()/2, 5, getWidth() / 4 + 90, getHeight() / 4 + 90);
        }
    }

    private void dibujarFractal(Graphics g, int tam, int itera, int x, int y) {
        if(itera == 0) {
            g.fillRect(x, y, tam, tam);
            return;
        }
        tam /= 3;

        dibujarFractal(g, tam, itera-1, x, y);
        dibujarFractal(g, tam, itera-1, x + tam, y);
        dibujarFractal(g, tam, itera-1, x - tam, y);
        dibujarFractal(g, tam, itera-1, x, y + tam);
        dibujarFractal(g, tam, itera-1, x, y - tam);
    }

    public static void main(String[] args) {
        new Fractal().setVisible(true);
    }
}
