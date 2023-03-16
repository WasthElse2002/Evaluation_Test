package com.example.evaluation.test.game;


import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



public class GameTest {

    Game game;
    @BeforeEach
    public void init() {

        game = new Game();
    }

    @Test
    public void testSetActionNotNull() {
        game.setAction("pierre");
        assertNotNull(game.getAction());
    }

    @Test
    public void testSetActionBotNotNull() {
        game.setActionBot();
        assertNotNull(game.getActionBot());
    }

    @Test
    public void testSetActionEqualsNumber() {
        game.setAction("pierre");
        assertEquals("pierre",game.getAction());
    }

    @Test
    public void testSetActionBotEqualsNumber() {
        game.setActionBot();
        if(game.getActionBot() == "pierre") {
            assertEquals("pierre",game.getActionBot());
        }
        if(game.getActionBot() == "feuille") {
            assertEquals("feuille",game.getActionBot());
        }
        if(game.getActionBot() == "ciseaux") {
            assertEquals("ciseaux",game.getActionBot());
        }
    }

    @Test
    public void testThrowableAction() {
        assertNull(game.getActionBot());
    }

    @Test
    public void playTest() {
        
    }

}
