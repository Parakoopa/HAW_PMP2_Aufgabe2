package haw.beier.tim.pm2.aufgabe2.CD;

public class DoubleLinkedList {

	private DoubleNode tail;
	private DoubleNode head;

	public void add(Object content) {
		DoubleNode node = new DoubleNode(content);

		if (tail != null) {
			tail.setSucc(node);
			tail = node;
		} 
		else { // empty list
			tail = node;

		}
	}

	DoubleNode get(int index) {
		if (head == null) {
			return null;
		}
		DoubleNode temp = head;
		while (index > 1) {
			temp = temp.getSucc();
			index -= 1;
		}
		return temp;
	}

	int indexOf(Object content) {
		DoubleNode temp = head;
		int index = 0;
		while (content != temp.getContent()) {
			temp = temp.getSucc();
			index++;
		}
		return index;
	}

	void insert(int index, Object content) {
		DoubleNode pred = this.get(index).getPred();
		pred.setSucc((DoubleNode) content);

	}

	boolean isEmpty() {
		if (head != null) {
			return false;
		}
		return true;
	}

	int size() {
		int size = 0;
		DoubleNode temp = head;
		while (temp != null) {
			temp = temp.getSucc();
			size++;
		}
		return size;
	}

	boolean remove(Object content) {

		if (content == null || size() < 1) {
			return false;
		}
		int indexToDelete = this.indexOf(content);
		DoubleNode toDelete = get(indexToDelete);
		DoubleNode toDeleteSucc = toDelete.getSucc();
		DoubleNode toDeletePred = toDelete.getPred();
		toDeletePred.setSucc(toDeleteSucc);
		return true;
	}

	void removeFirst() {
		remove(head);
	}

	void removeLast() {
		remove(get(size() - 1));

	}

	public String toString() {
		String string = "[";
		DoubleNode next = head;
		while (next != null) {
			string = string + ", " + next;

		}
		return string;
	}
}
