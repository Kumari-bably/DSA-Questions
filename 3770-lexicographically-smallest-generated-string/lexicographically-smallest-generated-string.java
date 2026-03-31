import java.util.*;

public class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int L = n + m - 1;

        char[] word = new char[L];
        Arrays.fill(word, '?');

        // Step 1: Apply 'T' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] == '?' || word[i + j] == str2.charAt(j)) {
                        word[i + j] = str2.charAt(j);
                    } else {
                        return "";
                    }
                }
            }
        }

        // Step 2: Fill remaining '?' with 'a'
        for (int i = 0; i < L; i++) {
            if (word[i] == '?') word[i] = 'a';
        }

        // Step 3: Fix 'F' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {

                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    boolean fixed = false;

                    // try breaking from rightmost
                    for (int j = m - 1; j >= 0 && !fixed; j--) {
                        int pos = i + j;

                        char original = word[pos];

                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == original) continue;

                            word[pos] = c;

                            // check all affected 'T'
                            boolean valid = true;
                            for (int k = Math.max(0, pos - m + 1); k <= Math.min(n - 1, pos); k++) {
                                if (str1.charAt(k) == 'T') {
                                    for (int x = 0; x < m; x++) {
                                        if (word[k + x] != str2.charAt(x)) {
                                            valid = false;
                                            break;
                                        }
                                    }
                                    if (!valid) break;
                                }
                            }

                            if (valid) {
                                fixed = true;
                                break;
                            }
                        }

                        if (!fixed) word[pos] = original;
                    }

                    if (!fixed) return "";
                }
            }
        }

        return new String(word);
    }
}