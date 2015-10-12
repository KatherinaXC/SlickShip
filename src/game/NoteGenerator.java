/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Random;
import org.jfugue.player.Player;
import org.jfugue.theory.Note;

/**
 *
 * @author Winterstorm
 */
public class NoteGenerator {

    Random rand = new Random();
    String[] notes = {"A", "B", "C", "D", "E", "F", "G"};

    public Note generate() {
        String note = this.notes[rand.nextInt(this.notes.length)];
        note += rand.nextInt(4) + 2; //octave
        return new Note(note + " ");
    }
    
    public static void main(String[] args) {
        NoteGenerator gen = new NoteGenerator();
        Player player = new Player();
        player.play(gen.generate());
    }
}
