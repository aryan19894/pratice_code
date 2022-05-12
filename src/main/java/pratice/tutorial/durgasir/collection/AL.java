package pratice.tutorial.durgasir.collection;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public class AL<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {

	private static final int MAX_ARRAY_SIZE = 2147483639;
	private static final int DEFAULT_CAPACITY = 10;
	private static final Object[] EMPTY_ELEDATA = {};
	private static final Object[] DEFAULTCAPACITY_EMPTY_ELEDATA = {};

	transient Object[] eleData;

	private int size;

	// constructor
	public AL() {
		this.eleData = DEFAULTCAPACITY_EMPTY_ELEDATA;
	}

	public AL(int initialCapacity) {
		if (initialCapacity > 0)
			this.eleData = new Object[initialCapacity];
		else if (initialCapacity == 0)
			this.eleData = EMPTY_ELEDATA;
		else
			throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
	}

	public AL(Collection<? extends E> c) {
		eleData = c.toArray();
		size = eleData.length;
		if (eleData.getClass() != Object[].class) {
			eleData = Arrays.copyOf(eleData, size, Object[].class);
		}
	}

	// public methods
	public boolean add(E e) {
		ensureCapacityInternal(size + 1);
		eleData[size++] = e;
		return true;
	}

	private void ensureCapacityInternal(int minCapacity) {
		if (eleData == DEFAULTCAPACITY_EMPTY_ELEDATA)
			minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
		ensureExplicitCapacity(minCapacity);
	}

	private void ensureExplicitCapacity(int minCapacity) {
		modCount++;
		if (minCapacity - eleData.length > 0)
			grow(minCapacity);
	}

	private void grow(int minCap) {
		int oldCap = eleData.length;
		int newCap = oldCap + (oldCap >> 1);
		if (newCap - minCap < 0)
			newCap = minCap;
		else
			newCap = hugeCapacity(minCap);
		eleData = Arrays.copyOf(eleData, newCap);
	}

	private static int hugeCapacity(int minCapacity) {
		if (minCapacity < 0)
			throw new OutOfMemoryError();
		return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
	}

	@SuppressWarnings("unchecked")
	E eleData(int index) {
		return (E) eleData[index];
	}

	@Override
	public E get(int index) {
		return eleData(index);
	}

	@Override
	public int size() {
		return size;
	}

}
