package com.app.problems;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequestElement {
    public static void main(String[] args) {
        int arr[] = {1,2,1,2,1,2,3,1,3,2};
        int k = 2;
        Arrays.stream(topKFrequent(arr,k)).forEach(System.out::println);
        Arrays.stream(topKFrequent1(arr,k)).forEach(System.out::println);
    }
    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(Comparator
                .comparing(Map.Entry<Integer,Integer>::getValue));

        for (Map.Entry<Integer, Integer> m: map.entrySet()){
            pq.offer(m);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = pq.poll().getKey();
        }
        return res;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        n = n-k;
        return Arrays.stream(nums)
                .boxed()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                ).entrySet()
                .stream()
                .sorted(Comparator.comparing(
                        Map.Entry<Integer,Long>::getValue).reversed()
                )
                .limit(k)
                .map(Map.Entry::getKey)
                .toList()
                .stream().mapToInt(Integer::intValue)
                .toArray();
    }
}
