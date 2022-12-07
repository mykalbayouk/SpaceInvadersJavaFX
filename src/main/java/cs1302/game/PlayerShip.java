package cs1302.game;

import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Region;

/**
 * This is the class for the main player's ship. TBA..
 */
public class PlayerShip extends ImageView {

    private Game game;

    /**
     * Construct an {@code PlayerShip} object.
     * @param game parent game
     */
    public PlayerShip(Game game) {
        super("file:resources/sprites/player_Ship.png");
        this.setPreserveRatio(true);

        this.setFitWidth(70);
        this.setFitHeight(70);
        this.game = game;
    } // PlayerShip

    public void update() {
        Bounds playerBounds = getBoundsInParent();
        Bounds gameBounds = game.getGameBounds();

        game.isKeyPressed(KeyCode.LEFT, () -> {
            if (!(playerBounds.getMinX() < gameBounds.getMinX())) {
                this.setX(this.getX() - 5.0);
            } // if
        });

        game.isKeyPressed(KeyCode.RIGHT, () -> {
            if (!(playerBounds.getMaxX() > gameBounds.getMaxX())) {
                this.setX(this.getX() + 10.0);
            } // if
        });

        game.isKeyPressed(KeyCode.SPACE, () -> {
            RocketPlayer laser = new RocketPlayer(game, this.getX(), this.getY());
            laser.update();
        });

    } // update

    /**
     * Sets default location of player sprite.
     */
    public void setDefault() {
        this.setX(200.0);
        this.setY(400.0);
    } // setDefault
} // PlayerShip
