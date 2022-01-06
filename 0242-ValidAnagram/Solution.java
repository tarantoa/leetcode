class Solution {
   public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        
        int[] letterFrequencies = new int[26];
        for (int index = 0; index < s.length(); ++index) {
            ++letterFrequencies[s.charAt(index) - 'a'];
            --letterFrequencies[t.charAt(index) - 'a'];
        }
        for (int freq : letterFrequencies) {
            if (freq != 0) {
                return false;
            }
        }
        
        return true;
    } 
}