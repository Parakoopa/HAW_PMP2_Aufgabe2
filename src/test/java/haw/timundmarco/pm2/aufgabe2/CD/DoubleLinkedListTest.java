package haw.timundmarco.pm2.aufgabe2.CD;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DoubleLinkedListTest {

    private DoubleLinkedList emptyList;
    private Object[]         emptyListArray;

    private DoubleLinkedList oneElementList;
    private Object[]         oneElementListArray;

    private DoubleLinkedList twoElementList;
    private Object[]         twoElementListArray;

    private DoubleLinkedList threeElementList;
    private Object[] threeElementListArray;

    @Before
    public void setUp() {
        emptyList = new DoubleLinkedList();
        emptyListArray = new Object[0];

        oneElementList = new DoubleLinkedList();
        oneElementList.add(0);
        oneElementListArray = new Object[] {0};

        twoElementList = new DoubleLinkedList();
        twoElementList.add(0);
        twoElementList.add(2);
        twoElementListArray = new Object[] {0,2};

        threeElementList = new DoubleLinkedList();
        threeElementList.add(0);
        threeElementList.add(2);
        threeElementList.add(3);
        threeElementListArray = new Object[] {0,2,3};
    }

    @Test
    public void add() {
        assertArrayEquals(emptyListArray, collectList(emptyList));
        assertArrayEquals(oneElementListArray, collectList(oneElementList));
        assertArrayEquals(twoElementListArray, collectList(twoElementList));
    }

    @Test
    public void get() {
        assertEquals(0, oneElementList.get(0));
        assertEquals(0, twoElementList.get(0));
        assertEquals(2, twoElementList.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getOutOfBounds() {
        oneElementList.get(1);
    }

    @Test
    public void indexOf() {
        assertEquals(0,twoElementList.indexOf(0));
        assertEquals(-1,twoElementList.indexOf(1));
        assertEquals(1,twoElementList.indexOf(2));
    }

    @Test
    public void insert() {
        twoElementList.insert(0,4);
        twoElementList.insert(1,5);
        twoElementList.insert(3,6);
        twoElementList.insert(5,7);
        assertArrayEquals(new Object[] {4,5,0,6,2,7}, collectList(twoElementList));
    }

    @Test
    public void isEmpty() {
        assertTrue(emptyList.isEmpty());
        assertFalse(oneElementList.isEmpty());
    }

    @Test
    public void size() {
        assertEquals(0, emptyList.size());
        assertEquals(1, oneElementList.size());
        assertEquals(2, twoElementList.size());
    }

    @Test
    public void remove() {
        assertTrue(threeElementList.remove(2));
        assertArrayEquals(new Object[] {0,3}, collectList(threeElementList));
        assertFalse(threeElementList.remove(2));
        assertTrue(threeElementList.remove(0));
        assertArrayEquals(new Object[] {3}, collectList(threeElementList));
        assertTrue(threeElementList.remove(3));
        assertArrayEquals(emptyListArray, collectList(threeElementList));
    }

    @Test
    public void removeFirst() {
        twoElementList.removeFirst();
        assertArrayEquals(new Object[] {2}, collectList(twoElementList));
        oneElementList.removeFirst();
        assertArrayEquals(emptyListArray, collectList(oneElementList));
    }

    @Test
    public void removeLast() {
        twoElementList.removeLast();
        assertArrayEquals(new Object[] {0}, collectList(twoElementList));
        oneElementList.removeLast();
        assertArrayEquals(emptyListArray, collectList(oneElementList));
    }

    private Object[] collectList(DoubleLinkedList testList) {
        // Von get und size abhängig
        Object[] array = new Object[testList.size()];
        for (int i = 0; i < testList.size(); i++) {
            array[i] = testList.get(i);
        }
        return array;
    }
}