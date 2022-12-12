package cs1302.game;

import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

/**
 * Shows the amount of lives the player has left by using each ship as one life.
 */
public class LabelItems extends HBox {

    /** Lives large picture and 3 mini pictures being used as instance variables. */
    private ImageView livesPic;
    private ImageView life1;
    private ImageView life2;
    private ImageView life3;

    private PlayerShip player;

     /**
      * Creates a {@code LabelItems} object.
      */
    public LabelItems() {
        super(20.0);
        this.player = null;

        livesPic = new ImageView("file:resources/sprites/Lives.PNG");
        life1 = new ImageView("file:resources/sprites/player_Ship.png");
        life2 = new ImageView("file:resources/sprites/player_Ship.png");
        life3 = new ImageView("file:resources/sprites/player_Ship.png");

        livesPic.setFitWidth(110.0);
        livesPic.setFitHeight(60.0);
        life1.setFitWidth(50.0);
        life1.setFitHeight(50.0);
        life2.setFitWidth(50.0);
        life2.setFitHeight(50.0);
        life3.setFitWidth(50.0);
        life3.setFitHeight(50.0);

        this.getChildren().addAll(livesPic, life1, life2, life3);
    } // LabelItems

    /**
     * Checks to see current amount of lives player has and updates accordingly.
     */
    public void update() {
        if (player.getLife() == 2) {
            life3.setVisible(false);
        } else if (player.getLife() == 1) {
            life2.setVisible(false);
        } else if (player.getLife() < 1) {
            life1.setVisible(false);
        } // if
    } // update

    /**
     * Sets the PlayerShip object into a variable that can be used in the {@code LabelItems},
     * class.
     * @param p of type PlayerShip
     */
    public void setPlayer(PlayerShip p) {
        player = p;
    } // setPlayer


    /**
     * Sets the Lives tab to a default location.
     */
    public void setDefault() {
        this.setTranslateX(400);
        this.setTranslateY(10.0);
    } // setDefault

} // LabelItems
