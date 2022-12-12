package cs1302.game;

import javafx.util.Duration;
import javafx.geometry.Bounds;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.application.Platform;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Region;
import javafx.scene.image.Image;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * This is the class for the Player rockets shot by either the player or enemy.
 */
public class RocketPlayer extends ImageView {

    private Game game;
    private double dy;
    private boolean go;
    private int count;
    private boolean fired;

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
        this.fired = false;
        go = false;
        count = 0;
    } // Rocket

    public void setLocation(double x, double y) {
        this.setX(x + 20.0);
        this.setY(y + 20.0);
        this.setVisible(true);
    } // setLocation


    public void update() {
        if (go) {
        Bounds rocketBounds = getBoundsInParent();
        Bounds gameBounds = game.getGameBounds();

        if ((rocketBounds.getMinY() - 50.0) < gameBounds.getMinY() && count == 0) {
            this.emptyExplode();
            count = 1;
            return;
        }  else if (count < 5 && count > 0) {
            count++;
            return;
        } else if (count == 5) {
            this.hide();
            this.setImage(DEFAULT_IMAGE);
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

    public boolean getFired() {
        return fired;
    } // getFried

    public void setFired(boolean set) {
        fired = set;
    } // setFired

    public void setGo(boolean set) {
        go = set;
    } // setGo

    //rocket hits nothing
    public void hide() {
        this.setVisible(false);
        setX(-1000.0);
        setY(-1000.0);
        go = false;
    } // explode

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
