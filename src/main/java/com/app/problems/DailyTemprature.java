package com.app.problems;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemprature {
    public static void main(String[] args) {
        int temp[] = {73,74,75,71,69,72,76,73};
        Arrays.stream(dailyTemperatures(temp))
                .forEach(System.out::println);
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int res[] = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int top = st.pop();
                res[top] = i - top;
            }
            st.push(i);
        }
        return res;
    }
}
