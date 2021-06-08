package XOView.view;

import XOView.controller.GameController;
import XOView.model.Field;
import XOView.model.Game;
import XOView.model.Point;

import javax.swing.*;

import java.awt.*;

public class GameWindow extends JFrame {
    private GameController gameController;
    public static final int SIZE = 3;
    JButton[][] buttons;
    public static final Object monitor1 = new Object();

    public GameWindow(GameController gameController) {
        this.gameController = gameController;
    }

    public void init() {
        setSize(400, 400);
        setTitle("XO Game");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(SIZE, SIZE));

        buttons = new JButton[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                JButton jButton = new JButton(".");
                final int finalJ = j;
                final int finalI = i;
                jButton.addActionListener(e -> {
                    String buttonText = e.getActionCommand();//возвращает название нопки(его установили в 33строке)
                        System.out.printf("Button: %s, x: %d, y: %d%n", buttonText, finalJ, finalI);
                        gameController.doShoot(new Point(finalI, finalJ), buttonText.equals("X") ? Field.Type.X : Field.Type.O);
                        synchronized (Game.monitor2) {
                            Game.monitor2.notify();
                        }
                        wait(monitor1);
                        showField(gameController.passCells());
                    if (!gameController.isRightShoot()) {
                        return;
                    }

                    if (gameController.isEndGame() != 0) {
                        restartOrClose(gameController.isEndGame());
                    }

                        try {
                            synchronized (monitor1) {
                                monitor1.wait();
                            }
                        } catch (InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                        showField(gameController.passCells());
                        if (gameController.isEndGame() != 0) {
                            restartOrClose(gameController.isEndGame());
                        }
                        showField(gameController.passCells());
                    });
                buttons[i][j] = jButton;
                jPanel.add(jButton);
            }
        }

        add(jPanel);
        setVisible(true);
    }

    public void showField(Field.Type[][] cells) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                switch (cells[i][j]) {
                    case X -> buttons[i][j].setText("X");
                    case O -> buttons[i][j].setText("O");
                    case NONE -> buttons[i][j].setText(".");
                }
            }
        }
    }

    public void restartOrClose(int winner) {
        String s = switch (winner) {
            case 1 -> "X wins! ";
            case 2 -> "O wins! ";
            case 3 -> "Draw! ";
            default -> "";
        };
        JFrame thisFrame = this;
        Object[] options = {"Yes, please", "No, thanks"};
        int n = JOptionPane.showOptionDialog(thisFrame, s + "Would you like to restart", "Restart",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (n == 1) {
            gameController.doExit();
            System.exit(0);
        } else {
            gameController.doRestart();
        }
    }

    private void wait(Object o) {
        try {
            synchronized (o) {
                o.wait();
            }
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
