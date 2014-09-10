package sokolchik.pavel.swingframe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

// основное окно приложения
// implements ActionListener - означает, что объект умеет реагировать на нажатие кнопок интерфейса
public class SwingFrame extends JFrame implements ActionListener {

    // константы игры (размеры поля и сетки)
    public static final int WIDTH = 360;
    public static final int HEIGHT = 360;
    public static final int GRID_STEP = 120;

    public SwingFrame() {
        super("Tic Tac Toe Frame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // установить менеджер компоновки - то есть как распологать элементы в окне
        setLayout(new BorderLayout());
        setSize(WIDTH+15, 420);
        // добавить элемент в в ерхнюю часть окна (Север)
        add(createMenu(), BorderLayout.NORTH);
        // добавить элемент в центр окна(Центр)
        // PaintPanel - это наш собственный класс - панель, на которой можно рисовать
        add(new PaintPanel(WIDTH, HEIGHT, GRID_STEP), BorderLayout.CENTER);
    }

    // создаем меню
    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);

        // добавляем обработчик нажатия, класс реализует интерфейс ActionListener, и мы описали
        // метод obActionPreformed() - что делать при нажатии кнопки Exit
        exitItem.addActionListener(this);
        menuBar.add(fileMenu);
        return menuBar;
    }

    // Запуск графического приложения
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // Создаем объект JFrame - основное окно
        javax.swing.JFrame frame = new SwingFrame();
        // делаем его видимым
        frame.setVisible(true);


    }


    // Что делать когда кнопка нажата
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Exit from game");
        System.exit(0);
    }


}
