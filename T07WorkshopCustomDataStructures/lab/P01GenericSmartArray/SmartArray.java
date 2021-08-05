package T07WorkshopCustomDataStructures.lab.P01GenericSmartArray;

import java.util.function.Consumer;
import java.util.stream.IntStream;

public class SmartArray<T> {
    private static final int INITIAL_CAPACITY = 4;
    private Object[] elements;
    private int size;

    public SmartArray() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
    }

    public void add(T element) {
        if (size == elements.length) {
            elements = grow();
        }
        this.elements[size++] = element;
    }

    private Object[] grow() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        return newElements;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        ensureIndex(index);
        return (T) this.elements[index];
    }

    public int size() {
        return this.size;
    }

    public boolean contains(T element) {
        return IntStream.range(0, this.size).anyMatch(i -> elements[i].equals(element));
    }


    public void add(int index, T element) {
        ensureIndex(index);
        T lastElement = get(this.size - 1);
        shiftRight(index);
        this.elements[index] = element;
        add(lastElement);
    }

    public void forEach(Consumer<T> consumer) {
        IntStream.rangeClosed(0, this.size)
                .forEach(i -> consumer.accept(get(i)));
    }

    private void shiftRight(int index) {
        if (this.size - 1 - index >= 0) {
            System.arraycopy(this.elements, index, this.elements, index + 1, this.size - 1 - index);
        }
    }


    public T remove(int index) {
        T removedElement = get(index);
        shiftLeft(index);
        this.size--;
        if (this.size == 0) {
            this.elements = new Object[INITIAL_CAPACITY];
        }
        if (this.size < elements.length / 4 && elements.length > INITIAL_CAPACITY) {
            this.elements = shrink();
        }
        return removedElement;
    }

    private Object[] shrink() {
        Object[] newElements = new Object[elements.length / 2];
        System.arraycopy(elements, 0, newElements, 0, this.size);
        return newElements;
    }

    private void shiftLeft(int index) {
        if (this.size - 1 - index >= 0) {
            System.arraycopy(elements, index + 1, elements, index, this.size - 1 - index);
        }
        elements[this.size - 1] = 0;
    }

    private void ensureIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(index);
        }
    }
}
