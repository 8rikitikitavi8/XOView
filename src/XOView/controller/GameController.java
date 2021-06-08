package XOView.controller;

import XOView.model.Field;
import XOView.model.Game;
import XOView.model.Point;
import XOView.model.User;
import XOView.view.GameWindow;

public class GameController {
    private Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public void doShoot(Point point, Field.Type type) {
        game.getUser().setPoint(point);
    }
    public Field.Type[][] passCells() {
        return game.getField().getCells();
    }

    public boolean isRightShoot() {
        return game.getField().isRightShoot();
    }

    public int isEndGame() {
        return game.getWinner();
    }

    public void doRestart() {
        game.getField().init();
        game.setExit(false);
        game.setWinner(0);
    }

    public void doExit() {
        game.setExit(true);
    }
}
