package cs1302.game;

import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Region;
import javafx.scene.image.Image;
/**
 * This is the class for the Player rockets shot by either the player or enemy.
 */
public class RocketPlayer extends ImageView {

    private Game game;
    private double dy;


    /**
     * Constructs an {@code RocketPlayer} object.
     * @param game Game type of game
     * @param x double location
     * @param y double location
     */
    public RocketPlayer (Game game, double x, double y) {
        super("file:resources/sprites/player_laser.png");
        this.setFitWidth(70.0);
        this.setFitHeight(40.0);
        this.game = game;

        this.setX(x);
        this.setY(y);

        this.dy = 5.0;
    } // Rocket

    public void update() {
        Bounds rocketBounds = getBoundsInParent();
        Bounds gameBounds = game.getGameBounds();
        if ((rocketBounds.getMinY() - 15.0) < gameBounds.getMinY()) {
            this.explode();
        } // if
        System.out.println(getY());
        setY(getY() - dy);
    } // update

    public void explode() {
        System.out.println("explode");
        this.setImage(null);
    } // explode

    public boolean hasHit() {
        return true;
    } // hasHit
} // Rocket
