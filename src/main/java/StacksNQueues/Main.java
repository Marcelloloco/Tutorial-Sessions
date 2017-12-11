package StacksNQueues;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stacks stack = new Stacks();
		
		stack.push(5);
		stack.push(8);
		stack.pop();
		stack.pop();
		
		System.out.println(stack.peek());
	}

}
