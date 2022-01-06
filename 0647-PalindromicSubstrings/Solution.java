class Solution {
    public int countSubstrings(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int palindromes = 0;
        for (int index = 0; index < s.length(); index++) {
            palindromes += countPalindromes(s, index, index);
            palindromes += countPalindromes(s, index, index + 1);
        }

        return palindromes;
    }

    private int countPalindromes(final String s, int index1, int index2) {
        int count = 0;
        while (index1 >= 0 && index2 < s.length() && s.charAt(index1) == s.charAt(index2)) {
            count++;
            index1--;
            index2++;
        }

        return count;
    }
}