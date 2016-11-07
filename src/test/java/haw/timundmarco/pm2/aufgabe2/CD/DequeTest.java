package haw.timundmarco.pm2.aufgabe2.CD;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DequeTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    Deque testDeque;
    @Before
    public void setUp() {
        testDeque = new Deque();
        testDeque.pushLeft(1);
        testDeque.pushRight(2);
        testDeque.pushLeft(0);
        testDeque.pushRight(3);
        // Sollte sein:
        // [0,1,2,3]
        // pushLeft und pushRight müssen richtig funktionieren, es gibt keine Möglichkeit
        // diese von außen zu testen (ohne die Klassen zu verändern)
        // sie werden also unten implizit mit getestet.
    }

    @Test
    public void popLeft() {
        assertEquals(0, testDeque.popLeft());
        assertEquals(1, testDeque.popLeft());
        assertEquals(2, testDeque.popLeft());
        assertEquals(3, testDeque.popLeft());

        thrown.expect(NoSuchElementException.class);
        thrown.reportMissingExceptionWithMessage("Poping an empty Deque must thrown an exception.");
        testDeque.popLeft();
    }

    @Test
    public void popRight() {
        assertEquals(3, testDeque.popRight());
        assertEquals(2, testDeque.popRight());
        assertEquals(1, testDeque.popRight());
        assertEquals(0, testDeque.popRight());

        thrown.expect(NoSuchElementException.class);
        thrown.reportMissingExceptionWithMessage("Poping an empty Deque must thrown an exception.");
        testDeque.popRight();
    }

    @Test
    public void popLeftRight() {
        assertEquals(3, testDeque.popRight());
        assertEquals(0, testDeque.popLeft());
    }

    @Test
    public void peekLeft() {
        assertEquals(0, testDeque.peekLeft());
        assertEquals(0, testDeque.peekLeft());

        thrown.expect(NoSuchElementException.class);
        thrown.reportMissingExceptionWithMessage("Peeking an empty Deque must thrown an exception.");
        new Deque().peekLeft();
    }

    @Test
    public void peekRight() {
        assertEquals(3, testDeque.peekRight());
        assertEquals(3, testDeque.peekRight());

        thrown.expect(NoSuchElementException.class);
        thrown.reportMissingExceptionWithMessage("Peeking an empty Deque must thrown an exception.");
        new Deque().peekRight();
    }

    @Test
    public void size() {
        assertEquals(4, testDeque.size());
        assertEquals(0, new Deque().size());
    }

    @Test
    public void isEmpty() {
        assertFalse(testDeque.isEmpty());
        assertTrue(new Deque().isEmpty());
    }

}