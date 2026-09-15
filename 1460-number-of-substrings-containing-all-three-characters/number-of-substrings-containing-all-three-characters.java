public class Solution {
    public static int numberOfSubstrings(String s) {
        int[] last = {-1, -1, -1};
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;

            int minLast = Math.min(last[0], Math.min(last[1], last[2]));

            if (minLast != -1) {
                count += minLast + 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }
}