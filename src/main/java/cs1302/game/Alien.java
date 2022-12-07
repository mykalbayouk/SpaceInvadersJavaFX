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

    private Game game;
    private int value;
    private boolean alive;
    private double dx;
    private double dy;

    private final Image alien1 = new Image("file:resources/sprites/alien_1.png");
    private final Image alien2 = new Image("file:resources/sprites/alien_2.png");
    private final Image alien3 = new Image("file:resources/sprites/alien_3.png");

    /**
     * Construct an {@code Alien} object.
     * @param game parent game
     * @param type of alien (1 for basic, 2 for medium level, 3 for highest)
     */
    public Alien(Game game, int type) {
        super();
        if (type == 1) {
            this.setImage(alien1);
        } else if (type == 2) {
            this.setImage(alien2);
        } else if (type == 3) {
            this.setImage(alien3);
        } // if
        this.setValue(type);
        this.setFitWidth(60);
        this.setFitHeight(60);
        this.game = game;

        this.value = 0;
        this.alive = true;
        this.dx = 1;
        this.dy = 5;
    } // Alien

    private void setValue(int type) {
        if (type == 1) {
            value = 100;
        } else if (type == 2) {
            value = 250;
        } else if (type == 3) {
            value = 500;
        } else {
            throw new IllegalArgumentException("Not valid type");
        } // if
    } //set Value

    public void update() {
        Bounds alienBounds = getBoundsInParent();
        Bounds gameBounds = game.getGameBounds();
        if (alienBounds.getMaxX() > (gameBounds.getMaxX() - 10)) {
            dx *= -1.0;
            setY(getY() + dy);
        } else if ((alienBounds.getMinX() - 10) < gameBounds.getMinX()) {
            dx *= -1.0;
            setY(getY() + dy);
        } // if
        setX(getX() + dx);

    } // update
} // Alien
