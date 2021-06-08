package XOView.model;

import XOView.view.GameWindow;

public class Game {
    private Field field;
    private User user;
    private Computer computer;
    private volatile int winner = 0;
    private volatile boolean exit = false;
    public static final Object monitor2 = new Object();

    public void start() {
        field = new Field();
        user = new User();
        computer = new Computer();

        field.init();
        field.showField();

        while (true) {
            do {
                field.setRightShoot(false);
                waitResult(monitor2);
                field.shoot(user.getShootPoint(), Field.Type.X);
                notify(GameWindow.monitor1);
            } while (!field.isRightShoot());
            field.showField();
            if (endGame()) {
                synchronized (GameWindow.monitor1) {
                    GameWindow.monitor1.notify();
                }
                if (exit) {
                    break;
                }
            }
            computer.computerShoot(field);
            field.showField();
            if (endGame()) {
                synchronized (GameWindow.monitor1) {
                    GameWindow.monitor1.notify();
                }
                if (exit) {
                    break;
                }
            }
            synchronized (GameWindow.monitor1) {
                GameWindow.monitor1.notify();
            }
        }
    }

    private void waitResult(Object o) {
        try {
            synchronized (o) {
                o.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void notify(Object o) {
        synchronized (o) {
            o.notify();
        }
    }

    private boolean endGame() {
        if (field.whoIsWinner() == Field.Type.X) {
            System.out.println("Победил " + Field.Type.X);
            winner = 1;
            return true;
        } else if (field.whoIsWinner() == Field.Type.O) {
            System.out.println("Победил " + Field.Type.O);
            winner = 2;
            return true;
        } else if (field.draw()) {
            System.out.println("Ничья");
            winner = 3;
            synchronized (GameWindow.monitor1) {
                GameWindow.monitor1.notify();
            }
            return true;
        }
        return false;
    }

    public int getWinner() {
        return winner;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public Field getField() {
        return field;
    }

    public User getUser() {
        return user;
    }

    public Computer getComputer() {
        return computer;
    }

}
