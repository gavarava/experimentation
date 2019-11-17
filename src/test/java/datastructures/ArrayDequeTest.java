package datastructures;

import com.InputFetcher;
import java.util.ArrayDeque;
import org.junit.jupiter.api.Test;

public class ArrayDequeTest {

    /**
     * The general-purpose implementations include LinkedList and ArrayDeque classes. The Deque interface supports
     * insertion, removal and retrieval of elements at both ends. The ArrayDeque class is the resizable array
     * implementation of the Deque interface, whereas the LinkedList class is the list implementation.
     *
     * The basic insertion, removal and retieval operations in the Deque interface addFirst, addLast, removeFirst,
     * removeLast, getFirst and getLast. The method addFirst adds an element at the head whereas addLast adds an element
     * at the tail of the Deque instance.
     *
     * The LinkedList implementation is more flexible than the ArrayDeque implementation. LinkedList implements all
     * optional list operations. null elements are allowed in the LinkedList implementation but not in the ArrayDeque
     * implementation.
     *
     * In terms of efficiency, ArrayDeque is more efficient than the LinkedList for add and remove operation at both
     * ends. The best operation in a LinkedList implementation is removing the current element during the iteration.
     * LinkedList implementations are not ideal structures to iterate.
     *
     * The LinkedList implementation consumes more memory than the ArrayDeque implementation
     */


    // *************** https://www.sergiy.ca/guide-to-selecting-appropriate-map-collection-in-java/
    // *************** *************** *************** *************** *************** ************

    @Test
    void test() {
        InputFetcher inputFetcher = new InputFetcher("delimited-data-file-small", ",");
        String[] inputDataAsArrayOfStrings = inputFetcher.getInputDataAsArrayOfStrings();

        ArrayDeque<String> arrayDeque = new ArrayDeque<>();

        for (String element : inputDataAsArrayOfStrings) {
            arrayDeque.addLast(element);
        }
    }


}
