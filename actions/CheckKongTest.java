package actions;


import model.Cards_in_hand;
import model.Stack_of_cards;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CheckKongTest {

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
    public void testFindExposedKongCardsSimple() throws Exception {
        // Test for Chow situation:
        // Have 3 card in hand
        // Have no joker(34)
        // It can Kong if one player play 1

        ArrayList<Integer> cards = new ArrayList<>(Arrays.asList(1,1,1));
        Method findSameCardsMethod = Check_Pong.class.getDeclaredMethod("findSameCards", ArrayList.class, int.class);
        findSameCardsMethod.setAccessible(true);

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1));
        ArrayList<Integer> result = (ArrayList<Integer>) findSameCardsMethod.invoke(null, cards, 3);

        assertEquals(expected, result);
    }

    @Test
    public void testFindExposedKongCardsNormal() throws Exception {
        // Test for Chow situation:
        // Have 13 card in hand
        // Have no joker(34)
        // It can Kong if one player play 1 to 4

        ArrayList<Integer> cards = new ArrayList<>(Arrays.asList(1,1,1,2,2,2,3,3,3,4,4,4,5,5));
        Method findSameCardsMethod = Check_Pong.class.getDeclaredMethod("findSameCards", ArrayList.class, int.class);
        findSameCardsMethod.setAccessible(true);

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Integer> result = (ArrayList<Integer>) findSameCardsMethod.invoke(null, cards, 3);

        assertEquals(expected, result);
    }

    @Test
    public void testFindConcealedKongCardsSimple() throws Exception {
        // Test for Chow situation:
        // Have 3 card in hand
        // Have no joker(34)
        // It can Kong for 1

        ArrayList<Integer> cards = new ArrayList<>(Arrays.asList(1,1,1,1));
        Method findSameCardsMethod = Check_Pong.class.getDeclaredMethod("findSameCards", ArrayList.class, int.class);
        findSameCardsMethod.setAccessible(true);

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1));
        ArrayList<Integer> result = (ArrayList<Integer>) findSameCardsMethod.invoke(null, cards, 4);

        assertEquals(expected, result);
    }

    @Test
    public void testFindConcealedKongCardsNormal() throws Exception {
        // Test for Chow situation:
        // Have 13 card in hand
        // Have no joker(34)
        // It can Kong for 1 and 3

        ArrayList<Integer> cards = new ArrayList<>(Arrays.asList(1,1,1,1,2,2,2,3,3,3,3,4,4,4));
        Method findSameCardsMethod = Check_Pong.class.getDeclaredMethod("findSameCards", ArrayList.class, int.class);
        findSameCardsMethod.setAccessible(true);

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1,3));
        ArrayList<Integer> result = (ArrayList<Integer>) findSameCardsMethod.invoke(null, cards, 4);

        assertEquals(expected, result);
    }

    @Test
    public void testFindKongAfterPongCardsNormal() throws Exception {
        // Test for Chow situation:
        // Have no card in hand, already Pong 111
        // Have no joker(34)
        // It can Kong if draw 1 from stack

        ArrayList<Integer> cards = new ArrayList<>(Arrays.asList(1,1,1,1,2,2,2,2,3,3,4,4,4,4));
        Cards_in_hand cardsInHand = new Cards_in_hand();
        cardsInHand.setCards(cards);
        cardsInHand.playCard(13);
        cardsInHand.getAction().findCardsAction();
        cardsInHand.getAction().checkCardAction();
        cardsInHand.getAction().removeAction(2,0);
        cardsInHand.getAction().checkCardAction_draw(4);
        cardsInHand.getAction().removeAction(4,2);

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1,1,1,1,2,2,2,2,3,3));

        assertEquals(expected, cardsInHand.showCards());
    }

}
