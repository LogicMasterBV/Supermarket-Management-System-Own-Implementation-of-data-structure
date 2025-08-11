// Custom implementation of a simple hash map
public class CustomHashMap<K, V> {
    // Default capacity for the hash map
    private static final int DEFAULT_CAPACITY = 16;

    // Load factor to determine when to resize the hash map
    private static final double LOAD_FACTOR = 0.75;

    // Array to store the hash map entries
    private Entry<K, V>[] table;

    // Current number of entries in the hash map
    private int size;

    // Default constructor with default capacity
    public CustomHashMap() {
        this(DEFAULT_CAPACITY);
    }

    // Constructor with a specified initial capacity
    public CustomHashMap(int capacity) {
        // Initialize the table with the specified capacity
        table = new Entry[capacity];
        // Initialize the size to 0
        size = 0;
    }

    // Method to insert a key-value pair into the hash map
    public void put(K key, V value) {
        // Check if the key is null (null keys are not allowed)
        if (key == null) {
            throw new IllegalArgumentException("Null keys not allowed");
        }

        // Calculate the hash code for the key
        int hash = hash(key);
        // Calculate the index in the table based on the hash code
        int index = hash % table.length;

        // Retrieve the entry at the calculated index
        Entry<K, V> entry = table[index];

        // Iterate through the linked list at the index
        while (entry != null) {
            // If the key already exists, update the value and return
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
            // Move to the next entry in the linked list
            entry = entry.getNext();
        }

        // If the key is not found, add a new entry to the beginning of the linked list
        Entry<K, V> newEntry = new Entry<>(key, value);
        newEntry.setNext(table[index]);
        table[index] = newEntry;
        size++;

        // Check if rehashing is needed
        if ((double) size / table.length > LOAD_FACTOR) {
            resize();
        }
    }

    // Method to retrieve the value associated with a given key
    public V get(K key) {
        // Check if the key is null (null keys are not allowed)
        if (key == null) {
            throw new IllegalArgumentException("Null keys not allowed");
        }

        // Calculate the hash code for the key
        int hash = hash(key);
        // Calculate the index in the table based on the hash code
        int index = hash % table.length;

        // Retrieve the entry at the calculated index
        Entry<K, V> entry = table[index];

        // Iterate through the linked list at the index
        while (entry != null) {
            // If the key is found, return the associated value
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
            // Move to the next entry in the linked list
            entry = entry.getNext();
        }

        // Return null if the key is not found
        return null;
    }

    // Method to remove the entry associated with a given key
    public V remove(K key) {
        // Check if the key is null (null keys are not allowed)
        if (key == null) {
            throw new IllegalArgumentException("Null keys not allowed");
        }

        // Calculate the hash code for the key
        int hash = hash(key);
        // Calculate the index in the table based on the hash code
        int index = hash % table.length;

        // Initialize variables to keep track of the current and previous entries
        Entry<K, V> current = table[index];
        Entry<K, V> prev = null;

        // Iterate through the linked list at the index
        while (current != null) {
            // If the key is found, remove the entry and return the associated value
            if (current.getKey().equals(key)) {
                if (prev == null) {
                    // Remove the first entry in the list
                    table[index] = current.getNext();
                } else {
                    // Remove from the middle or end of the list
                    prev.setNext(current.getNext());
                }
                size--;
                return current.getValue();
            }
            // Move to the next entry in the linked list
            prev = current;
            current = current.getNext();
        }

        // Return null if the key is not found
        return null;
    }

    // Method to get the current size of the hash map
    public int size() {
        return size;
    }
    // Method to retrieve all values in the hash map
    public CustomArrayList<V> values() {
        // Create a custom list to store the values
        CustomArrayList<V> valuesList = new CustomArrayList<>();

        // Iterate through the array of entries in the hash map
        for (Entry<K, V> entry : table) {
            // Iterate through the linked list at each array index
            while (entry != null) {
                // Add the value of the current entry to the custom list
                valuesList.add(entry.getValue());
                // Move to the next entry in the linked list
                entry = entry.getNext();
            }
        }

        // Return the custom list containing all values
        return valuesList;
    }


    // Method to resize the hash map when the load factor is exceeded
    private void resize() {
        // Double the capacity of the hash map
        int newCapacity = table.length * 2;
        // Create a new table with the updated capacity
        Entry<K, V>[] newTable = new Entry[newCapacity];

        // Iterate through the existing entries and rehash them into the new table
        for (Entry<K, V> entry : table) {
            while (entry != null) {
                // Save the next entry in the original table
                Entry<K, V> next = entry.getNext();
                // Calculate the new index in the resized table
                int index = hash(entry.getKey()) % newCapacity;
                // Update the next reference of the current entry to point to the new table
                entry.setNext(newTable[index]);
                // Set the current entry as the new head of the linked list at the new index
                newTable[index] = entry;
                // Move to the next entry in the original table
                entry = next;
            }
        }

        // Update the hash map's table reference to the resized table
        table = newTable;
    }

    // Method to calculate the hash code for a given key
    private int hash(K key) {
        return key.hashCode();
    }

    // Entry class represents key-value pairs in the map
    private static class Entry<K, V> {
        // Key of the entry
        private final K key;

        // Value associated with the key
        private V value;

        // Reference to the next entry in the linked list
        private Entry<K, V> next;

        // Constructor to initialize an entry with a key and value
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        // Method to get the key of the entry
        public K getKey() {
            return key;
        }

        // Method to get the value of the entry
        public V getValue() {
            return value;
        }

        // Method to set the value of the entry
        public void setValue(V value) {
            this.value = value;
        }

        // Method to get the next entry in the linked list
        public Entry<K, V> getNext() {
            return next;
        }

        // Method to set the next entry in the linked list
        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }
}