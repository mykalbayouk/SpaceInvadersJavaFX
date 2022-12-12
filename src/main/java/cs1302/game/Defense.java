package cs1302.game;

import javafx.geometry.Bounds;
import javafx.scene.layout.Region;
import javafx.scene.Group;


/**
 * This is the class for the different aliens enemies.
 */
public class Defense extends Group {

    /** Instance variables to be used by class. */
    private Game game;
    private MiniDefense[][] boxes = new MiniDefense[3][3];
    private RocketPlayer playerShot;
    private RocketAlien alienShot;


    /**
     * Creates a {@code Defense} object as well as by using the
     * type parameter can determine how far along the board, each base
     * needs to be from each other. (type = 1 -> first base to the left)
     * @param game of type Game
     * @param type of type int
     */
    public Defense (Game game, int type) {
        this.game = game;
        this.playerShot = null;
        this.alienShot = null;

        // modifer to adjust distance each box is from each other
        int modify = 100;
        if (type == 2) {
            modify = 250;
        } else if (type == 3) {
            modify = 400;
        } else if (type == 4) {
            modify = 550;
        } // if

        // loop to add each minidefense into the full defense bases you see on the screen
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 2 && j == 1) {
                    continue;
                } else {
                    boxes[i][j] = new MiniDefense(game, 25.0 * j + modify, 550.0 + 25.0 * i);
                    this.getChildren().add(boxes[i][j]);
                } // if
            } // for
        } // for
    } // Defense

    /**
     * Checks to see if player had fired and if so will check through all the {@code boxes},
     * to determine if any of them have been intersected. If will hide that box and make it
     * no longer visible. Does the same thing for the alien laser.
     */
    public void update() {

        if (playerShot.getFired()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 2 && j == 1) {
                        continue;
                    } else {
                        if (boxes[i][j].intersects(playerShot.getBoundsInParent())
                            && boxes[i][j].isAlive()) {
                            boxes[i][j].setVisible(false);
                            boxes[i][j].setAlive(false);
                            playerShot.hide();
                            return;
                        } // if
                    } // if
                } // for
            } // for
        } // if

        if (alienShot.getFired()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 2 && j == 1) {
                        continue;
                    } else {
                        if (boxes[i][j].intersects(alienShot.getBoundsInParent())
                            && boxes[i][j].isAlive()) {
                            boxes[i][j].setVisible(false);
                            boxes[i][j].setAlive(false);
                            alienShot.hide();
                            return;
                        } // if
                    } // if
                } // for
            } // for
        } // if

    } // update

    /**
     * Sets the player shot into a variable that can be used in this class.
     * @param sho of type RocketPlayer
     */
    public void setPlayerShot(RocketPlayer sho) {
        playerShot = sho;
    } // setPlayerShot

    /**
     * Sets the alien shot into a variable that can be used in this class.
     * @param sho of type RocketAlien
     */
    public void setAlienShot(RocketAlien sho) {
        alienShot = sho;
    } // setPlayerShot

} // Defense
