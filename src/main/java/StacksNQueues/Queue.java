package StacksNQueues;

public class Queue {
	
	Node top;
	
	public boolean isEmpty() {
		if(top == null) return true;
		else return false;
	}
	
	public int peek() {
		return top.data;
	}
	
	public class Node{
		public int data;
		public Node next;
		
		public Node(int data) {
			this.data = data;
		}
		
		public void setNext(Node next) {
			this.next = next;
		}
	}
}
