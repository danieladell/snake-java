
import java.awt.Color;
import java.awt.Graphics2D;


class Food extends Node {
    
    private int randomCol;
    private int randomRow;
    
    public Food(boolean special, Snake snake) {
        super(0,0);
        setRow(randomRow());
        setCol(randomCol());
    }
    
    public int randomCol(){
        return randomCol = (int)(Math.random()*Configuration.numCols);
    }
    
    public int randomRow() {
        return randomRow = (int)(Math.random()*Configuration.numRows);
    }
    
    void paint(Graphics2D g2d, int squareWidth, int squareHeight) {
        Board.drawSquare(g2d, squareWidth, squareHeight, randomRow, randomCol, Color.RED);
    }
    
}
