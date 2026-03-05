class Solution {

    public static String maxSubseq(String s, int k) {
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {

            while(sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) < c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            sb.append(c);
        }

        while(k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        return sb.toString();
    }
}