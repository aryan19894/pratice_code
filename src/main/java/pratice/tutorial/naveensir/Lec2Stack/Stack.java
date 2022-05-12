package pratice.tutorial.naveensir.Lec2Stack;

import pratice.tutorial.naveensir.Lec2Stack.exception.StackEmptyException;

public interface Stack {
	public int size();

	public boolean isEmpty();

	public Object top() throws StackEmptyException;

	public void push(Object ele);

	public Object pop() throws StackEmptyException;

}
