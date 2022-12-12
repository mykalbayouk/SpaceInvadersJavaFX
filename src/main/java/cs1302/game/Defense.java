package cs1302.game;

import javafx.geometry.Bounds;
import javafx.scene.layout.Region;
import javafx.scene.Group;


/**
 * This is the class for the different aliens enemies.
 */
public class Defense extends Group {

    private Game game;
    private MiniDefense[][] boxes = new MiniDefense[3][3];
    private RocketPlayer playerShot;
    private RocketAlien alienShot;



    public Defense (Game game, int type) {
        this.game = game;
        this.playerShot = null;
        this.alienShot = null;

        int modify = 100;
        if (type == 2) {
            modify = 250;
        } else if (type == 3) {
            modify = 400;
        } else if (type == 4) {
            modify = 550;
        } // if

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

    public void setPlayerShot(RocketPlayer sho) {
        playerShot = sho;
    } // setPlayerShot


    public void setAlienShot(RocketAlien sho) {
        alienShot = sho;
    } // setPlayerShot
} // Defense
