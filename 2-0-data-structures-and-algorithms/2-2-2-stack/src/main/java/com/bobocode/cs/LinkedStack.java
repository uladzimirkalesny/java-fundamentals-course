package com.bobocode.cs;

import com.bobocode.cs.exception.EmptyStackException;
import lombok.NonNull;

import java.util.stream.Stream;

/**
 * {@link LinkedStack} is a stack implementation that is based on singly linked generic nodes.
 * A node is implemented as inner static class {@link Node<T>}.
 *
 * @param <T> generic type parameter
 * @author Taras Boychuk
 * @author Serhii Hryhus
 */
public class LinkedStack<T> implements Stack<T> {

    private static class Node<T> {
        T element;
        Node<T> nextElement;

        private Node(T element) {
            this.element = element;
        }
    }

    /**
     * The latest Node into stack.
     */
    private Node<T> head;

    /**
     * The Stack size.
     */
    private int size;

    /**
     * This method creates a stack of provided elements
     *
     * @param elements elements to add
     * @param <T>      generic type
     * @return a new stack of elements that were passed as method parameters
     */
    public static <T> LinkedStack<T> of(T... elements) {
        LinkedStack<T> stack = new LinkedStack<>();
        Stream.of(elements).forEach(stack::push);

        return stack;
    }

    /**
     * The method pushes an element onto the top of this stack. This has exactly the same effect as:
     * addElement(item)
     *
     * @param element elements to add
     */
    @Override
    public void push(@NonNull T element) {
        Node<T> nodeCandidate = new Node<>(element);

        if (head != null) {
            nodeCandidate.nextElement = head;
        }

        head = nodeCandidate;
        size++;
    }

    /**
     * This method removes the object at the top of this stack
     * and returns that object as the value of this function.
     *
     * @return The object at the top of this stack
     * @throws EmptyStackException - if this stack is empty
     */
    @Override
    public T pop() {
        Node<T> headNode = this.head;
        if (headNode == null) {
            throw new EmptyStackException();
        } else {
            T element = headNode.element;
            this.head = headNode.nextElement;

            size--;
            return element;
        }
    }

    /**
     * Returns the number of elements in the stack
     *
     * @return number of elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if a stack is empty
     *
     * @return {@code true} if a stack is empty, {@code false} otherwise
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

}
