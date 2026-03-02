import java.util.*;

class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                chars.add((char) (i + 'a'));
            }
        }

        Collections.sort(chars, (a, b) -> {
            if (freq[a - 'a'] == freq[b - 'a']) {
                return a - b;
            }
            return freq[a - 'a'] - freq[b - 'a'];
        });

        StringBuilder result = new StringBuilder();
        for (char ch : chars) {
            for (int i = 0; i < freq[ch - 'a']; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}