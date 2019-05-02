import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame{
    Dir dir = Dir.RIGHT;
    Boolean bLeft = false, bRight = false, bUp = false, bDown = false;
    int x = 200, y = 400;
    int speed = 10;
    Boolean moveIng = false;

    public TankFrame(){
        setTitle("坦克大战");
        setVisible(true);
        setSize(800, 600);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        addKeyListener(new MyKeyListener());
    }

    /**
     * 画坦克
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
        move();
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();
            switch (code){
                case KeyEvent.VK_UP:
                    bUp = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bDown = true;
                    break;
                case KeyEvent.VK_LEFT:
                    bLeft = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bRight = true;
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int code = e.getKeyCode();
            switch (code){
                case KeyEvent.VK_UP:
                    bUp = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bDown = false;
                    break;
                case KeyEvent.VK_LEFT:
                    bLeft = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bRight = false;
                    break;
            }
            setMainTankDir();
        }
    }

    void setMainTankDir(){
        if(!bLeft && !bUp && !bRight && !bDown) moveIng = false;
        else {
            moveIng = true;
            if (bLeft) dir = Dir.LEFT;
            if (bRight) dir = Dir.RIGHT;
            if (bUp) dir = Dir.UP;
            if (bDown) dir = Dir.DOWN;
        }

    }

    void move(){
        if (!moveIng) return;
        switch (dir) {
            case LEFT:
                x -= speed;
                break;
            case UP:
                y -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            case DOWN:
                y += speed;
                break;
        }
    }
}
