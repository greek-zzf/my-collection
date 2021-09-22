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
        // 考虑特殊情况（当链表为空时，添加一条数据）
        if (lastTag == null) {
            first = newNode;
        } else {
            lastTag.next = newNode;
        }
        size++;
        return true;
    }

    public void add(int index, E element) {
        rangeCheckForAdd(index);
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

        if (preNode == null) {
            first = newNode;
        } else {
            preNode.next = newNode;
        }
        indexNode.prev = newNode;
        size++;
    }

    private void addLast(E element) {
        add(element);
    }

    private Node<E> getNodeByIndex(int index) {
        // 遍历获取坐标
        if (index < size / 2) {
            Node<E> firstNode = first;
            for (int i = 0; i < index; i++) {
                firstNode = firstNode.next;
            }
            return firstNode;
        } else {
            Node<E> lastNode = last;
            for (int i = size - 1; i > index; i--) {
                lastNode = lastNode.prev;
            }
            return lastNode;
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(String.format("The index is out of bounds, index: %s size: %s", index, size));
        }
    }

    public E get(int index) {
        checkElementIndex(index);
        return getNodeByIndex(index).element;
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format("The index is out of bounds, index: %s size: %s", index, size));
        }
    }

    public int size() {
        return size;
    }


    private static class Node<E> {
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
