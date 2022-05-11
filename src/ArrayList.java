import java.util.Arrays;

public class ArrayList<T> implements List<T> {

	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	private T[] data;
	private int size;

	/**
	 * Constructs an ArrayList using the default capacity
	 */
	public ArrayList() {
		this(DEFAULT_INITIAL_CAPACITY);
	}

	/**
	 * Constructs an ArrayList with an 'initialCapacity'
	 * 
	 * If 'initalCapacity' is non-positive use the default capacity
	 * 
	 * @param initialCapacity
	 */
	public ArrayList(int initialCapacity) {
		initialCapacity = initialCapacity > 0 ? initialCapacity : DEFAULT_INITIAL_CAPACITY;
		data = (T[]) new Object[initialCapacity];
		size = 0;
	}

	@Override
	public void add(T item, int index) {
		if (index < 0 || index > size) return;
		if (size == data.length) {
			resize();
		}
		for (int i = size - 1; i >= index; i--) {
			data[i+1] = data[i];
		}
		data[index] = item;
		size++;
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++) {
			data[i] = null;
		}
		size = 0;
	}

	@Override
	public boolean contains(Object item) {
		return indexOf(item) != -1;
	}

	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		return data[index];
	}

	@Override
	public int indexOf(Object item) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	private void resize() {
		T[] temp = (T[]) new Object[data.length * 2];
		for (int i = 0; i < size; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}

	public String toString() {
		String result = "[";
		for (int i = 0; i < size; i++) {
			result += data[i] + (i == size - 1 ? "" : ", ");
		}
		return result + "]";
	}
}
