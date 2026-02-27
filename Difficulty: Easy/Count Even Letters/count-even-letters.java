class Solution {
    
    int count(String s) {
        
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        int evenCount = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0 && freq[i] % 2 == 0) {
                evenCount++;
            }
        }
        
        return evenCount;
    }
}