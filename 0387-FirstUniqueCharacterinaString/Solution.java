class Solution {
    public int firstUniqChar(String s) {
        int[] charFrequencies = new int[26];
        for (char c : s.toCharArray()) {
            ++charFrequencies[c - 'a'];
        }
        
        for (int index = 0; index < s.length(); ++index) {
            if (charFrequencies[s.charAt(index) - 'a'] == 1) {
                return index;
            }
        }
        
        return -1;
    }
}