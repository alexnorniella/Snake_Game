import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SnakeGame extends JPanel {
    private class Tile{
        int x;
        int y;
        Tile(int x, int y){
            this.x = x;
            this.y = y;

        }
    }
    int boardWidth;
    int boardHeight;
    int tileSize = 25;

    //Snake
    Tile snakeHead;

    //Food
    Tile food;


    SnakeGame(int boardWidth, int boardHeight){
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.black);

        snakeHead = new Tile(5,5);

        food = new Tile(10,10);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g){
        // Grid
        g.setColor(Color.gray);
        for(int i = 0; i< boardWidth/tileSize; i++){
            //(x1, y1, x2, y2)
            g.drawLine(i*tileSize, 0, i*tileSize, boardHeight);
            g.drawLine(0, i*tileSize, boardWidth, i*tileSize);

        }
        // Food

        g.setColor(Color.red);
        g.fillRect(food.x * tileSize, food.y * tileSize , tileSize,tileSize);
        //Snake
        g.setColor(Color.green);
        g.fillRect(snakeHead.x *tileSize, snakeHead.y *tileSize,tileSize,tileSize);

    }

}
