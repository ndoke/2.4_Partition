package com.training;

/**
 * {@link Partition} has a methods to create partition in a
 * Linked list.
 *
 * {@link Partition#createPartitionFourLists(LinkedListNode, int)}
 * creates partition in the list around a given number.
 *
 * @author Nachiket Doke
 * @since 1.0
 */
public class Partition {
    /**
     * Creates a partition around a given number using four
     * linked lists.
     *
     * @param n LinkedListNode which is to be partitioned
     * @param x Number around which partition is to be made
     */
    public LinkedListNode createPartitionFourLists(LinkedListNode n, int x) {
        LinkedListNode beforeStart = null;
        LinkedListNode beforeEnd = null;
        LinkedListNode afterStart = null;
        LinkedListNode afterEnd = null;

        while(n != null) {
            LinkedListNode next = n.next;
            n.next = null;
            if (n.data < x) {
                if (beforeStart == null) {
                    beforeStart = n;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = n;
                    beforeEnd = n;
                }
            } else {
                if (afterStart == null) {
                    afterStart = n;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = n;
                    afterEnd = n;
                }
            }
            n = next;
        }

        if (beforeStart == null) {
            return afterStart;
        }

        beforeEnd.next = afterStart;
        return beforeStart;
    }

    /**
     * Creates a partition around a given number using two
     * linked lists.
     *
     * @param n LinkedListNode which is to be partitioned
     * @param x Number around which partition is to be made
     */
    public LinkedListNode createPartitionTwoLists(LinkedListNode n, int x) {
        LinkedListNode head = n;
        LinkedListNode tail = n;

        while (n != null) {
            LinkedListNode next = n.next;
            if (n.data < x) {
                n.next = head;
                head = n;
            } else {
                tail.next = n;
                tail = n;
            }
            n = next;
        }
        tail.next = null;

        return head;
    }
}
