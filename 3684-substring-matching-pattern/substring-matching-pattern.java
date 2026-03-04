class Solution {
    public boolean hasMatch(String s, String p) {
        int star = p.indexOf('*');
        String prefix = p.substring(0, star);
        String suffix = p.substring(star + 1);
        
        for (int i = 0; i <= s.length() - prefix.length(); i++) {
            if (s.substring(i, i + prefix.length()).equals(prefix)) {
                
                int restStart = i + prefix.length();
                
                if (suffix.length() == 0) {
                    return true;
                }
                
                for (int j = restStart; j <= s.length() - suffix.length(); j++) {
                    if (s.substring(j, j + suffix.length()).equals(suffix)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}