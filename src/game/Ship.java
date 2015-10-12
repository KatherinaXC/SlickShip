/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

/**
 *
 * @author Winterstorm
 */
public abstract class Ship {

    public static final int duration = 100;
    public static final int cooldown = 25;
    public static final float speedmultiplier = 0.1f;

    float x;
    float y;

    public abstract void shoot() throws SlickException;

    public abstract void die();

    public abstract Animation animation();
}
