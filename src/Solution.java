import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        String[] array = {"we","say",":","yes"};
//        String[] array = {"we","say",":","yes"};
        String[] array = {"we","say",":","yes","!@#$%^&*()"};
//        String[] array = {""};


        // Convert array to ArrayList
        List<String> arrayList = new ArrayList<String>(Arrays.asList(array));

       String en = encode(arrayList);
        decode(en);
    }

    public static String encode(List<String> strs) {
        String encodedString = "";
        for (String element: strs) {
            int wordSize = element=="" ? 0: element.length();
            encodedString += wordSize+ "_"+ element;
        }
        System.out.println(encodedString);

        return encodedString;
    }

    public static List<String> decode(String str) {
        List<String> decodedStrs = new ArrayList<String>();
        int i = 0;
      while (i < str.length() ){
          int j = i;
          while (str.charAt(j)!='_'){
              j++;
          }
          int length = Integer.valueOf(str.substring(i, j));
          System.out.println(length);
          i = j+1+ length;
          decodedStrs.add(str.substring(j+1,i));

      }

        System.out.println(decodedStrs);
        return  decodedStrs;
    }
}
