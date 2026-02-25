class Solution {

    public int minParentheses(String S) {

        int open = 0;        
        int insertions = 0;  
        for (int i = 0; i < S.length(); i++) {

            char ch = S.charAt(i);

            if (ch == '(') {
                open++;
            } else { // ')'

                if (open > 0) {
                    open--;      
                } else {
                    insertions++; 
                }
            }
        }

        return insertions + open;
    }
}
