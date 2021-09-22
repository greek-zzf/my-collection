package com.zhouzf;

import java.util.NoSuchElementException;

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

    public E remove(int index) {
        checkElementIndex(index);
        return unLink(getNodeByIndex(index));
    }

    /**
     * 从链表中将传入的节点断开连接
     *
     * @param nodeByIndex 传入的节点
     * @return 断开节点的值
     */
    private E unLink(Node<E> nodeByIndex) {
        E element = nodeByIndex.element;
        Node<E> preNode = nodeByIndex.prev;
        Node<E> nextNode = nodeByIndex.next;

        if (preNode == null) {
            first = nextNode;
        } else {
            preNode.next = nextNode;
            nodeByIndex.prev = null;
        }

        if (nextNode == null) {
            last = preNode;
        } else {
            nextNode.prev = preNode;
            nodeByIndex.next = null;
        }
        nodeByIndex.element = null;
        size--;
        return element;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.element == null) {
                    unLink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.element)) {
                    unLink(x);
                    return true;
                }
            }
        }
        return false;
    }

    public E removeLast() {
        Node<E> lastNode = last;
        if (lastNode == null) {
            throw new NoSuchElementException();
        }
        return unLinkLast(lastNode);
    }

    private E unLinkLast(Node<E> lastNode) {
        Node<E> preNode = lastNode.prev;
        E element = lastNode.element;

        lastNode.prev = null;
        lastNode.element = null;
        last = preNode;

        if (preNode == null) {
            first = null;
        } else {
            preNode.next = null;
        }
        size--;
        return element;
    }

    public E removeFirst() {
        Node<E> firstNode = first;
        if (firstNode == null) {
            throw new NoSuchElementException();
        }
        return unLinkFirst(firstNode);
    }

    private E unLinkFirst(Node<E> firstNode) {
        Node<E> nextNode = firstNode.next;
        E element = firstNode.element;

        firstNode.element = null;
        firstNode.next = null;
        first = nextNode;

        if (nextNode == null) {
            last = null;
        } else {
            nextNode.prev = null;
        }
        size--;
        return element;
    }

    public int indexOf(Object obj) {
        int index = 0;
        if (obj == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.element == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (obj.equals(x.element)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
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
