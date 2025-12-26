package com.app.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindKthLargestElement {
    public static void main(String[] args) {
        int arr[] = {1,4,2,6,8,3};
        int k = 4;
        System.out.println(new FindKthLargestElement().findKthLargest(arr, k));
        System.out.println(new FindKthLargestElement().findKthLargestMinHeap(arr, k));
    }
    public int findKthLargest(int[] nums, int k) {
        return Arrays.stream(nums).boxed()
                .sorted(Collections.reverseOrder())
                .skip(k-1)
                .findFirst()
                .orElse(-1);
    }
    public int findKthLargestMinHeap(int[] nums, int k) {
        //PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();

    }
}
