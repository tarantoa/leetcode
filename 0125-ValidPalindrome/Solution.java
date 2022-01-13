class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        
        String processed = s
            .toLowerCase()
            .replaceAll("[^a-z0-9]", "");
        
        int left = 0;
        int right = processed.length() - 1;
        while (left < right) {
            if (processed.charAt(left) != processed.charAt(right)) {
                return false;
            }
            ++left;
            --right;
        }
        
        return true;
    }
}