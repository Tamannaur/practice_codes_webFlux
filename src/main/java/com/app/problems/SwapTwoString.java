package com.app.problems;

public class SwapTwoString {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "hi";
        swap(s1,s2);

        int n1 = 2, n2 = 3;
        swapNum(n1,n2);

    }
    public static void swapNum(int num1,int num2){
        num2 = num2-num1;
        num1 = num2+num1;
        num2 = num1-num2;
        System.out.println(num1);
        System.out.println(num2);
    }
    public static void swap(String s1, String s2){
        s1 = s1.concat(s2);

        s2 = s1.substring(0, s1.length()-s2.length());
        s1 = s1.substring(s2.length());

        System.out.println(s1);
        System.out.println(s2);
    }
}
