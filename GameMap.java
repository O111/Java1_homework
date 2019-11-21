package homework.lesson_7;

import javax.swing.*;
import java.awt.*;

/*
1. Полностью разобраться с кодом
(попробовать полностью самостоятельно переписать одно из окон)

2. Составить список вопросов и приложить в виде комментария к домашней работе

3. * Расчертить панель Map на поле для игры, согласно fieldSize

* */

public class GameMap extends JPanel {
    public static final int GM_HVH = 0;
    public static final int GM_HVA = 1;

    private static final int gap = 1;  // половина зазора между ячейками

    GameMap() {
        setBackground(Color.BLACK);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLength) {
        removeAll();    // для случая, если передумали и решили перевыбрать параметры
        int width = this.getWidth() / fieldSizeX;    // размеры ячейки
        int height = this.getHeight() / fieldSizeY;
        for (int i = 0; i < fieldSizeX; i++) {    // располагаем в ячейках панели с зазором
            for (int y = 0; y < fieldSizeY; y++) {
                JPanel field = new JPanel();
                field.setBounds(i * width + gap, y * height + gap, width - gap, height - gap);
                field.setBackground(Color.WHITE);
                this.add(field);
                field.setVisible(true);
            }                               // хотел привязать панели к GridLayout, но не получилось
        }                                   // не уверен, что через циклы - хорошее решение
        repaint();
        System.out.printf("mode=%d, fieldSize=%d, winLen=%d\n", mode, fieldSizeX, winLength);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
