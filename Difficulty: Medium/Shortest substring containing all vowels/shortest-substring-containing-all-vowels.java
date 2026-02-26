import java.util.*;

class Solution {

    public int substrWithVowels(String s1, String s2) {
        
        Set<Character> required = new HashSet<>();
        for(char ch : s1.toCharArray()) {
            required.add(ch);
        }

        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int formed = 0;
        int minLen = Integer.MAX_VALUE;

        for(int right = 0; right < s2.length(); right++) {

            char ch = s2.charAt(right);

            if(required.contains(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if(window.get(ch) == 1) {
                    formed++;
                }
            }

            while(formed == required.size()) {

                minLen = Math.min(minLen, right - left + 1);

                char leftChar = s2.charAt(left);

                if(required.contains(leftChar)) {
                    window.put(leftChar, window.get(leftChar) - 1);
                    if(window.get(leftChar) == 0) {
                        formed--;
                    }
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}
