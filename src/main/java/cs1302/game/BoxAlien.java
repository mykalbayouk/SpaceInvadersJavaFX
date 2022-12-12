package cs1302.game;
import java.util.Random;

import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.image.Image;
import javafx.scene.Group;

/**
 * This class holds all the alien objects into one large imageView.
 */
public class BoxAlien extends Group {

    private Game game;
    protected Alien[][] alien = new Alien[5][11];
    private double dy;
    private double dx;
    private RocketPlayer shot;
    private int count;
    private RocketAlien alienShot;
    private int delay;
    private boolean canShoot;
    private Alien al;

    private int alienCount;
    private boolean end;

    public BoxAlien(Game game) {
        this.game = game;
        this.dy = 1;
        this.dx = .5;
        this.shot = null;
        this.count = -1;
        this.delay = 0;
        this.canShoot = false;
        this.alienShot = null;
        this.al = null;
        this.alienCount = 55;
        this.end = false;

        double adj = 0;
        int c = 0;
        double x = 10.0;
        double y = 10.0;
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; j++) {
                if (i == 0) {
                    c = 3;
                    adj = 12.0;
                } else if (i == 1 || i == 2) {
                    c = 2;
                    adj = 19.0;
                } else if (i > 2) {
                    c = 1;
                    adj = 0.0;
                } // if
                alien[i][j] = new Alien(game, c, 30.0 + adj + (j * 60.0), 50.0 + adj + (i * 60.0));
                this.getChildren().add(alien[i][j]);
            } // for
        } // for

    } // Box Alien

    public void update() {
        Bounds alienBoxBounds = getBoundsInParent();
        Bounds gameBounds = game.getGameBounds();
        int xCord = this.getRXCord();
        int yCord = this.getRYCord();

        if (this.getTranslateY() > 250.0) {
            end = true;
            return;
        } // if

        if (delay % 300 == 0 && delay > 0) {
            if (alien[xCord][yCord].isAlive()) {
                alienShot.setLocation(alien[xCord][yCord].getX(), alien[xCord][yCord].getY());
                canShoot = true;
            } else {
                return;
            } // if
            delay++;
        } else {
            delay++;
        } // if

        if (shot.getFired() && count == -1) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 11; j++) {
                    if (alien[i][j].intersects(shot.getBoundsInParent()) && alien[i][j].isAlive()) {
                        alien[i][j].explode();
                        this.setAlien(alien[i][j]);
                        shot.hide();
                        count = 0;
                        alienCount = alienCount - 1;
                        return;
                    } // if
                } // for
            } // for
        } // if

        if (alienBoxBounds.getMaxX() > (gameBounds.getMaxX()) && count == -1) {
            dx *= -1.0;
            setTranslateY(getTranslateY() + dy);
        } else if ((alienBoxBounds.getMinX()) < gameBounds.getMinX() && count == -1) {
            dx *= -1.0;
            setTranslateY(getTranslateY() + dy);
        } else if (count > -1 && count < 30) {
            count++;
            return;
        } else if (count == 30) {
            al.setVisible(false);
            count = -1;
            return;
        } // if
        if (canShoot) {
            alienShot.update();
            alienShot.setFired(true);
        } // if
        setTranslateX(getTranslateX() + dx);
    } // update

    public boolean reachEnd() {
        return end;
    } // reachEnd

    public int getAlienCount() {
        return alienCount;
    } // getAlienCount

    public void setAlien(Alien a) {
        al = a;
    } // setAlien

    public void setAlienShot(RocketAlien aliSh) {
        alienShot = aliSh;
    } // setAlienShot

    public void setShot(RocketPlayer sho) {
        shot = sho;
    } // setShot

    public int getRXCord() {
        Random randx = new Random();

        return randx.nextInt((4 - 1) + 1) + 1;
    } // genCord

    public int getRYCord() {
        Random randy = new Random();

        return randy.nextInt((10 - 1) + 1) + 1;
    } // genCord

} // BoxAlien
