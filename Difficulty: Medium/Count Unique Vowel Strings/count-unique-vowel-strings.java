class Solution {
    
    public int vowelCount(String s) {
        
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        char[] vowels = {'a','e','i','o','u'};
        
        int distinctVowels = 0;
        int product = 1;
        
        for (char v : vowels) {
            if (freq[v - 'a'] > 0) {
                distinctVowels++;
                product *= freq[v - 'a'];
            }
        }

        if (distinctVowels == 0) {
            return 0;
        }

        int fact = 1;
        for (int i = 1; i <= distinctVowels; i++) {
            fact *= i;
        }
        
        return product * fact;
    }
}