package cs1302.game;

import javafx.scene.layout.HBox;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;


public class LabelItems extends HBox {

//    private PlayerShip player;

    private ImageView livesPic;
    private ImageView life1;
    private ImageView life2;
    private ImageView life3;

    private int lifeCount;
    private PlayerShip player;

      public LabelItems() {
        super(20.0);
        this.lifeCount = 3;
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


    public void update() {
        if (player.getLife() == 2) {
            life3.setVisible(false);
        } else if (player.getLife() == 1) {
            life2.setVisible(false);
        } else if (player.getLife() < 1) {
            life1.setVisible(false);
        } // if
    } // update

    public void setPlayer(PlayerShip p) {
        player = p;
    } // setPlayer


    public void setDefault() {
        this.setTranslateX(400);
        this.setTranslateY(10.0);
    } // setDefault

} // LabelItems
