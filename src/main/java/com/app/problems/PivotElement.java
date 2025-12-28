package com.app.problems;

public class PivotElement {
    public static void main(String[] args) {
        int arr[] = {1,7,3,6,5,6};
        System.out.println(new PivotElement().pivotIndex(arr));
    }
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int count = 0;
        int left = 0, right = n-1;
        int lSum = 0, rSum = 0;
        while(left < right){
            count++;

            if(lSum < rSum){
                lSum += nums[left];
                left++;
            }else{
                rSum += nums[right];
                right--;
            }
            if(count == n-1 && lSum == rSum)return left;
        }
        return -1;
    }
}
