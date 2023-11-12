package be.swsb.coderetreat;

public class Game {

    private final Player player1, player2;

    private boolean turn = true;

    public Game() {
        this.player1 = new Player();
        this.player2 = new Player();
    }

    public static Game startNew() {
        return new Game();
    }

    public Player getP1() {
        return this.player1;
    }

    public Player getP2() {
        return this.player2;
    }

    public boolean isP1turn() {
        return this.turn;
    }

    public boolean isP2turn() {
        return !this.turn;
    }

    public Game shootAt(int x, int y) throws Exception {
        if (isP1turn()) {
            player2.receiveShot(x, y);
        } else {
            player1.receiveShot(x, y);
        }
        this.turn = !this.turn;
        return this;
    }

    public Player winner() {
        if (player1.allBoatsDestroyed()) {
            return player2;
        } else if (player2.allBoatsDestroyed()) {
            return player1;
        } else {
            return null;
        }
    }

}
