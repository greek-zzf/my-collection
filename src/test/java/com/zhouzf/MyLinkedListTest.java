package com.zhouzf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * @author Zhaofeng Zhou
 * @date 21/9/2021 下午9:46
 */
@ExtendWith(MockitoExtension.class)
class MyLinkedListTest {

    @Test
    void smokeTest() {
        System.out.println("smoke test");
    }

    @Test
    void testSize() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i);
        }
        Assertions.assertEquals(10, linkedList.size());
        linkedList.remove(0);
        Assertions.assertEquals(9, linkedList.size());
    }


    @Test
    void createMyLinkedListTest() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        Assertions.assertEquals(1, linkedList.get(0));
    }


    @Test
    void addLastTest() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);

        Assertions.assertTrue(linkedList.add(2));
        Assertions.assertEquals(1, linkedList.get(0));
        Assertions.assertEquals(2, linkedList.get(1));
        Assertions.assertEquals(2, linkedList.get(2));
    }

    @Test
    void addBeforeTest() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(2, 45);

        Assertions.assertEquals(45, linkedList.get(2));

        linkedList.add(2, 12);
        Assertions.assertEquals(12, linkedList.get(2));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(5, 12));

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(21);
        myLinkedList.add(0, 10);
        Assertions.assertEquals(2, myLinkedList.size());
        Assertions.assertEquals(10, myLinkedList.get(0));
    }

    @Test
    void testGet() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(999);
        myLinkedList.add(213);
        myLinkedList.add(456);

        Assertions.assertEquals(999, myLinkedList.get(0));
        Assertions.assertEquals(213, myLinkedList.get(1));
        Assertions.assertEquals(456, myLinkedList.get(2));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.get(3));
    }

    @Test
    void testRemoveObj() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(111);
        myLinkedList.add(222);
        myLinkedList.add(333);

        // 正常删除测试
        Assertions.assertEquals(3, myLinkedList.size());
        Assertions.assertTrue(myLinkedList.remove(new Integer(111)));
        Assertions.assertTrue(myLinkedList.remove(new Integer(333)));
        Assertions.assertEquals(1, myLinkedList.size());

        // 测试删除的数据为 null
        Assertions.assertFalse(myLinkedList.remove(null));
        myLinkedList.add(null);
        Assertions.assertTrue(myLinkedList.remove(null));

        // 测试删除的数据不存在
        Assertions.assertFalse(myLinkedList.remove(new Integer(456)));
    }

    @Test
    void testRemoveIndex() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(111);
        myLinkedList.add(222);
        myLinkedList.add(333);

        // 正常删除测试
        Assertions.assertEquals(111, myLinkedList.remove(0));
        Assertions.assertEquals(333, myLinkedList.remove(1));
        // 索引不存在测试
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.remove(1));
    }

    @Test
    void testRemoveLast() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(999);
        myLinkedList.add(213);
        myLinkedList.add(456);

        Assertions.assertEquals(456, myLinkedList.removeLast());
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.get(2));
        Assertions.assertEquals(2, myLinkedList.size());
        Assertions.assertEquals(999, myLinkedList.get(0));
        Assertions.assertEquals(213, myLinkedList.get(1));

    }

    @Test
    void testRemoveFirst() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(12);
        myLinkedList.add(13);
        myLinkedList.add(14);

        Assertions.assertEquals(12, myLinkedList.removeFirst());
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myLinkedList.get(2));
        Assertions.assertEquals(2, myLinkedList.size());
        Assertions.assertEquals(13, myLinkedList.get(0));
        Assertions.assertEquals(14, myLinkedList.get(1));

    }

    @Test
    void testIndexOf() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(12);
        myLinkedList.add(13);
        myLinkedList.add(14);

        Assertions.assertEquals(0, myLinkedList.indexOf(12));
        Assertions.assertEquals(1, myLinkedList.indexOf(13));
        Assertions.assertEquals(2, myLinkedList.indexOf(14));
        Assertions.assertEquals(-1, myLinkedList.indexOf(null));
        Assertions.assertEquals(-1, myLinkedList.indexOf(20));
    }


}
