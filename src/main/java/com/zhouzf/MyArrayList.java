package com.zhouzf;

/**
 * @author Zhaofeng Zhou
 * @date 2021/9/15/015 14:18
 */
public class MyArrayList {

    private static final Object[] EMPTY_ELEMENT_DATA = {};

    private static final int DEFAULT_CAPACITY = 10;

    private Object[] elementData;
    private int size;
    private int capacity;

    public MyArrayList() {
        this(0);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.capacity = initialCapacity;
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENT_DATA;
        } else {
            throw new IllegalArgumentException("Illegal argument capacity: " + initialCapacity);
        }
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean add(Object obj) {
        // 判断是否空数组
        if (elementData.length == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        }
        // 判断数组是否已经满了，满了就对数组进行扩容操作
        if (size >= capacity) {
            resize();
        }

        elementData[size++] = obj;
        return true;
    }

    // 扩容操作，将新数组容量扩充为原来的两倍
    private void resize() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;
        Object[] newElementData = new Object[newCapacity];

        // 将旧数组的数据，复制到新数组中
        System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
        elementData = newElementData;
        capacity = newCapacity;
    }


    public void add(int index, Object obj) {
        // 判断传入的索引是否合法
        rangeCheck(index);

        // 判断是否空数组
        if (elementData.length == 0) {
            elementData = new Object[DEFAULT_CAPACITY];
        }
        // 判断数组是否已经满了，满了就对数组进行扩容操作
        if (size == capacity) {
            resize();
        }
        elementData[index] = obj;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException(String.format("The index is out of bounds, index: %s size: %s", index, capacity));
        }
    }

    public Object remove(int index) {
        return null;
    }

    public boolean remove(Object obj) {
        return false;
    }

    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    public Object set(int index, Object obj) {
        rangeCheck(index);
        Object oldValue = elementData[index];
        elementData[index] = obj;
        return oldValue;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (obj.equals(elementData[i])) {
                    return i;
                }
            }

        }
        return -1;
    }
}
