package pl.szczesnaj.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class LinkedListTest {

    @Test
    void sum_returnTwenty() {
        LinkedList list = new LinkedList();
        LinkedList.ListNode head = list.new ListNode(7);
        head.next = list.new ListNode(5);
        head.next.next = list.new ListNode(3);
        head.next.next.next = list.new ListNode(4);
        head.next.next.next.next = list.new ListNode(1);
        int sum = LinkedList.sum(head);

        Assertions.assertEquals(20, sum);
    }
}
