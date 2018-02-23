/*
Programmer: Jerry Wan
N12474893
jw3650
CS 3913
HW 2

This program creates a window with 8 buttons 
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class ButtonGrid extends JFrame implements ActionListener
{
    private JPanel panel;
    private JButton[][]buttons;
    private final int ROWS = 4;
    private final int COLUMNS = 2;
    private GridLayout buttonLayout;
    public ButtonGrid()
    {
        setTitle("Color Buttons");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800,800);
        setLocationRelativeTo(null);

        buttonLayout =  new GridLayout(ROWS,COLUMNS);

        panel = new JPanel();
        panel.setLayout(buttonLayout);

        buttons = new JButton[ROWS][COLUMNS];
        addButtons(panel);

        add(panel);
        setVisible(true);
    }

    Color randomColor() {
      Random rand = new Random();
      return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
   }

    public void addButtons(JPanel panel) {
        for (int k = 0; k < ROWS; k++) {
            for (int j = 0; j < COLUMNS; j++) {
                buttons[k][j] = new JButton(k + 1 + ", " + (j + 1));
                panel.add(buttons[k][j]);
                Color randColor = randomColor();
                buttons[k][j].setForeground(randColor);
                buttons[k][j].setBackground(randColor);
                buttons[k][j].setOpaque(true);
                buttons[k][j].addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int k = 0; k < ROWS; k++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (buttons[k][j] != e.getSource()) {
                    Color randColor = randomColor();
                    buttons[k][j].setBackground(randColor);
                    buttons[k][j].setForeground(randColor);
                }
            }
        }
    } 


    public static void main(String[] args) 
    {
        new ButtonGrid();

    }
}