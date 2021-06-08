package XOView;

import XOView.controller.GameController;
import XOView.model.Game;
import XOView.view.GameWindow;

import javax.swing.*;

/**
 * Игра крестики-нолики в графическом варианте с применением MVC.
 * Игра против "умного" компьютера,который не только находит свой следующий ход,но и блокирует выигрышный ход игрока.
 * Однако выиграть компьютер можно,логика была немного урезана.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        GameController gameController = new GameController(game);
        GameWindow gameWindow = new GameWindow(gameController);
        SwingUtilities.invokeLater(gameWindow::init);
        game.start();
    }
}
