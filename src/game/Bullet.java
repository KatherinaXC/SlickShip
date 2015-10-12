/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Winterstorm
 */
public class Bullet {

    float x;
    float y;
    private boolean isFriendly;
    Animation friendlyFire;
    Animation enemyFire;

    public static int friendlyFireHeight;
    public static int enemyFireHeight;
    public static final int duration = 500;

    public Bullet(boolean isFriendly, int x, int y) throws SlickException {
        Image[] im_friendlyFire = {new Image("src/data/pc_bullet1.png"),
            new Image("src/data/pc_bullet2.png"),
            new Image("src/data/pc_bullet3.png")};
        Image[] im_enemyFire = {new Image("src/data/ec_bullet1.png"),
            new Image("src/data/ec_bullet2.png"),
            new Image("src/data/ec_bullet3.png"),
            new Image("src/data/ec_bullet4.png"),
            new Image("src/data/ec_bullet5.png")};
        friendlyFire = new Animation(im_friendlyFire, Bullet.duration, true);
        enemyFire = new Animation(im_enemyFire, Bullet.duration, true);
        this.isFriendly = isFriendly;
        this.x = x;
        this.y = y;
        friendlyFireHeight = friendlyFire.getHeight();
        enemyFireHeight = enemyFire.getHeight();
    }

    public Animation animation() {
        if (isFriendly) {
            return friendlyFire;
        }
        return enemyFire;
    }
}
