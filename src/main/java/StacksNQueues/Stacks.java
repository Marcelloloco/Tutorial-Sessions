package StacksNQueues;

public class Stacks {
	
	private Node top;
	
	public Stacks() {}
	
	public boolean isEmpty() {
		if(top == null) {
			return true;
		}else {
			return false;
		}
	}
	
	public int peek() {
		if(!isEmpty()) return top.data;
		else return -1;
		
	}
	
	public void push(int data) {
		Node node = new Node(data);
		node.setNext(top);
		this.top = node;
	}
	
	public int pop() {
		int value = top.data;
		top = top.next;
		return value;
	}
	
	public class Node{
		public Node next;
		public int data;
		
		public Node(int data) {
			this.data = data;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
	}
}
