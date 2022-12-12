package cs1302.game;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

/**
 * Each individual block present on the larger defense body.
 */
public class MiniDefense extends Rectangle {

    /** Instance variables for class. */
    private Game game;
    private boolean alive;

    /**
     * Creates a {@code MiniDefense} Object.
     * @param game of type Game
     * @param xLoc of type double
     * @param yLoc of type double
     */
    public MiniDefense(Game game, double xLoc, double yLoc) {
        super(25.0, 25.0, Color.FIREBRICK);
        this.game = game;
        this.setX(xLoc);
        this.setY(yLoc);
        this.alive = true;

    } // MiniDefense

    /**
     * Returns status of {@code alive}.
     * @return alive of type boolean
     */
    public boolean isAlive() {
        return alive;
    } // isAlive

    /**
     * Sets the status of {@code alive}.
     * @param al of type boolean
     */
    public void setAlive(boolean al) {
        alive = al;
    } // setAlive

} // MiniDefense
