package com.zhouzf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Zhaofeng Zhou
 * @date 2021/9/15/015 14:19
 */
@ExtendWith(MockitoExtension.class)
public class MyArrayListTest {

    @Test
    void createMyArrayListTest() {
        MyArrayList emptyList = new MyArrayList();
        Assertions.assertTrue(emptyList.isEmpty());
        Assertions.assertEquals(0, emptyList.size());

        MyArrayList listWithData = new MyArrayList(15);
        Assertions.assertTrue(listWithData.isEmpty());
        Assertions.assertEquals(0, listWithData.size());
    }

    @Test
    void createMyArrayListThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new MyArrayList(-1));
    }

    @Test
    void testAddAndGet() {
        MyArrayList listWithData = new MyArrayList(2);
        for (int i = 0; i < 5; i++) {
            listWithData.add(i);
        }
        Assertions.assertEquals(5, listWithData.size());
        for (int i = 5; i < 10; i++) {
            listWithData.add(i);
        }
        Assertions.assertEquals(10, listWithData.size());

        for (int i = 0; i < 10; i++) {
            Assertions.assertEquals(i, listWithData.get(i));
        }

    }

    @Test
    void testIsEmpty() {
        MyArrayList myArrayList = new MyArrayList();
        Assertions.assertTrue(myArrayList.isEmpty());
        myArrayList.add(12);
        Assertions.assertFalse(myArrayList.isEmpty());
        myArrayList.remove(new Integer(12));
        Assertions.assertTrue(myArrayList.isEmpty());
    }

    @Test
    void testSetElement() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(12);
        myArrayList.add(13);

        Assertions.assertEquals(12, myArrayList.set(0, 10));
        Assertions.assertEquals(10, myArrayList.get(0));
        Assertions.assertEquals(13, myArrayList.get(1));
    }

    @Test
    void testGet() {
        MyArrayList listWithData = new MyArrayList(2);
        listWithData.add("132456");
        listWithData.add(888);
        listWithData.add("wszzh");
        Assertions.assertEquals("wszzh", listWithData.get(2));
        Assertions.assertEquals(888, listWithData.get(1));
        Assertions.assertEquals("132456", listWithData.get(0));
    }

    @Test
    void testGetThrowIndexOutOfBound() {
        MyArrayList listWithData = new MyArrayList(2);
        listWithData.add("132456");
        listWithData.add(888);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> listWithData.get(3));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> listWithData.get(-1));
    }

    @Test
    void testSize() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(123);
        Assertions.assertEquals(1, myArrayList.size());
        myArrayList.add("456");
        myArrayList.add(null);
        Assertions.assertEquals(3, myArrayList.size());
    }

    @Test
    void testIndexOf() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(123);
        myArrayList.add("456");
        myArrayList.add(null);

        Assertions.assertTrue(myArrayList.indexOf(123) == 0);
        Assertions.assertTrue(myArrayList.indexOf("456") == 1);
        Assertions.assertTrue(myArrayList.indexOf(null) == 2);
        Assertions.assertTrue(myArrayList.indexOf(45648) == -1);
    }

    @Test
    void testRemove() {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(123);
        myArrayList.add("456");

        myArrayList.remove(new Integer(123));
        Assertions.assertFalse(myArrayList.isEmpty());
        Assertions.assertEquals(1, myArrayList.size());
        myArrayList.add("789");
        myArrayList.remove(0);
        Assertions.assertEquals("789", myArrayList.get(0));
        myArrayList.remove("789");
        Assertions.assertTrue(myArrayList.isEmpty());

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.remove(1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.remove(-1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.remove(0));
    }
}
