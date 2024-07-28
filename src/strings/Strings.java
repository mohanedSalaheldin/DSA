package strings;

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
    public static void main(String[] args) {
        String s = "(()())(())";
        String[] arr = {"hello","i","am","leetcode","hello"};
        System.out.println(largestOddNumber("38"));
    }
}
