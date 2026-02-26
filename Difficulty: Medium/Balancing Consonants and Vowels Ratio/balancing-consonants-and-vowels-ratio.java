import java.util.*;

class Solution {

    public int countBalanced(String[] arr) {
        
        int n = arr.length;
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            int v = 0, c = 0;
            for (char ch : arr[i].toCharArray()) {
                if (isVowel(ch)) v++;
                else c++;
            }
            values[i] = v - c;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefix = 0;
        int count = 0;

        for (int val : values) {
            prefix += val;

            if (map.containsKey(prefix)) {
                count += map.get(prefix);
            }

            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        return count;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}