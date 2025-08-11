// CustomArrayList is a generic class that implements a simple dynamic array.
public class CustomArrayList<E> {
    // Default capacity for the array
    private static final int DEFAULT_CAPACITY = 10;

    // The array to store elements
    private Object[] array;

    // The current size of the array (number of elements)
    private int size;

    // Constructor initializes the array with the default capacity and sets size to 0.
    public CustomArrayList() {
        this.array = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    // Method to add an element to the array.
    public void add(E element) {
        // Check if the array is full, if so, resize it.
        if (size == array.length) {
            // Resize the array by doubling its capacity.
            int newCapacity = array.length * 2;
            Object[] newArray = new Object[newCapacity];

            // Copy elements from the old array to the new array.
            for (int i = 0; i < size; i++) {
                newArray[i] = array[i];
            }

            // Update the array reference to the new array.
            array = newArray;
        }

        // Add the new element to the array and increment the size.
        array[size++] = element;
    }

    // Method to retrieve an element at a specific index.
    public E get(int index) {
        // Check if the index is valid.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // Return the element at the specified index, casting it to type E.
        return (E) array[index];
    }

    // Method to get the current size of the array.
    public int size() {
        return size;
    }

    // Method to set an element at a specific index.
    public void set(int index, E element) {
        // Check if the index is valid.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        // Set the element at the specified index.
        array[index] = element;
    }
}
