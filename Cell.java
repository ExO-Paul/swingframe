package sokolchik.pavel.swingframe;

import java.awt.*;

/**
 * Created by sokolchik_p on 10.09.2014.
 */
public class Cell {
    int x,y;

    public Cell(){};

    public Cell(int x, int y)
    {this.x=x;
    this.y = y;}

    void drawCross(Graphics2D g2d){
        g2d.drawLine(x+10,y+10,x+SwingFrame.GRID_STEP-10, y+SwingFrame.GRID_STEP-10);
        g2d.drawLine(x+SwingFrame.GRID_STEP-10,y+10, x+10 , y+SwingFrame.GRID_STEP-10);
    }

    void drawCircle(Graphics2D g2d){
        g2d.drawOval(x+10,y+10,SwingFrame.GRID_STEP-20, SwingFrame.GRID_STEP-20);
    }
}
