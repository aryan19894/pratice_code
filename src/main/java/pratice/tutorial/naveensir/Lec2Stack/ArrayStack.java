package pratice.tutorial.naveensir.Lec2Stack;

import pratice.tutorial.naveensir.Lec2Stack.exception.StackEmptyException;
import pratice.tutorial.naveensir.Lec2Stack.exception.StackFullException;

public class ArrayStack implements Stack {
	private static final int CAPACITY = 1024;
	private int N; // max capcity of Stack
	private Object[] S;
	int t = -1;

	public ArrayStack() {
		this(CAPACITY);
	}

	public ArrayStack(int capacity) {
		N = capacity;
		S = new Object[N];
	}

	@Override
	public int size() {
		return t + 1;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return t == -1;
	}

	@Override
	public Object top() throws StackEmptyException {
		if (isEmpty())
			throw new StackEmptyException("Stack Underflow");
		return S[t];
	}

	@Override
	public void push(Object ele) {
		if (size() == N)
			try {
				throw new StackFullException("Stack Overflow");
			} catch (StackFullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		S[++t] = ele;
	}

	@Override
	public Object pop() throws StackEmptyException {
		if (isEmpty())
			throw new StackEmptyException("Stack Underflow");
		Object elem = S[t];
		S[t--] = null;
		return elem;
	}

}
