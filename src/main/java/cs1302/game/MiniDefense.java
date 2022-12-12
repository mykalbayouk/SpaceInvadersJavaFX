package cs1302.game;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class MiniDefense extends Rectangle {

    private Game game;
    private boolean alive;

    public MiniDefense(Game game, double xLoc, double yLoc) {
        super(25.0, 25.0, Color.FIREBRICK);
        this.game = game;
        this.setX(xLoc);
        this.setY(yLoc);
        this.alive = true;

    } // MiniDefense

    public boolean isAlive() {
        return alive;
    } // isAlive

    public void setAlive(boolean al) {
        alive = al;
    } // setAlive

} // MiniDefense
