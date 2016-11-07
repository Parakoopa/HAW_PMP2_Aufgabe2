package haw.timundmarco.pm2.aufgabe2.CD;

public class DoubleNode {

    private DoubleNode pred;
    private DoubleNode succ;
    private Object content;

    /**
     * Initialisiert den Inhalt einer DoubleNode mit content. Zu
     * Beginn „zeigen“ succ und pred auf null.
     * @param content
     */
    public DoubleNode(Object content) {
        this.content = content;
    }

    /**
     * Liefert den Inhalt eines Knotens.
     * @return
     */
    public Object getContent() {
        return content;
    }

    /**
     * Liefert den Vorgängerknoten.
     * @return
     */
    public DoubleNode getPred() {
        return pred;
    }

    /**
     * Liefert den Nachfolgerknoten.
     * @return
     */
    public DoubleNode getSucc() {
        return succ;
    }

    /**
     * Verkettet den Vorgänger von this mit node und den
     * Nachfolger von node mit this. Vorsicht: node kann auch
     * null sein.
     * @param node
     */
    public void setPred(DoubleNode node) {
        if (pred != null) pred.succ = node;
        if (node != null) {
            node.pred = pred;
            node.succ = this;
        }
        pred = node;
    }

    /**
     * Verkettet den Nachfolger von this mit node und den
     * Vorgänger von node mit this. Vorsicht: node kann auch
     * null sein
     * @param node
     */
    void setSucc(DoubleNode node) {
        if (succ != null) succ.pred = node;
        if (node != null) {
            node.succ = succ;
            node.pred = this;
        }
        succ = node;
    }

    /**
     * Gibt den Inhalt des Knotens als Zeichenkette zurück.
     * @return
     */
    @Override
    public String toString() {
        return content.toString();
    }
}

