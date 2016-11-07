package haw.koepcke.marco.pm2.aufgabe2.teileCD;

import java.util.NoSuchElementException;

public class Deque {

    private DoubleLinkedList list;

    /**
     * Erzeugt eine leere Deque
     */
    public Deque() {
        list = new DoubleLinkedList();
    }

    /**
     * Fügt ein Element vorne in die Deque ein.
     * @param o
     */
    public void pushLeft(Object o) {
        list.insert(0, o);
    }

    /**
     * Fügt ein Element hinten in die Deque ein.
     * @param o
     */
    public void pushRight(Object o) {
        list.add(o);
    }

    /**
     * Löscht das erste Element der Deque und
     * liefert es zurück
     * @return
     */
    public Object popLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        Object first = list.get(0);
        list.removeFirst();
        return first;
    }

    /**
     * Löscht das letzte Element der Deque und
     * liefert es zurück
     * @return
     */
    public Object popRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        Object last = list.get(list.size()-1);
        list.removeLast();
        return last;
    }

    /**
     * Liefert das erste Element der Deque ohne es
     * zu löschen.
     * @return
     */
    public Object peekLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return list.get(0);
    }

    /**
     * Liefert das letzte Element der Deque ohne es
     * zu löschen.
     * @return
     */
    public Object peekRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return list.get(list.size()-1);
    }

    /**
     * Gibt die Anzahl der Elemente zurück
     * @return
     */
    public int size() {
        return list.size();
    }

    /**
     * Prüft, ob eine Deque leer ist.
     * @return
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }
}