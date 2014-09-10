package sokolchik.pavel.swingframe;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

// Панель на которой можно рисовать
public class PaintPanel extends JPanel {

    private int width, height;
    private int gridStep;
    // Список фигур, которые нужно отрисовать

    enum owner {None, Cross, Round}

    private List<Cell> crosses = new ArrayList<Cell>();
    private List<Cell> zeroes = new ArrayList<Cell>();


    public PaintPanel(int width, int height, int gridStep) {
        setPreferredSize(new Dimension(width, height));
        this.width = width;
        this.height = height;
        this.gridStep = gridStep;
        // панель умеет реагировать на нажатие мыши
        // SampleMouseAdapter - самодельный класс, который описывает, что нужно делать при
        // нажатии кнопок мыши, в его конструктор я передаю ссылку на текущую панель,
        // чтобы обработчик мог взаимодействовать с панелью
        addMouseListener(new SampleMouseAdapter(this));
}


    // метод, который рисует графические элементы на окне
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Сейчас везде используем Graphics2D (Graphics - оставлен для обратной совместимости)
        Graphics2D g2d = (Graphics2D) g;

        // рисуем все фигуры из списка
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(10.0f));
        for (Cell c : crosses) {
            c.drawCross(g2d);
        }

        g2d.setColor(Color.BLUE);
        for (Cell c : zeroes) {
            c.drawCircle(g2d);
        }

        // рисуем сетку
        g2d.setColor(Color.GRAY);

        for (int i = 0; i < width; i += gridStep) {
            g2d.drawLine(i, 0, i, height - 1);
        }
        for (int i = 0; i < height; i += gridStep) {
            g2d.drawLine(0, i, width - 1, i);
        }

    }

    // по координатам мыши определяем в какой клетке находится указатель мыши
    // и добавляем фигуру квадрат соответствующего размера в список
    //
    public void markCell(int x, int y) {
        System.out.println("Mark cell: " + x + "," + y);
        if (x >= 0 && x < width && y >=0 && y < height) {
            // в каую клетку ткнули (нам известны только координаты)
            int cellX = (x / gridStep) * gridStep;
            int cellY = (y / gridStep) * gridStep;
            int i =cellX/gridStep;
            int j =cellY/gridStep;
            if (SampleMouseAdapter.turn%2 == 0 ){
                crosses.add(new Cell(cellX, cellY));
            }
            else {
                zeroes.add(new Cell(cellX, cellY));
            }



            // этот метод автоматически вызовет перерисовку панели
            repaint();
        }
    }




}
