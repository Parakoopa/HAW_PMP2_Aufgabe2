package haw.beier.tim.pm2.aufgabe2.CD;

public class Deque {

	private DoubleLinkedList deque;
	
	public Deque() {
		deque = new DoubleLinkedList();
	}
	
	public void pushLeft(Object o) {
		deque.insert(0, o);
	}
	
	public void pushRight(Object o) {
		deque.insert(size()+1, o);
	}
	
	public Object popLeft() {
		if(deque.isEmpty()) throw new IndexOutOfBoundsException();
		Object left = deque.get(0);
		deque.removeFirst();
		return left;
	}
	
	public Object popRight() {
		if(deque.isEmpty()) throw new IndexOutOfBoundsException();
		Object right = deque.get(size()+1);
		deque.removeLast();
		return right;
	}
	
	public Object peekLeft() {
		if(deque.isEmpty()) throw new IndexOutOfBoundsException();
		return deque.get(0);
	}
	
	public Object peekRight() {
		if(deque.isEmpty()) throw new IndexOutOfBoundsException();
		return deque.get(size()+1);
	}
	
	public int size() {
		return deque.size();
	}
	
	public boolean isEmpty() {
		if(deque.isEmpty()) {
			return true;
	}
		return false;
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
