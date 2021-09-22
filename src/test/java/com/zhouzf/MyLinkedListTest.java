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
    void addLastTest() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(2);

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

}
