package model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CheckPongTest {

    private Cards_in_hand hand;
    private Check_Chow checker;

    @BeforeEach
    void setUp() {
        Stack_of_cards.getStack().newStack();

        hand = new Cards_in_hand();
        checker = new Check_Chow(hand);
    }

    @Test
    void testCountList() throws Exception {
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
    void testFindSameCards() throws Exception {
        Method findSameCardsMethod = Check_Pong.class.getDeclaredMethod("findSameCards", ArrayList.class, int.class);
        findSameCardsMethod.setAccessible(true);

        ArrayList<Integer> cardList = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 3, 4, 4, 4, 4));
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(2, 3, 4));

        @SuppressWarnings("unchecked")
        ArrayList<Integer> result = (ArrayList<Integer>) findSameCardsMethod.invoke(null, cardList, 2);
        assertEquals(expected, result);
    }

    @Test
    void testFindCards() throws Exception {
        Method findCardsMethod = Check_Pong.class.getDeclaredMethod("findCards");
        findCardsMethod.setAccessible(true);

        findCardsMethod.invoke(checker);

        Field availableCardsField = Check_Pong.class.getDeclaredField("availableCards");
        availableCardsField.setAccessible(true);

        @SuppressWarnings("unchecked")
        ArrayList<Integer> availableCards = (ArrayList<Integer>) availableCardsField.get(checker);

        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 6));
        assertEquals(expected, availableCards);
    }

    @Test
    void testCheckCard() throws Exception {
        Method findCardsMethod = Check_Pong.class.getDeclaredMethod("findCards");
        findCardsMethod.setAccessible(true);
        findCardsMethod.invoke(checker);

        Method checkCardMethod = Check_Pong.class.getDeclaredMethod("checkCard", int.class);
        checkCardMethod.setAccessible(true);

        checkCardMethod.invoke(checker, 6);

        Field actionCardField = Check_Pong.class.getDeclaredField("actionCard");
        actionCardField.setAccessible(true);

        int actionCard = (int) actionCardField.get(checker);
        assertEquals(6, actionCard);
//        assertEquals(2, hand.getStatus());
    }

    @Test
    void testRemoveCard() throws Exception {
        Field actionCardField = Check_Pong.class.getDeclaredField("actionCard");
        actionCardField.setAccessible(true);
        actionCardField.set(checker, 6);

        Method removeCardMethod = Check_Pong.class.getDeclaredMethod("removeCard", int.class);
        removeCardMethod.setAccessible(true);

        Discard_Pile.getDiscard().add(6); // Adding a card to the discard pile
        removeCardMethod.invoke(checker, 6);

        ArrayList<Integer> expectedCards = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 4, 5));
        assertEquals(expectedCards, hand.showCards());
//        assertTrue(Discard_Pile.getDiscard().getDiscardPile().isEmpty());
    }

    @Test
    void testGetAvailableCards() {
        checker.findCards();
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 6));
//        assertEquals(expected, checker.getAvailableCards());
    }
}
