/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Winterstorm
 */
public class EnemyShip extends Ship {

    ArrayList<Bullet> bullets;

    Animation enemyStatic;
    Animation enemyGuns;
    Animation enemyFire;

    public EnemyShip(ArrayList<Bullet> bullets, GameContainer gc) throws SlickException {
        Image[] im_enemyStatic = {new Image("src/data/ec_static.png")};
        Image[] im_enemyGuns = {new Image("src/data/ec_guns1.png"),
            new Image("src/data/ec_guns2.png"),
            new Image("src/data/ec_guns3.png"),
            new Image("src/data/ec_guns4.png"),
            new Image("src/data/ec_guns5.png")};
        enemyStatic = new Animation(im_enemyStatic, Ship.duration, true);
        enemyGuns = new Animation(im_enemyGuns, Ship.duration, true);
        this.bullets = bullets;
    }

    public EnemyShip(int x, int y, ArrayList<Bullet> bullets, GameContainer gc) throws SlickException {
        this(bullets, gc);
        this.x = x;
        this.y = y;
    }

    public void shoot() throws SlickException {
        this.bullets.add(new Bullet(false,
                (int) this.x,
                (int) this.y + this.animation().getHeight()));
    }

    public void die() {
    }

    @Override
    public Animation animation() {
        return enemyStatic;
    }

}
