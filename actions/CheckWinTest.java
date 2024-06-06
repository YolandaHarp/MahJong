package actions;

import model.Cards_in_hand;
import model.Stack_of_cards;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckWinTest {

    @Test
    public void testCheckWinNormal1() {
        // Test for win situation:
        // Have 13 card in hand
        // Have no joker(34)
        // One of the most complex situation 0,0,0,1,2,3,4,5,6,7,8,8,8
        // It can win if it gets 0 to 8 and joker

        Stack_of_cards.getStack().newStack();
        Cards_in_hand hand = new Cards_in_hand();

        hand.setCards(new ArrayList<>(Arrays.asList(0,0,0,1,2,3,4,5,6,7,8,8,8)));

        Check_Win checker = new Check_Win(hand);

        for(int i = 0; i < 35; i++){
            if(i <= 8 || i == 34){
                assertTrue(checker.checkWin(i));
            }else{
                assertFalse(checker.checkWin(i));
            }
        }
    }

    @Test
    public void testCheckWinNormal2() {
        // Test for win situation:
        // Have 13 card in hand
        // Have 1 joker(34)
        // It can win if it gets 1, 4, 23, 26 and joker

        Stack_of_cards.getStack().newStack();
        Cards_in_hand hand = new Cards_in_hand();

        hand.setCards(new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,11,11,11,24,25,34)));

        Check_Win checker = new Check_Win(hand);

        for(int i = 0; i < 35; i++){
            if(i == 1 || i == 4 || i == 23 || i == 26 || i == 34){
                assertTrue(checker.checkWin(i));
            }else{
                assertFalse(checker.checkWin(i));
            }
        }
    }

    @Test
    public void testCheckWinNormal3() {
        // Test for win situation:
        // Have 13 card in hand
        // Have 2 joker(34)
        // It can win when it gets any card

        Stack_of_cards.getStack().newStack();
        Cards_in_hand hand = new Cards_in_hand();

        hand.setCards(new ArrayList<>(Arrays.asList(1,1,2,2,3,3,11,11,11,24,25,34,34)));

        Check_Win checker = new Check_Win(hand);

        for(int i = 0; i < 35; i++){
            assertTrue(checker.checkWin(i));
        }
    }

    @Test
    public void testCheckWinSpecial1() {
        // Test for win situation:
        // Have 10 card in hand
        // Have no joker(34)
        // Special situation have 6 pairs and one along
        // It can win if it gets the same card to along one

        Stack_of_cards.getStack().newStack();
        Cards_in_hand hand = new Cards_in_hand();

        hand.setCards(new ArrayList<>(Arrays.asList(1,1,2,2,13,13,14,14,25,25,26,26,27)));

        Check_Win checker = new Check_Win(hand);

        for(int i = 0; i < 35; i++){
            if(i == 27 || i == 34){
                assertTrue(checker.checkWin(i));
            }else{
                assertFalse(checker.checkWin(i));
            }
        }
    }

    @Test
    public void testCheckWinSpecial2() {
        // Test for win situation:
        // Have 13 card in hand
        // Have no joker(34)
        // Special situation 0,8,9,17,18,26,27,28,29,30,31,32,33
        // It can win if it gets any one of 0,8,9,17,18,26,27,28,29,30,31,32,33

        Stack_of_cards.getStack().newStack();
        Cards_in_hand hand = new Cards_in_hand();

        hand.setCards(new ArrayList<>(Arrays.asList(0,8,9,17,18,26,27,28,29,30,31,32,33)));

        Check_Win checker = new Check_Win(hand);

        for(int i = 0; i < 35; i++){
            if(i == 0 || i == 8 || i == 9 || i == 17 || i == 18 || i == 26 || i >=27 ){
                assertTrue(checker.checkWin(i));
            }else{
                assertFalse(checker.checkWin(i));
            }
        }
    }

    @Test
    public void testCheckWinPutAway1() {
        // Test for win situation:
        // Have 10 card in hand
        // Have no joker(34)
        // It can win when it gets 23,26 and joker

        Stack_of_cards.getStack().newStack();
        Cards_in_hand hand = new Cards_in_hand();

        hand.setCards(new ArrayList<>(Arrays.asList(1,1,2,2,3,3,14,14,24,25)));

        Check_Win checker = new Check_Win(hand);

        for(int i = 0; i < 35; i++){
            if(i == 23 || i == 26 || i == 34){
                assertTrue(checker.checkWin(i));
            }else{
                assertFalse(checker.checkWin(i));
            }
        }
    }

    @Test
    public void testCheckWinPutAway2() {
        // Test for win situation:
        // Have 7 card in hand
        // Have no joker(34)
        // It can win when it gets 23,26 and joker

        Stack_of_cards.getStack().newStack();
        Cards_in_hand hand = new Cards_in_hand();

        hand.setCards(new ArrayList<>(Arrays.asList(1,2,3,14,14,24,25)));

        Check_Win checker = new Check_Win(hand);

        for(int i = 0; i < 35; i++){
            if(i == 23 || i == 26 || i == 34){
                assertTrue(checker.checkWin(i));
            }else{
                assertFalse(checker.checkWin(i));
            }
        }
    }

    @Test
    public void testCheckWinPutAway3() {
        // Test for win situation:
        // Have 4 card in hand
        // Have no joker(34)
        // It can win when it gets 23,26 and joker

        Stack_of_cards.getStack().newStack();
        Cards_in_hand hand = new Cards_in_hand();

        hand.setCards(new ArrayList<>(Arrays.asList(14,14,24,25)));

        Check_Win checker = new Check_Win(hand);

        for(int i = 0; i < 35; i++){
            if(i == 23 || i == 26 || i == 34){
                assertTrue(checker.checkWin(i));
            }else{
                assertFalse(checker.checkWin(i));
            }
        }
    }

    @Test
    public void testCheckWinPutAway4() {
        // Test for win situation:
        // Have 1 card in hand
        // Have no joker(34)
        // It can win when it gets 25 and joker

        Stack_of_cards.getStack().newStack();
        Cards_in_hand hand = new Cards_in_hand();

        hand.setCards(new ArrayList<>(Arrays.asList(25)));

        Check_Win checker = new Check_Win(hand);

        for(int i = 0; i < 35; i++){
            if(i == 25 || i == 34){
                assertTrue(checker.checkWin(i));
            }else{
                assertFalse(checker.checkWin(i));
            }
        }
    }
}
