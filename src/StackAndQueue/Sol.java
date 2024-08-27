package StackAndQueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Sol {
    public static void main(String[] args) {

    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2*n-1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i%n]){
                st.pop();
            }
            if (i<n) {
                nge[i%n] = st.isEmpty() ?-1: st.peek();
            }
            st.push(nums[i%n]);
        }
        return  nge;
    }

    public int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n-1;
        int lMax = height[l];
        int rMax = height[r];
        int trapWater = 0;
        while (l<r){
            if (height[l] < height[r]) {
                l++;
                lMax = Math.max(lMax, height[l]);
                trapWater+= lMax - height[l];
            }else {
                r++;
                rMax = Math.max(rMax, height[r]);
                trapWater+= rMax - height[r];
            }
        }
        return trapWater;
    }


    private boolean isBulky(int length, int width, int height){
        int maxDimensions = 10000;
        long maxVolume = 1000000000;
        long volume = (long) length *width*height;
        if ( length >= maxDimensions ||  width >= maxDimensions || height >= maxDimensions || volume >= maxVolume)
            return true;
        return false;
    }
    private boolean isHeavy(int mass){
        return mass >= 100;
    }

    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isBulky = isBulky(length, width, height);
        boolean isHeavy = isHeavy(mass);
        if (isHeavy && isBulky) {
            return "Both";
        }else if (isHeavy) {
            return "Heavy";
        } else if (isBulky) {
            return "Bulky";
        }else
            return "Neither";
    }















    private boolean divisibleByThree(int num){
        return num%3 == 0;
    }
    private boolean divisibleByFive(int num){
        return num%5 == 0;
    }
    public List<String> fizzBuzz(int n) {
        List<String> sol = new ArrayList<>();
        for (int i = 1; i <=n ; i++) {
            String cur = "";
            if (divisibleByFive(i) && divisibleByThree(i)){
                cur = "FizzBuzz";
            }else  if (divisibleByThree(i)){
                cur = "Fizz";
            }else  if (divisibleByFive(i)){
                cur = "Buzz";
            }else
                cur = Integer.toString(i);
            sol.add(cur);
        }
        return sol;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//      [the Number in num1 , its greater]
        HashMap<Integer, Integer> greater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (Integer num: nums2) {
            while (!stack.isEmpty() && stack.peek() < num){
                greater.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = greater.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}


