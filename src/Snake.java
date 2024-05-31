
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;


public class Snake {
    
        class MyKeyAdapter extends KeyAdapter {
        
        @Override
        public void keyPressed(KeyEvent e) {
            
            switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT: 
                    moveLeft();
                break;
            case KeyEvent.VK_RIGHT: 
                    moveRight();
                break;
            case KeyEvent.VK_UP: 
                    moveUp();
                break;
            case KeyEvent.VK_DOWN: 
                    moveDown();
                break;
            default:
                break;
            }
        }
    }
    
    private List<Node> body;
    private Direction direction;
    private int remainGrow;
    

    
    public Snake(int numNodes) {
        body = new ArrayList<>();
        direction = Direction.STOP;
        remainGrow = 0;
        
        for(int col = 0; col < numNodes; col++) {
                body.add(new Node(0, col));
        }     
    }
       
    public void paint(Graphics2D g, int squareWidth, int squareHeight) {
        for(int i = 0; i<body.size(); i++) {
            Board.drawSquare(g, squareWidth, squareHeight, body.get(i).getRow(), body.get(i).getCol(), Color.GREEN);
        }
    }
    
    public void moveUp() {
        direction = Direction.UP;
        
    }
    
    public void moveDown() {
        direction = Direction.DOWN;
        
        
    }
    
    public void moveRight() {
        direction = Direction.RIGHT;
        
    }
    
    public void moveLeft() {
        direction = Direction.LEFT;
    }
    
    public boolean canMove(Direction direction) {
        if(direction.equals(Direction.DOWN)) {
            return false;
        }
        return true;
    }
    
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public Direction getDirection() {
        return direction;
    }

}
