package sokolchik.pavel.swingframe;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// У интерфейса есть много методов - на каждое действие мыши
public class SampleMouseAdapter implements MouseListener {

    private PaintPanel panel;
    static int turn;

    public SampleMouseAdapter(PaintPanel panel) {
        this.panel = panel;
    }

    // кликнули = нажали+отпустили
    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        panel.markCell(x, y);
        turn++;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
