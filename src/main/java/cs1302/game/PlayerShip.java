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
    private RocketAlien alienShot;
    private boolean gameOver;
    private int life;

    /**
     * Construct an {@code PlayerShip} object.
     * @param game parent game
     */
    public PlayerShip(Game game) {
        super("file:resources/sprites/player_Ship.png");
        this.setPreserveRatio(true);

        this.gameOver = false;
        this.alienShot = null;
        this.life = 3;
        this.setFitWidth(70);
        this.setFitHeight(70);
        this.game = game;

    } // PlayerShip

    /**
     * Method for moving around the player using left and right arrow keys.
     * Also detects if alien laser has hit the main player and if so, decreases the
     * life count by 1 until life = 0 and game is over.
     */
    public void update() {
        Bounds playerBounds = getBoundsInParent();
        Bounds gameBounds = game.getGameBounds();
        Bounds alienLazer = alienShot.getBoundsInParent();

        if(this.intersects(alienLazer) && life > 0) {
            this.setLife(this.getLife() - 1);
            this.setDefault();
            alienShot.setLocation(-1000, -1000);
            return;
        } else if (life == 0) {
            gameOver = true;
            return;
        } //

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

    } // update

    /**
     * Sets the player life to a new updated value.
     * @param life of type int.
     */
    public void setLife(int li) {
        life = li;
    } // setLife

    /**
     * Returns the amount of lives the player has.
     * @return life of type int
     */
    public int getLife(){
        return life;
    } // getLife

    /**
     * Returns the status of {@code gameOver}.
     * @return gameOver of type boolean
     */
    public boolean gameOver() {
        return gameOver;
    } // boolean

    /**
     * Sets default location of player sprite.
     */
    public void setDefault() {
        this.setX(350.0);
        this.setY(650.0);
    } // setDefault

    /**
     * Sets the variable alienShot equal to the alienShot object in the
     * {@code SpaceInvaders} class.
     * @param sho of type RocketAlien
     */
    public void setAlienShot(RocketAlien sho) {
        alienShot = sho;
    } // getAlienShot
} // PlayerShip
