package model;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CheckChowTest {

    private Cards_in_hand hand;
    private Check_Chow checker;


    @Before
    public void setUp() {
        Stack_of_cards.getStack().newStack();

        hand = new Cards_in_hand();
        checker = new Check_Chow(hand);
    }

    @Test
    public void testFindChowCards1() throws Exception {
        ArrayList<Integer> cards = new ArrayList<>(Arrays.asList(0, 1));
        Method findChowCardsMethod = Check_Chow.class.getDeclaredMethod("findChowCards", ArrayList.class);
        findChowCardsMethod.setAccessible(true);

        Map<Integer, ArrayList<Integer[]>> result = (Map<Integer, ArrayList<Integer[]>>) findChowCardsMethod.invoke(null, cards);

        Map<Integer, ArrayList<Integer[]>> expected = new HashMap<>();

        expected.put(2, new ArrayList<>(Arrays.asList(new Integer[][]{{1, 3}})));

        assertEquals(expected.size(), result.size());
//        for (Map.Entry<Integer, ArrayList<Integer[]>> entry : expected.entrySet()) {
//            assertTrue(result.containsKey(entry.getKey()));
//            assertEquals(entry.getValue().size(), result.get(entry.getKey()).size());
//            for (int i = 0; i < entry.getValue().size(); i++) {
//                assertTrue(Arrays.equals(entry.getValue().get(i), result.get(entry.getKey()).get(i)));
//            }
//        }
    }
    @Test
    public void testFindChowCards2() throws Exception {
        ArrayList<Integer> cards = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        Method findChowCardsMethod = Check_Chow.class.getDeclaredMethod("findChowCards", ArrayList.class);
        findChowCardsMethod.setAccessible(true);

        Map<Integer, ArrayList<Integer[]>> result = (Map<Integer, ArrayList<Integer[]>>) findChowCardsMethod.invoke(null, cards);

        Map<Integer, ArrayList<Integer[]>> expected = new HashMap<>();
        expected.put(0, new ArrayList<>(Arrays.asList(new Integer[][]{{1, 2}})));
        expected.put(1, new ArrayList<>(Arrays.asList(new Integer[][]{{0, 2},{2, 3}})));
        expected.put(2, new ArrayList<>(Arrays.asList(new Integer[][]{{0, 1},{1, 3}})));
        expected.put(3, new ArrayList<>(Arrays.asList(new Integer[][]{{1, 2}})));
        expected.put(4, new ArrayList<>(Arrays.asList(new Integer[][]{{2, 3}})));

        assertEquals(expected.size(), result.size());
        for (Map.Entry<Integer, ArrayList<Integer[]>> entry : expected.entrySet()) {
            Integer key = entry.getKey();
            ArrayList<Integer[]> expectedValue = entry.getValue();

            System.out.println("Checking key: " + key);

            // Check if the key exists in the result
            assertTrue("Key not found in result: " + key, result.containsKey(key));

            ArrayList<Integer[]> resultValue = result.get(key);

            // Check if the sizes match
            System.out.println("Expected size: " + expectedValue.size() + ", Actual size: " + resultValue.size());
            assertEquals("Size mismatch for key: " + key, expectedValue.size(), resultValue.size());

            // Check if the arrays match
            for (int i = 0; i < expectedValue.size(); i++) {
                Integer[] expectedArray = expectedValue.get(i);
                Integer[] resultArray = resultValue.get(i);

                System.out.println("Checking arrays at index: " + i + " for key: " + key);
                System.out.println("Expected: " + Arrays.toString(expectedArray) + ", Actual: " + Arrays.toString(resultArray));

                assertArrayEquals("Array mismatch at index: " + i + " for key: " + key, expectedArray, resultArray);
            }
        }
    }
    @Test
    public void testFindChowCards() throws Exception {
        ArrayList<Integer> cards = new ArrayList<>(Arrays.asList(0, 1, 2, 11, 12, 13, 24, 25, 26, 27, 27));
        Method findChowCardsMethod = Check_Chow.class.getDeclaredMethod("findChowCards", ArrayList.class);
        findChowCardsMethod.setAccessible(true);

        Map<Integer, ArrayList<Integer[]>> result = (Map<Integer, ArrayList<Integer[]>>) findChowCardsMethod.invoke(null, cards);

        Map<Integer, ArrayList<Integer[]>> expected = new HashMap<>();
        expected.put(0, new ArrayList<>(Arrays.asList(new Integer[][]{{1, 2}})));
        expected.put(1, new ArrayList<>(Arrays.asList(new Integer[][]{{0, 2}})));
        expected.put(2, new ArrayList<>(Arrays.asList(new Integer[][]{{0, 1}})));
        expected.put(3, new ArrayList<>(Arrays.asList(new Integer[][]{{1, 2}})));
        expected.put(10, new ArrayList<>(Arrays.asList(new Integer[][]{{11, 12}})));
        expected.put(13, new ArrayList<>(Arrays.asList(new Integer[][]{{11, 12}})));
        expected.put(12, new ArrayList<>(Arrays.asList(new Integer[][]{{11, 13}})));

        expected.put(11, new ArrayList<>(Arrays.asList(new Integer[][]{{12, 13}})));
        expected.put(14, new ArrayList<>(Arrays.asList(new Integer[][]{{12, 13}})));

        expected.put(23, new ArrayList<>(Arrays.asList(new Integer[][]{{24, 25}})));
        expected.put(24, new ArrayList<>(Arrays.asList(new Integer[][]{{25, 26}})));
        expected.put(25, new ArrayList<>(Arrays.asList(new Integer[][]{{24, 26}})));
        expected.put(26, new ArrayList<>(Arrays.asList(new Integer[][]{{24, 25}})));
        assertEquals(expected.size(), result.size());
        for (Map.Entry<Integer, ArrayList<Integer[]>> entry : expected.entrySet()) {
            Integer key = entry.getKey();
            ArrayList<Integer[]> expectedValue = entry.getValue();

            System.out.println("Checking key: " + key);

            // Check if the key exists in the result
            assertTrue("Key not found in result: " + key, result.containsKey(key));

            ArrayList<Integer[]> resultValue = result.get(key);

            // Check if the sizes match
            System.out.println("Expected size: " + expectedValue.size() + ", Actual size: " + resultValue.size());
            assertEquals("Size mismatch for key: " + key, expectedValue.size(), resultValue.size());

            // Check if the arrays match
            for (int i = 0; i < expectedValue.size(); i++) {
                Integer[] expectedArray = expectedValue.get(i);
                Integer[] resultArray = resultValue.get(i);

                System.out.println("Checking arrays at index: " + i + " for key: " + key);
                System.out.println("Expected: " + Arrays.toString(expectedArray) + ", Actual: " + Arrays.toString(resultArray));

                assertArrayEquals("Array mismatch at index: " + i + " for key: " + key, expectedArray, resultArray);
            }
        }
    }

    @Test
    public void testFindCards() throws Exception {
        hand.setCards(new ArrayList<>(Arrays.asList(0, 1, 2, 11, 12, 13, 24, 25, 26, 27, 27)));
        checker.findCards();

        Field chowCardsField = Check_Chow.class.getDeclaredField("chowCards");
        chowCardsField.setAccessible(true);

        Map<Integer, ArrayList<Integer[]>> result = (Map<Integer, ArrayList<Integer[]>>) chowCardsField.get(checker);

        Map<Integer, ArrayList<Integer[]>> expected = new HashMap<>();
        expected.put(0, new ArrayList<>(Arrays.asList(new Integer[][]{{1, 2}})));
        expected.put(1, new ArrayList<>(Arrays.asList(new Integer[][]{{0, 2}})));
        expected.put(2, new ArrayList<>(Arrays.asList(new Integer[][]{{0, 1}})));
        expected.put(3, new ArrayList<>(Arrays.asList(new Integer[][]{{1, 2}})));
        expected.put(10, new ArrayList<>(Arrays.asList(new Integer[][]{{11, 12}})));
        expected.put(13, new ArrayList<>(Arrays.asList(new Integer[][]{{11, 12}})));
        expected.put(12, new ArrayList<>(Arrays.asList(new Integer[][]{{11, 13}})));

        expected.put(11, new ArrayList<>(Arrays.asList(new Integer[][]{{12, 13}})));
        expected.put(14, new ArrayList<>(Arrays.asList(new Integer[][]{{12, 13}})));

        expected.put(23, new ArrayList<>(Arrays.asList(new Integer[][]{{24, 25}})));
        expected.put(24, new ArrayList<>(Arrays.asList(new Integer[][]{{25, 26}})));
        expected.put(25, new ArrayList<>(Arrays.asList(new Integer[][]{{24, 26}})));
        expected.put(26, new ArrayList<>(Arrays.asList(new Integer[][]{{24, 25}})));

        assertEquals(expected.size(), result.size());
        for (Map.Entry<Integer, ArrayList<Integer[]>> entry : expected.entrySet()) {
            Integer key = entry.getKey();
            ArrayList<Integer[]> expectedValue = entry.getValue();

            System.out.println("Checking key: " + key);

            // Check if the key exists in the result
            assertTrue("Key not found in result: " + key, result.containsKey(key));

            ArrayList<Integer[]> resultValue = result.get(key);

            // Check if the sizes match
            System.out.println("Expected size: " + expectedValue.size() + ", Actual size: " + resultValue.size());
            assertEquals("Size mismatch for key: " + key, expectedValue.size(), resultValue.size());

            // Check if the arrays match
            for (int i = 0; i < expectedValue.size(); i++) {
                Integer[] expectedArray = expectedValue.get(i);
                Integer[] resultArray = resultValue.get(i);

                System.out.println("Checking arrays at index: " + i + " for key: " + key);
                System.out.println("Expected: " + Arrays.toString(expectedArray) + ", Actual: " + Arrays.toString(resultArray));

                assertArrayEquals("Array mismatch at index: " + i + " for key: " + key, expectedArray, resultArray);
            }
        }

    }



    @Test
    public void testCheckCard() throws Exception {
        hand.setCards(new ArrayList<>(Arrays.asList(0, 1, 2, 11, 12, 13, 24, 25, 26, 27, 27)));
        checker.findCards();

        Method checkCardMethod = Check_Chow.class.getDeclaredMethod("checkCard", int.class);
        checkCardMethod.setAccessible(true);
        checkCardMethod.invoke(checker, 3);

        Field actionPairsField = Check_Chow.class.getDeclaredField("actionPairs");
        actionPairsField.setAccessible(true);

        ArrayList<Integer[]> actionPairs = (ArrayList<Integer[]>) actionPairsField.get(checker);
        if (actionPairs == null) {
            actionPairs = new ArrayList<>();
        }
        assertEquals(1, actionPairs.size());
        assertTrue(Arrays.equals(new Integer[]{1, 2}, actionPairs.get(0)));

        Field actionCardField = Check_Chow.class.getDeclaredField("actionCard");
        actionCardField.setAccessible(true);
        Integer actionCard = (Integer) actionCardField.get(checker);
        assertEquals(Integer.valueOf(3), actionCard);
    }

    @Test
    public void testRemoveCard() throws Exception {
        hand.setCards(new ArrayList<>(Arrays.asList(0, 1, 2, 11, 12, 13, 24, 25, 26, 27, 27)));
        checker.findCards();

        Method checkCardMethod = Check_Chow.class.getDeclaredMethod("checkCard", int.class);
        checkCardMethod.setAccessible(true);
        checkCardMethod.invoke(checker, 3);

        Method removeCardMethod = Check_Chow.class.getDeclaredMethod("removeCard", int.class);
        removeCardMethod.setAccessible(true);
        removeCardMethod.invoke(checker, 0);

        ArrayList<Integer> expectedCards = new ArrayList<>(Arrays.asList(0, 11, 12, 13, 24, 25, 26, 27, 27));
        assertEquals(expectedCards, hand.showCards());
    }
}
