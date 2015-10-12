/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Winterstorm
 */
public class PlayerShip extends Ship {

    boolean shooting;

    Animation staticOpen;
    Animation staticClosed;
    Animation gunsOpen;
    Animation gunsClose;
    Animation friendlyFire;

    ArrayList<Bullet> bullets;
    private int timer = Ship.cooldown;

    public PlayerShip(ArrayList<Bullet> bullets) throws SlickException {
        Image[] im_playerStatic = {new Image("src/data/pc_static.png")};
        Image[] im_playerStaticOpen = {new Image("src/data/pc_guns5.png")};
        Image[] im_gunsOpen = {new Image("src/data/pc_guns1.png"),
            new Image("src/data/pc_guns2.png"),
            new Image("src/data/pc_guns3.png"),
            new Image("src/data/pc_guns4.png"),
            new Image("src/data/pc_guns5.png")};
        Image[] im_gunsClose = {new Image("src/data/pc_guns5.png"),
            new Image("src/data/pc_guns4.png"),
            new Image("src/data/pc_guns3.png"),
            new Image("src/data/pc_guns2.png"),
            new Image("src/data/pc_guns1.png")};
        staticOpen = new Animation(im_playerStaticOpen, Ship.duration, true);
        staticClosed = new Animation(im_playerStatic, Ship.duration, true);
        gunsOpen = new Animation(im_gunsOpen, Ship.duration, true);
        gunsClose = new Animation(im_gunsClose, Ship.duration, true);
        this.bullets = bullets;
    }

    public PlayerShip(int x, int y, ArrayList<Bullet> bullets) throws SlickException {
        this(bullets);
        this.x = x;
        this.y = y;
    }

    @Override
    public void shoot() throws SlickException {
        this.bullets.add(new Bullet(true,
                (int) this.x,
                (int) this.y - Bullet.friendlyFireHeight));
    }

    public void shoot(int interval) throws SlickException {
        this.timer += interval;
        if (timer >= Ship.cooldown) {
            shoot();
            timer = 0;
        }
    }

    public void die() {
    }

    @Override
    public Animation animation() {
        if (shooting) {
            return staticOpen;
        }
        if (!shooting) {
            return staticClosed;
        }
        return staticOpen;
    }

}
