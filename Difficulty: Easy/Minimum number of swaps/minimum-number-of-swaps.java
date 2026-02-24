class Solution {
    public int minSwaps(String s1, String s2) {
        int c01 = 0;
        int c10 = 0;

        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);

            if (a == '0' && b == '1') {
                c01++;
            } else if (a == '1' && b == '0') {
                c10++;
            }
        }

        if ((c01 + c10) % 2 != 0) {
            return -1;
        }

        return (c01 / 2) + (c10 / 2) + 2 * (c01 % 2);
    }
}