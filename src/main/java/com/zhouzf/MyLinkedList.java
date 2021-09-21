package com.zhouzf;

/**
 * @author Zhaofeng Zhou
 * @date 21/9/2021 下午8:59
 */
public class MyLinkedList<E> {
    private int size;
    private Node first;
    private Node last;

    public boolean add(E element) {
        Node lastTag = last;
        Node newNode = new Node(lastTag, null, element);
        last = newNode;
        return true;
    }

    public void add(int index, E element) {
        rangeCheck(index);
        if (index == size) {
            addLast(element);
        } else {
            addBefore(index, element);
        }
    }

    private void addBefore(int index, E element) {
        Node indexNode = getNodeByIndex(index);
        Node preNode = indexNode.prev;
        Node newNode = new Node(preNode, indexNode, element);
        preNode.next = newNode;
        indexNode.prev = newNode;
        size++;
    }

    private void addLast(E element) {
        add(element);
    }

    private Node getNodeByIndex(int index) {
        // 遍历获取坐标
        if (index < size / 2) {
            Node firstNode = first;
            for (int i = 0; i < index; i++) {

            }
        } else {
            Node lastNode = last;
            for (int i = size - 1; i > index; i--) {
                lastNode = lastNode.next;
            }
        }
        return null;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(String.format("The index is out of bounds, index: %s size: %s", index, size));
        }
    }


    static class Node<E> {
        Node prev;
        Node next;
        E element;

        Node(Node prev, Node next, E element) {
            this.prev = prev;
            this.next = next;
            this.element = element;
        }
    }
}
