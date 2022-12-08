

package cs1302.game;

import java.lang.InterruptedException;
import java.lang.Thread;

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

    private Game game;
    private double dy;
    private boolean go;

    private Bounds alienBounds;
    private Image DEFAULT_IMAGE = new Image("file:resources/sprites/player_laser.png");
    /**
     * Constructs an {@code RocketPlayer} object.
     * @param game Game type of game
     * @param x double location
     * @param y double location
     */
    public RocketPlayer (Game game) {
        super();
        this.setImage(DEFAULT_IMAGE);
        this.setRotate(this.getRotate() + 90);
        this.setFitWidth(30.0);
        this.setFitHeight(10.0);
        this.game = game;
        this.setVisible(false);
        this.dy = 15.0;
        this.alienBounds = null;
        go = false;
    } // Rocket

    public void setLocation(double x, double y) {
        this.setX(x + 20.0);
        this.setY(y + 20.0);
        this.setVisible(true);
    } // setLocation


    public void update() {
        if (go) {
        Bounds rocketBounds = getBoundsInParent();
        Bounds alienBounds = this.getAlienBounds();
        Bounds gameBounds = game.getGameBounds();
        Runnable r = () -> emptyExplode();
        if (this.intersects(alienBounds)) {
            System.out.println("Hit!");
            this.hide();
            return;
        } else if ((rocketBounds.getMinY() - 50.0) < gameBounds.getMinY()) {
            this.runNow(r);
            return;
        }  // if
        setY(getY() - dy);
        } // if
    } // update

    public void setAlienBounds(Bounds alien) {
        alienBounds = alien;
    } // setAlienBounds

    public Bounds getAlienBounds() {
        return alienBounds;
    } // getAlienBounds

    public void setGo(boolean set) {
        go = set;
    } // setGo

    //rocket hits nothing
    public void hide() {
        this.setVisible(false);
        setX(0.0);
        setY(0.0);
        go = false;
    } // explode

    /**
     * Creates a new Thread.
     * @param target of type Runnable.
     */
    public void runNow(Runnable target) {
        Thread t = new Thread(target);
        t.setDaemon(true);
        t.start();
    } // runNow

    public void emptyExplode() {
        try {
            Image kaboom = new Image("file:resources/sprites/empty_Kaboom.png");
            Platform.runLater(() -> this.setVisible(false));
            this.setImage(kaboom);
            this.setFitWidth(60.0);
            this.setFitHeight(60.0);
            Platform.runLater(() -> this.setVisible(true));
            Thread.sleep(800);
            this.hide();
            this.setImage(DEFAULT_IMAGE);
            this.setFitWidth(30.0);
            this.setFitHeight(10.0);
        } catch (InterruptedException e) {
            return;
        } //catch

    } // emptyExplode

} // Rocket
