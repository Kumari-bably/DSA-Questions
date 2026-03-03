import java.util.*;

class Solution {
    public static int countPairs(String[] arr) {
        int n = arr.length;
        int len = arr[0].length();
        int totalPairs = 0;
        
        for (int i = 0; i < len; i++) {
            Map<String, Integer> map = new HashMap<>();
            
            for (String s : arr) {
                String modified = s.substring(0, i) + s.substring(i + 1);
                
                map.put(modified, map.getOrDefault(modified, 0) + 1);
            }
            
            for (int freq : map.values()) {
                if (freq > 1) {
                    totalPairs += freq * (freq - 1) / 2;
                }
            }
        }
        
        return totalPairs;
    }
}