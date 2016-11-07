package haw.timundmarco.pm2.aufgabe2.CD;

class DoubleNode {

    private DoubleNode pred;
    private DoubleNode succ;
    private Object content;

    /**
     * Initialisiert den Inhalt einer DoubleNode mit content. Zu
     * Beginn „zeigen“ succ und pred auf null.
     * @param content
     */
    DoubleNode(Object content) {
        this.content = content;
    }

    /**
     * Liefert den Inhalt eines Knotens.
     * @return
     */
    Object getContent() {
        return content;
    }

    /**
     * Liefert den Vorgängerknoten.
     * @return
     */
    DoubleNode getPred() {
        return pred;
    }

    /**
     * Liefert den Nachfolgerknoten.
     * @return
     */
    DoubleNode getSucc() {
        return succ;
    }

    /**
     * Verkettet den Vorgänger von this mit node und den
     * Nachfolger von node mit this. Vorsicht: node kann auch
     * null sein.
     * @param node
     */
    void setPred(DoubleNode node) {
        if (node != null) {
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
        if (node != null) {
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

