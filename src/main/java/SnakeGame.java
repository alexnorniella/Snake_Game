import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener{


    private class Tile{
        int x;
        int y;

        // Constructor to initialise a tile's position
        Tile(int x, int y){
            this.x = x;
            this.y = y;

        }
    }
    // Game settings
    int boardWidth;
    int boardHeight;
    int tileSize = 25;

    //Snake
    Tile snakeHead;

    //Food
    Tile food;
    //Random Object
    Random random;

    // game logic
    Timer gameLoop;

    // Constructor for SnakeGame class, initialising the board and snake position
    SnakeGame(int boardWidth, int boardHeight){
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        setPreferredSize(new Dimension(this.boardWidth, this.boardHeight));
        setBackground(Color.black);

        snakeHead = new Tile(5,5);

        food = new Tile(10,10);
        random = new Random();
        placeFood();

        gameLoop = new Timer(100,this);
        gameLoop.start();

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

    public void placeFood(){
        food.x = random.nextInt (boardWidth/tileSize);
        food.y = random.nextInt (boardHeight/tileSize);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

    }

}
