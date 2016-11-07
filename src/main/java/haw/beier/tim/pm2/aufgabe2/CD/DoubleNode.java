package haw.beier.tim.pm2.aufgabe2.CD;

public class DoubleNode {

	private Object content;
	private DoubleNode pred;
	private DoubleNode succ;
	
	
	DoubleNode(Object content) {
		this.content = content;
	}
	
	Object getContent() {
		return content;
	}
	
	DoubleNode getPred() {
		return pred;
	}
	
	DoubleNode getSucc() {
		return succ;
		
	}
	
	void setPred(DoubleNode node) {
		if(pred != null) {
			pred.succ = node;
		}
		if(node != null) {
			node.pred = pred;
			node.succ = this;
		}
		pred = node;
	}
	
	void setSucc(DoubleNode node) {
		if(succ != null) {
			succ.pred = node;
		}
		if(node != null) {
			node.succ = succ;
			node.pred = this;
		}
		succ = node;
	}
	
	public String toString() {
		return content.toString();
	}
	
}
