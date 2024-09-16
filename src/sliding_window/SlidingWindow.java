package sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SlidingWindow {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        int left = 0;
        Map<Character, Integer> lastSeen = new HashMap<>();
        for (int right = 0; right < n ; right++) {
            char cur = s.charAt(right);
            if (lastSeen.containsKey(cur) && lastSeen.get(cur) >= left){
                left = lastSeen.get(cur) + 1;
            }
            lastSeen.put(cur, right);
            maxLen = Math.max(maxLen, right - left +1);
        }
        return maxLen;
    }


}
