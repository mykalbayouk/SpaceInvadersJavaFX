package cs1302.game;

import javafx.util.Duration;
import javafx.geometry.Bounds;

import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;

/**
 * This is the class for the Player rockets shot by either the player or enemy.
 */
public class RocketAlien extends Rectangle {

    /** Instance variables to be used by class. */
    private Game game;
    private double dy;
    private boolean go;
    private boolean fired;

    /**
     * Creates a {@code RocketAlien} object.
     * @param game of type Game
     */
    public RocketAlien (Game game) {
        super(2.5, 12.0, Color.WHITE);
        this.game = game;
        this.setX(-1000.0);
        this.fired = false;
    } // RocketAlien

    /**
     * When this is called moves Alien Rocket downwards.
     */
    public void update() {
        Bounds rocketBounds = getBoundsInParent();
        Bounds gameBounds = game.getGameBounds();
        if ((rocketBounds.getMaxY() == gameBounds.getMaxY())) {
            this.setVisible(false);
            return;
        }
        setY(getY() + 6.0);

    } // update

    /**
     * Hides alien Rocket to not be seen on game.
     */
    public void hide() {
        this.setX(-1000);
        this.setY(-1000);
        this.setVisible(false);
    } // hide

    /**
     * Sets the location of the alien rocket.
     * @param x of type double
     * @param y of type double
     */
    public void setLocation(double x, double y) {
        this.setX(x + 20.0);
        this.setY(y + 20.0);
        this.setVisible(true);
    } // setLocation

    /**
     * Sets the status of {@code fired}.
     * @param f of type boolean
     */
    public void setFired(boolean f) {
        fired = f;
    } // setFired

    /**
     * Returns the status of {@code fired}.
     * @return fired of type boolean
     */
    public boolean getFired() {
        return fired;
    } // getFired

} // RocketAlien
