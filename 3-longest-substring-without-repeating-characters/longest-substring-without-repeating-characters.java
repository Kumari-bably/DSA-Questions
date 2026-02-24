class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[256];
        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1;
        }

        int maxLength = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (lastIndex[ch] >= start) {
                start = lastIndex[ch] + 1;
            }

            lastIndex[ch] = i;
            maxLength = Math.max(maxLength, i - start + 1);
        }

        return maxLength;
    }
}