package cs1302.game;

import java.util.Random;
import java.util.logging.Level;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Region;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * A JavaFX take on the cult classic "Space Invaders". Use Enter to start and left/right keys
 * to move your spaceship around the bottom of the board. You must destroy all the enemy ships
 * before they destroy your defense bases.
 */
public class SpaceInvaders extends Game {

    private PlayerShip player;
    private BoxAlien alienBox;
    private RocketPlayer shot;
    private RocketAlien aliShot;
    private Defense base1;
    private Defense base2;
    private Defense base3;
    private Defense base4;
    private LabelItems lives;

    private ImageView endWinImage;
    private ImageView endLoseImage;

    public SpaceInvaders(int width, int height) {
        super(width, height, 60);
        setLogLevel(Level.INFO);

        this.player = new PlayerShip(this);
        this.shot = new RocketPlayer(this);
        this.alienBox = new BoxAlien(this);
        this.aliShot = new RocketAlien(this);
        this.base1 = new Defense(this, 1);
        this.base2 = new Defense(this, 2);
        this.base3 = new Defense(this, 3);
        this.base4 = new Defense(this, 4);
        this.lives = new LabelItems();

        this.endWinImage = new ImageView("file:resources/sprites/endWin.PNG");
        endWinImage.setFitWidth(513);
        endWinImage.setFitHeight(268);
        this.endLoseImage = new ImageView("file:resources/sprites/endLose.PNG");
        endLoseImage.setFitWidth(510);
        endLoseImage.setFitHeight(276);

        this.getChildren().addAll(endWinImage, endLoseImage);
    } // SpaceInvaders

    /** {@inheritDoc} */
    @Override
    protected void init() {
        //setup subgraph
        getChildren().addAll(player, shot, aliShot,
        base1, base2, base3, base4, alienBox,
        lives);
        alienBox.setShot(shot);
        alienBox.setAlienShot(aliShot);
        player.setDefault();
        player.setAlienShot(aliShot);
        base1.setAlienShot(aliShot);
        base1.setPlayerShot(shot);
        base2.setAlienShot(aliShot);
        base2.setPlayerShot(shot);
        base3.setAlienShot(aliShot);
        base3.setPlayerShot(shot);
        base4.setAlienShot(aliShot);
        base4.setPlayerShot(shot);
        lives.setDefault();
        lives.setPlayer(player);
        endWinImage.setX(100);
        endWinImage.setY(100);
        endWinImage.setVisible(false);
        endLoseImage.setX(100);
        endLoseImage.setY(100);
        endLoseImage.setVisible(false);

    } // init

    /** {@inheritDoc} */
    @Override
    protected void update() {

        if (player.gameOver() || alienBox.reachEnd()) {
            this.showEndLose();
            if(this.isKeyPressed(KeyCode.ENTER)) {
                this.reset();
            } // if
        } else if (alienBox.getAlienCount() == 0) {
            this.showEndWin();
            if(this.isKeyPressed(KeyCode.ENTER)) {
                this.reset();
            } // if
        } else {


        player.update();
        alienBox.update();
        this.isKeyPressed(KeyCode.SPACE, () -> {
            shot.setLocation(player.getX(), player.getY());
            shot.setGo(true);
        });
        shot.update();
        base1.update();
        base2.update();
        base3.update();
        base4.update();
        lives.update();

        } // if
    } // update

    public void removeChildren() {
        getChildren().removeAll(player, alienBox, shot, aliShot, base1, base2, base3, base4, lives);
    } // removeChildren()

    /**
     * Method that removes old objects from scene and creates new objects for each asset.
     */
    public void reset() {
        this.player = new PlayerShip(this);
        this.shot = new RocketPlayer(this);
        this.alienBox = new BoxAlien(this);
        this.aliShot = new RocketAlien(this);
        this.base1 = new Defense(this, 1);
        this.base2 = new Defense(this, 2);
        this.base3 = new Defense(this, 3);
        this.base4 = new Defense(this, 4);
        this.lives = new LabelItems();
        this.init();
    } // reset

    public void showEndLose() {
        this.removeChildren();
        endLoseImage.setVisible(true);
    } // showEndLose

    public void showEndWin() {
        if (this.getChildren() != null) {
            this.removeChildren();
        } // if
        endWinImage.setVisible(true);
    } // showEndLose

}  // SpaceInvaders
