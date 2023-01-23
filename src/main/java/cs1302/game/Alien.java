package cs1302.game;

import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Region;
import javafx.scene.image.Image;


/**
 * This is the class for the different aliens enemies.
 */
public class Alien extends ImageView {

    /** Instance variables to be used in class. */
    private Game game;
    private boolean alive;
    private double dx;
    private double dy;
    private int count;

    private final Image alien1 = new Image("file:resources/sprites/alien_1.png");
    private final Image alien2 = new Image("file:resources/sprites/alien_2.png");
    private final Image alien3 = new Image("file:resources/sprites/alien_3.png");

    private final Image kaboom = new Image("file:resources/sprites/alien_Kaboom.png");

    /**
     * Construct an {@code Alien} object.
     * @param game parent game
     * @param type of alien (1 for basic, 2 for medium level, 3 for highest)
     * @param xLoc of type double
     * @param yLoc of type double
     */
    public Alien(Game game, int type, double xLoc, double yLoc) {
        super();
        if (type == 1) {
            this.setImage(alien1);
            this.setFitWidth(80);
            this.setFitHeight(80);
        } else if (type == 2) {
            this.setImage(alien2);
            this.setFitWidth(40);
            this.setFitHeight(40);
        } else if (type == 3) {
            this.setImage(alien3);
            this.setFitWidth(50);
            this.setFitHeight(50);
        } // if
        this.game = game;

        this.setX(xLoc);
        this.setY(yLoc);

        this.count = -1;
        this.alive = true;
        this.dx = 1;
        this.dy = 5;
    } // Alien


    /**
     * Returns whether the alien is alive.
     * @return true if alive, false if not
     */
    public boolean isAlive() {
        return alive;
    } // isAlive

    /**
     * Changes the sprite to kaboom and sets alive to false.
     */
    public void explode() {
        this.setImage(kaboom);
        alive = false;
    } // explode
} // Alien
