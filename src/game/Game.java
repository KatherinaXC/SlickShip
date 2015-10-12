/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import java.util.Random;
import org.jfugue.player.*;
import org.newdawn.slick.*;

/**
 *
 * @author Winterstorm
 */
public class Game extends BasicGame {

    Random rand = new Random();
    Player mplayer = new Player();
    PlayerShip player;
    ArrayList<Bullet> playerbullets = new ArrayList<Bullet>();
    EnemyShip enemy;
    ArrayList<Bullet> enemybullets = new ArrayList<Bullet>();

    /**
     * @param args the command line arguments
     * @throws org.newdawn.slick.SlickException
     */
    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game("Haha look it's a title bar!"));
        app.setShowFPS(false);
        app.start();
    }

    public Game(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        player = new PlayerShip(50, 50, playerbullets);
        enemy = new EnemyShip(enemybullets, gc);
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
        //Move and Shoot With the Player Ship
        Input input = gc.getInput();
        player.shooting = false;
        if (input.isKeyDown(Input.KEY_LEFT) && player.x > 0) {
            player.x -= delta * Ship.speedmultiplier;
        }
        if (input.isKeyDown(Input.KEY_RIGHT) && player.x < gc.getScreenWidth()) {
            player.x += delta * Ship.speedmultiplier;
        }
        if (input.isKeyDown(Input.KEY_UP) && player.y > 0) {
            player.y -= delta * Ship.speedmultiplier;
        }
        if (input.isKeyDown(Input.KEY_DOWN) && player.y < gc.getScreenHeight()) {
            player.y += delta * Ship.speedmultiplier;
        }
        if (input.isKeyPressed(Input.KEY_SPACE)) {
            player.shooting = true;
            player.shoot();
        } else if (input.isKeyDown(Input.KEY_SPACE)) {
            player.shooting = true;
            if (rand.nextInt(10) == 0) {
                player.shoot(delta);
            }
        }
        player.animation().update(delta);

        //Update Bullet Position
        for (int i = playerbullets.size() - 1; i >= 0; i--) {
            playerbullets.get(i).y -= delta * 0.1f;
            playerbullets.get(i).animation().update(delta);
            if (playerbullets.get(i).y < -playerbullets.get(i).animation().getHeight()) {
                playerbullets.remove(i);
            }
        }
        for (int i = enemybullets.size() - 1; i >= 0; i--) {
            enemybullets.get(i).y -= delta * 0.1f;
            enemybullets.get(i).animation().update(delta);
            if (enemybullets.get(i).y > gc.getHeight() + enemybullets.get(i).animation().getHeight()) {
                enemybullets.remove(i);
            }
        }

        //Test Bullet Collisions
        for (Bullet indiv : enemybullets) {
            if (!(indiv.x + indiv.animation().getWidth() < player.x)
                    && !(player.x + player.animation().getWidth() < indiv.x)
                    && !(indiv.y + indiv.animation().getHeight() < player.y)
                    && !(player.y + player.animation().getHeight() < indiv.y)) {
            }
        }
    }

    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException {
        player.animation().draw((int) player.x, (int) player.y);
        enemy.animation().draw((int) enemy.x, (int) enemy.y);
        for (Bullet indiv : playerbullets) {
            indiv.animation().draw((int) indiv.x, (int) indiv.y);
        }
        for (Bullet indiv : enemybullets) {
            indiv.animation().draw((int) indiv.x, (int) indiv.y);
        }
    }
}
