package actions;

import model.Cards_in_hand;
import model.Stack_of_cards;
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
    public void testFindChowCardsSimple() throws Exception {
        // Test for Chow situation:
        // Have 2 card in hand
        // Have no joker(34)
        // There is only one situation when Chow
        // It can Chow if previous player play 0 or 3

        ArrayList<Integer> cards = new ArrayList<>(Arrays.asList(1,2));
        Method findChowCardsMethod = Check_Chow.class.getDeclaredMethod("findChowCards", ArrayList.class);
        findChowCardsMethod.setAccessible(true);

        Map<Integer, ArrayList<Integer[]>> result = (Map<Integer, ArrayList<Integer[]>>) findChowCardsMethod.invoke(null, cards);

        Map<Integer, ArrayList<Integer[]>> expected = new HashMap<>();

        expected.put(0, new ArrayList<>(Arrays.asList(new Integer[][]{{1,2}})));
        expected.put(3, new ArrayList<>(Arrays.asList(new Integer[][]{{1,2}})));

        assertEquals(expected.size(), result.size());
        for (Map.Entry<Integer, ArrayList<Integer[]>> entry : expected.entrySet()) {
            assertTrue(result.containsKey(entry.getKey()));
            assertEquals(entry.getValue().size(), result.get(entry.getKey()).size());
            for (int i = 0; i < entry.getValue().size(); i++) {
                assertTrue(Arrays.equals(entry.getValue().get(i), result.get(entry.getKey()).get(i)));
            }
        }
    }

    @Test
    public void testFindChowCardsMultipleSituation() throws Exception {
        // Test for Chow situation:
        // Have 4 card in hand
        // Have no joker(34)
        // There are three situations when Chow 3
        // It can Chow if previous player play 0, 3 or 6

        ArrayList<Integer> cards = new ArrayList<>(Arrays.asList(1,2,4,5));
        Method findChowCardsMethod = Check_Chow.class.getDeclaredMethod("findChowCards", ArrayList.class);
        findChowCardsMethod.setAccessible(true);

        Map<Integer, ArrayList<Integer[]>> result = (Map<Integer, ArrayList<Integer[]>>) findChowCardsMethod.invoke(null, cards);

        Map<Integer, ArrayList<Integer[]>> expected = new HashMap<>();

        expected.put(0, new ArrayList<>(Arrays.asList(new Integer[][]{{1,2}})));
        expected.put(3, new ArrayList<>(Arrays.asList(new Integer[][]{{1,2},{2,4},{4,5}})));
        expected.put(6, new ArrayList<>(Arrays.asList(new Integer[][]{{4,5}})));

        assertEquals(expected.size(), result.size());
        for (Map.Entry<Integer, ArrayList<Integer[]>> entry : expected.entrySet()) {
            Integer key = entry.getKey();
            ArrayList<Integer[]> expectedValue = entry.getValue();

            System.out.println("\nChecking key: " + key);

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
    public void testFindChowCardsNormal1() throws Exception {
        // Test for Chow situation:
        // Have 13 card in hand
        // Have no joker(34)
        // One of the most complex situation 0,0,0,1,2,3,4,5,6,7,8,8,8
        // It can Chow if previous player play 0 to 8

        ArrayList<Integer> cards = new ArrayList<>(Arrays.asList(0,0,0,1,2,3,4,5,6,7,8,8,8));
        Method findChowCardsMethod = Check_Chow.class.getDeclaredMethod("findChowCards", ArrayList.class);
        findChowCardsMethod.setAccessible(true);

        Map<Integer, ArrayList<Integer[]>> result = (Map<Integer, ArrayList<Integer[]>>) findChowCardsMethod.invoke(null, cards);

        Map<Integer, ArrayList<Integer[]>> expected = new HashMap<>();
        expected.put(0, new ArrayList<>(Arrays.asList(new Integer[][]{{1,2}})));
        expected.put(1, new ArrayList<>(Arrays.asList(new Integer[][]{{0,2},{2,3}})));
        expected.put(2, new ArrayList<>(Arrays.asList(new Integer[][]{{0,1},{1,3},{3,4}})));
        expected.put(3, new ArrayList<>(Arrays.asList(new Integer[][]{{1,2},{2,4},{4,5}})));
        expected.put(4, new ArrayList<>(Arrays.asList(new Integer[][]{{2,3},{3,5},{5,6}})));
        expected.put(5, new ArrayList<>(Arrays.asList(new Integer[][]{{3,4},{4,6},{6,7}})));
        expected.put(6, new ArrayList<>(Arrays.asList(new Integer[][]{{4,5},{5,7},{7,8}})));
        expected.put(7, new ArrayList<>(Arrays.asList(new Integer[][]{{5,6},{6,8}})));
        expected.put(8, new ArrayList<>(Arrays.asList(new Integer[][]{{6,7}})));

        assertEquals(expected.size(), result.size());
        for (Map.Entry<Integer, ArrayList<Integer[]>> entry : expected.entrySet()) {
            Integer key = entry.getKey();
            ArrayList<Integer[]> expectedValue = entry.getValue();

            System.out.println("\nChecking key: " + key);

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
    public void testFindChowCardsNormal2() throws Exception {
        // Test for Chow situation:
        // Have 13 card in hand
        // Have no joker(34)

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
}
