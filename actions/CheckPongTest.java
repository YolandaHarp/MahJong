package actions;


import model.Cards_in_hand;
import model.Stack_of_cards;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

public class CheckPongTest {

    private Cards_in_hand hand;
    private Check_Chow checker;

    @Before
    public void setUp() {
        Stack_of_cards.getStack().newStack();

        hand = new Cards_in_hand();
        checker = new Check_Chow(hand);
    }

    @Test
    public void testCountList() throws Exception {
        // Check method to count the number of the cards in hand

        Method countListMethod = Check_Pong.class.getDeclaredMethod("countList", ArrayList.class);
        countListMethod.setAccessible(true);

        ArrayList<Integer> cardList = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 3, 34));
        int[] expectedCountList = new int[34];
        expectedCountList[1] = 1;
        expectedCountList[2] = 2;
        expectedCountList[3] = 3;

        int[] result = (int[]) countListMethod.invoke(null, cardList);
        assertArrayEquals(expectedCountList, result);
    }

    @Test
    public void testFindSameCards() throws Exception {
        // Check method to find out the cards more than n in hands

        Method findSameCardsMethod = Check_Pong.class.getDeclaredMethod("findSameCards", ArrayList.class, int.class);
        findSameCardsMethod.setAccessible(true);

        // Find cards more than 2
        int n = 2;

        ArrayList<Integer> cardList = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4));
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 3, 4));

        @SuppressWarnings("unchecked")
        ArrayList<Integer> result = (ArrayList<Integer>) findSameCardsMethod.invoke(null, cardList, n);
        assertEquals(expected, result);
    }

    @Test
    public void testFindPongCardsSimple() throws Exception {
        // Test for Chow situation:
        // Have 2 card in hand
        // Have no joker(34)
        // It can Pong if one player play 1

        ArrayList<Integer> cards = new ArrayList<>(Arrays.asList(1,1));
        Method findSameCardsMethod = Check_Pong.class.getDeclaredMethod("findSameCards", ArrayList.class, int.class);
        findSameCardsMethod.setAccessible(true);

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1));

        ArrayList<Integer> result = (ArrayList<Integer>) findSameCardsMethod.invoke(null, cards, 2);
        assertEquals(expected, result);
    }

    @Test
    public void testFindPongCardsNormal() throws Exception {
        // Test for Chow situation:
        // Have 13 card in hand
        // Have no joker(34)
        // It can Pong if one player play 1 to 6

        ArrayList<Integer> cards = new ArrayList<>(Arrays.asList(1,1,2,2,3,3,4,4,5,5,6,6,6));
        Method findSameCardsMethod = Check_Pong.class.getDeclaredMethod("findSameCards", ArrayList.class, int.class);
        findSameCardsMethod.setAccessible(true);

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        ArrayList<Integer> result = (ArrayList<Integer>) findSameCardsMethod.invoke(null, cards, 2);
        assertEquals(expected, result);
    }
}
