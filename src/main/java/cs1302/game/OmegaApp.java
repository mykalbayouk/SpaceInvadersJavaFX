package cs1302.game;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * REPLACE WITH NON-SHOUTING DESCRIPTION OF YOUR APP.
 */
public class OmegaApp extends Application {

    /**
     * Constructs an {@code OmegaApp} object. This default (i.e., no argument)
     * constructor is executed in Step 2 of the JavaFX Application Life-Cycle.
     */
    public OmegaApp() {}

    /** {@inheritDoc} */
    @Override
    public void start(Stage stage) {

        SpaceInvaders game = new SpaceInvaders(750, 750);
        // setup scene
        VBox root = new VBox(game);
        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);

        // setup stage
        stage.setTitle("OmegaApp!");
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> Platform.exit());
        stage.sizeToScene();
        stage.show();

        // play the game
        game.play();
    } // start

} // OmegaApp
