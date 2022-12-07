package cs1302.game;
import java.util.Random;
import java.util.logging.Level;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

/**
 * A JavaFX take on the cult classic "Space Invaders". Use Enter to start and left/right keys
 * to move your spaceship around the bottom of the board. You must destroy all the enemy ships
 * before they destroy your defense bases.
 */
public class SpaceInvaders extends Game {

    private PlayerShip player;
    private Alien alien;

    public SpaceInvaders(int width, int height) {
        super(width, height, 60);
        setLogLevel(Level.INFO);
        this.alien = new Alien(this, 1);
        this.player = new PlayerShip(this);
    } // SpaceInvaders

    /** {@inheritDoc} */
    @Override
    protected void init() {
        //setup subgraph
        getChildren().addAll(player, alien);

        //setup player
        player.setDefault();

        alien.setX(100.0);
        alien.setY(100.0);

    } // init

    /** {@inheritDoc} */
    @Override
    protected void update() {
        //continuasly updates player position based on command
        //probably want main character here unsure yet what to do with enemies

        // maybe have methods in each enemy class that get checked here so like isAlived()
        // and amountOfDamage()?
        player.update();

        alien.update();
        //isKeyPressed -> shoot rocket TBA

    } // update
} // SpaceInvaders
