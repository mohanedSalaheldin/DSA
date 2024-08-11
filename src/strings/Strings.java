package strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Strings {

    public static String removeOuterParentheses(String s) {
        int count = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                if (count>0){
                    res+= cur;
                }
                count++;
            }else {
                count--;
                if (count>0){
                    res+= cur;
                }
            }
        }
        return  res;
    }
    public static int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int distance =Integer.MIN_VALUE;
        boolean found  = false;
        for (int i = 0; i < n; i++) {
            if (target.equals(words[i])){
                found = true;
                int fword = (i-startIndex+n)%n;
                int bword = (startIndex-1+n)%n;
                distance = Math.min(distance, Math.min(fword, bword));
            }
        }
        return found ? distance : -1;
    }

    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] arr = new int[n];
        if (k==0){
            return  arr;
        }else if (k>0){
            for (int i = 0 ; i < n; i++) {
                int encode = 0;
                for (int j = 1; j < k+1; j++) {
                    encode+=code[(i + j) % n];
                }
                arr[i] = encode;
            }
        }else {
            for (int i = 0 ; i < n; i++) {
                k = Math.abs(k);
                int encode = 0;
                for (int j = 1; j < k+1; j++) {
                    encode+= code[(i - j + n) % n];
                }
                arr[i] = encode;
            }
        }
        return arr;
    }
    public static String reverseWords(String s) {

        String[] words = s.trim().split(" ");
//        for (int i = 0; i < words.length; i++) {
//            System.out.println(words[i]);
//        }
        int n = words.length;
//        System.out.println(n);
        StringBuilder sBuilder = new StringBuilder();
        for (int i = n-1; i >=0 ; i--) {
            if (words[i] != null && !words[i].trim().isEmpty()) {
                sBuilder.append(" ").append(words[i]);
            }
        }
        s = sBuilder.toString();
        return  s.trim();

    }

    public static String largestOddNumber(String num) {
        for(int i = num.length()-1; i >=0; i--) {
            if (Character.getNumericValue(num.charAt(i))%2 ==1) {
                return   num.substring(0, i+1);
            }
        }
        return "";
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i)!= last.charAt(i)){
                return res.toString();
            }
            res.append(first.charAt(i));
        }
        return  res.toString();
    }
    public static int missingInteger(int[] nums) {
        int n = nums.length;
        // find the sum of the sequence
        int prev = 0;
        int sum = nums[prev];
        for (int i = 1; i < n; i++) {
            if (nums[prev]+1 == nums[i]){
                sum+=nums[i];
            }else {
                break;
            }
            prev++;
        }
        System.out.println(prev);
        System.out.println(sum);
        //search for the missing form prev + 1
        int missedMin = sum;
        Arrays.sort(nums, prev+1, n);
        for (int i = prev+1 ; i < n; i++) {
            if (nums[i] == missedMin){
                missedMin++;
            }
        }
        System.out.println(missedMin);
        if (sum == nums[0]) return sum+1;
        return missedMin;

    }

    public static boolean rotateString(String s, String goal) {
        int n = s.length();
        StringBuilder res = new StringBuilder(s);
        for (int i = 1; i < n; i++) {
            char begin = res.charAt(0);
            String temp = res.substring(1,n);
            res.replace(0,n-1, temp);
            res.deleteCharAt(n-1);
            res.append(begin);
            if (goal.equals(res.toString())) {
                return true;
            }
        }
        return false;
    }

    public static String frequencySort(String s) {
        int n = s.length();
        Map<Character, Integer> freqs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freqs.put(s.charAt(i), freqs.getOrDefault(s.charAt(i), 0)+1 );
        }
        freqs.keySet();
        System.out.println(freqs);
        return "";
    }
    public static void main(String[] args) {
        String s = "(()())(())";
        int[] arr = {1,3, 2,3,2,5};
//        int[] arr = {3,4,5,1,12,14,13};
        System.out.println(frequencySort("tree"));
    }
}
