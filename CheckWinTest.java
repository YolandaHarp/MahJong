package model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckWinTest {

    @Test
    public void testCheckWin() {
        Stack_of_cards.getStack().newStack();
        Cards_in_hand hand = new Cards_in_hand();

        hand.setCards(new ArrayList<>(Arrays.asList(0,0,0,1,2,11,12,13,24,25,26,27,27)));

        CheckWin checker = new CheckWin(hand);

        assertTrue(checker.checkWin(34));
    }
    @Test
    public void testCheckWin1() {
        Stack_of_cards.getStack().newStack();
        Cards_in_hand hand = new Cards_in_hand();

        hand.setCards(new ArrayList<>(Arrays.asList(0,0,0,1,2,3,4,5,6,7,8,8,8)));

        CheckWin checker = new CheckWin(hand);

        assertTrue(checker.checkWin(0));
        assertTrue(checker.checkWin(1));
        assertTrue(checker.checkWin(2));
        assertTrue(checker.checkWin(3));
        assertTrue(checker.checkWin(4));
        assertTrue(checker.checkWin(5));
        assertTrue(checker.checkWin(6));
        assertTrue(checker.checkWin(7));
        assertTrue(checker.checkWin(8));
        assertTrue(checker.checkWin(34));


    }
    @Test
    public void testCheckWin2() {
        Stack_of_cards.getStack().newStack();
        Cards_in_hand hand = new Cards_in_hand();

        hand.setCards(new ArrayList<>(Arrays.asList(0,1)));

        CheckWin checker = new CheckWin(hand);

        assertFalse(checker.checkWin(34));
    }
    @Test
    public void testCheckWin3() {
        Stack_of_cards.getStack().newStack();
        Cards_in_hand hand = new Cards_in_hand();

        hand.setCards(new ArrayList<>(Arrays.asList(1,1,1,1,2,2,2,2,3,3,3,3,4)));

        CheckWin checker = new CheckWin(hand);

        assertTrue(checker.checkWin(4));
    }
    @Test
    public void testCheckWin4() {
        Stack_of_cards.getStack().newStack();
        Cards_in_hand hand = new Cards_in_hand();

        hand.setCards(new ArrayList<>(Arrays.asList(0,0,0,1,2,11,12,13,24,25,26,27,27)));

        CheckWin checker = new CheckWin(hand);

        assertTrue(checker.checkWin(34));
    }
    @Test
    public void testCheckWin5() {
        Stack_of_cards.getStack().newStack();
        Cards_in_hand hand = new Cards_in_hand();

        hand.setCards(new ArrayList<>(Arrays.asList(0,0,0,1,2,11,12,13,24,25,26,27,27)));

        CheckWin checker = new CheckWin(hand);

        assertTrue(checker.checkWin(34));
    }

    @Test
    public void testGetWinCard() {

    }

}
