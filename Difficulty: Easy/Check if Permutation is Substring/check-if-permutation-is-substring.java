class Solution {
    public boolean search(String txt, String pat) {

        int n = txt.length();
        int m = pat.length();

        if (m > n) return false;

        int[] patCount = new int[26];
        int[] windowCount = new int[26];
        for (int i = 0; i < m; i++) {
            patCount[pat.charAt(i) - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            windowCount[txt.charAt(i) - 'a']++;
        }

        if (matches(patCount, windowCount)) return true;
        for (int i = m; i < n; i++) {
            windowCount[txt.charAt(i) - 'a']++;      // add new char
            windowCount[txt.charAt(i - m) - 'a']--;  // remove old char

            if (matches(patCount, windowCount)) return true;
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}