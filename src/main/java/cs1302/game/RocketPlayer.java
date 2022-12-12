package cs1302.game;

import javafx.geometry.Bounds;

import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Region;
import javafx.scene.image.Image;


/**
 * This is the class for the Player rockets shot by either the player or enemy.
 */
public class RocketPlayer extends ImageView {

    /** instance variables to be used by RocketPlayer class. */
    private Game game;
    private double dy;
    private boolean go;
    private int count;
    private boolean fired;

    private Image defaultImg = new Image("file:resources/sprites/player_laser.png");


    /**
     * Constructs an {@code RocketPlayer} object.
     * @param game Game type of game
     *
     */
    public RocketPlayer (Game game) {
        super();
        this.setImage(defaultImg);
        this.setRotate(this.getRotate() + 90);
        this.setFitWidth(30.0);
        this.setFitHeight(10.0);
        this.game = game;
        this.setVisible(false);
        this.dy = 15.0;
        this.fired = false;
        go = false;
        count = 0;
    } // Rocket

    /**
     * Sets the location of the rocket to the given double x and y.
     * Also makes the rocket visibe in the game.
     * @param x location of type double
     * @param y location of type double
     */
    public void setLocation(double x, double y) {
        this.setX(x + 20.0);
        this.setY(y + 20.0);
        this.setVisible(true);
    } // setLocation


    /**
     * Updates the movement of the rocket depending on if the player,
     * pressed spacebar. When spacebar is pushed, {@code go} variable is set to true
     * and the method can move the rocket and if the rocket does not hit anyting it will
     * auto explode.
     */
    public void update() {
        if (go) {
            Bounds rocketBounds = getBoundsInParent();
            Bounds gameBounds = game.getGameBounds();

            if ((rocketBounds.getMinY() - 50.0) < gameBounds.getMinY() && count == 0) {
                this.emptyExplode();
                count = 1;
                return;
            }  else if (count < 5 && count > 0) {
                count++; // creates a count to show the rocket explosion on screen
                return;
            } else if (count == 5) {
                this.hide();
                this.setImage(defaultImg);
                this.setFitWidth(30.0);
                this.setFitHeight(10.0);
                count = 0;
                this.setFired(false);
                return;
            } // if
            setY(getY() - dy);
            this.setFired(true);
        } // if
    } // update

    /**
     * Returns the status of {@code fired}.
     * @return fired of type boolean
     */
    public boolean getFired() {
        return fired;
    } // getFried

    /**
     * Sets the status of {@code fired} to either {@code true} or
     * {@code false}.
     * @param set of type boolean
     */
    public void setFired(boolean set) {
        fired = set;
    } // setFired

    /**
     * Sets the status of {@code go} to either {@code true} or
     * {@code false}.
     * @param set of type boolean
     */
    public void setGo(boolean set) {
        go = set;
    } // setGo

    /**
     * When called hides the rocket by moving super far and setting to not visible.
     */
    public void hide() {
        this.setVisible(false);
        setX(-1000.0);
        setY(-1000.0);
        go = false;
    } // explode

    /**
     * Changes the image of the rocket to explosion sprite. Also resizes and moves slightly.
     */
    public void emptyExplode() {
        Image kaboom = new Image("file:resources/sprites/empty_Kaboom.png");
        this.setVisible(false);
        this.setImage(kaboom);
        this.setFitWidth(60.0);
        this.setFitHeight(60.0);
        this.setX(this.getX() - 5.0);
        this.setY(this.getY() + 5.0);
        this.setVisible(true);
    } // emptyExplode

} // Rocket
