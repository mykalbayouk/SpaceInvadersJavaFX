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

    private Game game;
    private double dy;
    private boolean go;
    private boolean fired;

    public RocketAlien (Game game) {
        super(2.5, 12.0, Color.WHITE);
        this.game = game;
        this.setX(-1000.0);
        this.fired = false;
    } // RocketAlien

    public void update() {
        Bounds rocketBounds = getBoundsInParent();
        Bounds gameBounds = game.getGameBounds();
        if ((rocketBounds.getMaxY() == gameBounds.getMaxY())) {
            this.setVisible(false);
            return;
        }
        setY(getY() + 6.0);

    } // update

    public void hide() {
        this.setX(-1000);
        this.setY(-1000);
        this.setVisible(false);
    } // hide

    public void setLocation(double x, double y) {
        this.setX(x + 20.0);
        this.setY(y + 20.0);
        this.setVisible(true);
    } // setLocation

    public void setFired(boolean f) {
        fired = f;
    } // setFired

    public boolean getFired() {
        return fired;
    } // getFired

} // RocketAlien
