
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;


public class Board extends JPanel{
      
    private Snake snake;
    private Timer timer;
    private Food food;
    private int deltaTime;
    
    
    public Board() {
        super();
        snake = new Snake(3);
        food = new Food(false, snake);
        deltaTime = 1000;
        timer = new Timer(deltaTime, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                mainLoop();
            }
        });
        timer.start();
        
    }
    
    public Board(int numRows, int numCols) {
        
    }
    
    public void mainLoop() {
        if(true) {
            
        } else {
            switch(snake.getDirection()) {
                case UP: snake.moveUp();
                    break;
                case DOWN: snake.moveDown();
                    break;
                case RIGHT: snake.moveRight();
                    break;
                case LEFT: snake.moveLeft();
                    break;
                default: 
            }
        repaint();
        
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        snake.paint(g2d, getSquareWidth(), getSquareHeight());
        food.paint(g2d, getSquareWidth(), getSquareHeight());
    }
    
    public int getSquareWidth() {
        return getWidth()/Configuration.numCols;
    }
    
    public int getSquareHeight() {
        return getHeight()/Configuration.numRows;
    }
    
    public static void drawSquare(Graphics2D g, int squareWidth, int squareHeight, int row, int col, Color color) {
        int x = col * squareWidth;
        int y = row * squareHeight;
        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth - 2, squareHeight - 2);
        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight - 1, x, y);
        g.drawLine(x, y, x + squareWidth - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight - 1, x + squareWidth - 1, y + squareHeight - 1);
        g.drawLine(x + squareWidth - 1, y + squareHeight - 1, x + squareWidth - 1, y + 1);
    }
}
