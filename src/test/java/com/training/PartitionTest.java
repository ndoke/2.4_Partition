package com.training;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class PartitionTest {
    private LinkedListNode node;

    @BeforeClass
    public void setUp() {
        node = new LinkedListNode(10);
        initializeNode();
    }

    private void initializeNode() {
        LinkedListNode prev = node;
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int bound = nums.length;
        int swapperIndex = nums.length - 1;
        while (bound > 0) {
            // choose one random integer from the array
            Random r = new Random();
            int index = r.nextInt(bound);

            // add it to linked list
            LinkedListNode curr = new LinkedListNode(nums[index]);
            prev.next = curr;
            prev = prev.next;

            // swap it with the last integer
            int temp = nums[index];
            nums[index] = nums[swapperIndex];
            nums[swapperIndex] = temp;

            // choose next one from start to end minus one
            bound--;
            swapperIndex--;
        }
    }

    @Test
    public void deleteNode() {
        Partition partition = new Partition();
        System.out.println(node);
        LinkedListNode resultOfFour = partition.createPartitionFourLists(node, 5);
        System.out.println(resultOfFour);
        LinkedListNode resultOfTwo = partition.createPartitionTwoLists(resultOfFour, 7);
        System.out.println(resultOfTwo);
    }
}
