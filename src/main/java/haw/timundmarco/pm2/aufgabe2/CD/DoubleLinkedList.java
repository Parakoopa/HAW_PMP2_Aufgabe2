package haw.timundmarco.pm2.aufgabe2.CD;

public class DoubleLinkedList {
    private DoubleNode head;
    private DoubleNode tail;

    /**
     * Fügt einen Knoten mit Inhalt content an das Ende der
     * Liste ein. Nach dem Einfügen zeigt tail auf den letzten
     * Knoten.
     * @param content
     */
    public void add(Object content) {
        DoubleNode newNode = new DoubleNode(content);
        if (tail != null) {
            tail.setSucc(newNode);
            tail = newNode;
        } else {
            tail = head = newNode;
        }
    }

    private DoubleNode getNode(int index) throws IndexOutOfBoundsException {
        DoubleNode next = head;
        if (next == null) throw new IndexOutOfBoundsException("no element with index found");
        for (int i = 0; i < index; i++) {
            next = next.getSucc();
            if (next == null) throw new IndexOutOfBoundsException("no element with index found");
        }
        return next;
    }

    /**
     * Gibt den Inhalt des Knoten an Position index in der Liste
     * zurück. Das erste Element steht an Position 0.
     * @param index
     * @return
     */
    public Object get(int index) throws IndexOutOfBoundsException {
        return getNode(index).getContent();
    }

    /**
     * Liefert die Position des Knotens mit Inhalt content zurück.
     * Ist kein Knoten mit content vorhanden, dann ist das
     * Ergebnis -1.
     * @param content
     * @return
     */
    public int indexOf(Object content) {
        DoubleNode next = head;
        int index = 0;
        while (next != null) {
            if (next.getContent() == content) return index;
            ++index;
            next = next.getSucc();
        }
        return -1;
    }

    /**
     * Fügt einen Knoten mit Inhalt content an der Position
     * index ein.
     * @param index
     * @param content
     */
    void insert(int index, Object content) throws IndexOutOfBoundsException {
        if (index == size()) {
            add(content);
            return;
        }
        DoubleNode newNode = new DoubleNode(content);
        DoubleNode next = getNode(index);
        next.setPred(newNode);
        if (index == 0) head = newNode;
    }

    /**
     * Liefert true, wenn die Liste leer ist, sonst false.
     * @return
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Gibt die Anzahl der Elemente der Liste zurück.
     * @return
     */
    public int size() {
        DoubleNode next = head;
        int size = 0;
        while (next != null) {
            ++size;
            next = next.getSucc();
        }
        return size;
    }


    private boolean removeByIndex(int index) {
        int originalSize = size();
        if (index == -1) return false;

        DoubleNode toDelete = getNode(index);
        DoubleNode toDeleteSucc = toDelete.getSucc();
        DoubleNode toDeletePred = toDelete.getPred();

        if (index == 0)              head = toDeleteSucc;
        if (index == originalSize-1) tail = toDeletePred;

        // Es muss nur eine von beiden Methoden aufgerufen werden (oder keine falls Liste nur
        // ein Element hatte)
        if (toDeleteSucc != null) toDeleteSucc.setPred(toDeletePred);
        else if (toDeletePred != null) toDeletePred.setSucc(null); // toDeleteSucc ist ja null

        return true;
    }

    /**
     * Löscht den Knoten mit Inhalt content aus der Liste. Ist
     * kein Knoten mit dem Inhalt content in der Liste enthalten
     * liefert die Methode false zurück, ansonsten true.
     * @param content
     * @return
     */
    public boolean remove(Object content) {
        return removeByIndex(indexOf(content));
    }

    /**
     * Löscht das erste Element der Liste. Nach dem Löschen
     * zeigt head auf das neue erste Element der Liste.
     */
    public void removeFirst() {
        removeByIndex(0);
    }

    /**
     *
     */
    public void removeLast() {
        removeByIndex(size()-1);
    }

    /**
     * Gibt eine Zeichenketten-Repräsentation für den Inhalt der
     * Liste zurück. Verwenden Sie eine Darstellung, wie diese
     * für Listen üblich ist.
     * @return
     */
    @Override
    public String toString() {
        StringBuilder returnStringBuilder = new StringBuilder("[");
        DoubleNode next = head;
        while (next != null) {
            returnStringBuilder.append(next.toString()).append(",");
            next = next.getSucc();
        }
        returnStringBuilder.deleteCharAt(returnStringBuilder.length()-1).append("]"); // Lösche das letzte Komma und hänge ] an.
        return returnStringBuilder.toString();
    }
}
