class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sFinal = new Stack<>();
        Stack<Character> tFinal = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '#' && !sFinal.isEmpty()) {
                sFinal.pop();
            } else if (c != '#') {
                sFinal.push(c);
            }
        }
        for (char c : t.toCharArray()) {
            if (c == '#' && !tFinal.isEmpty()) {
                tFinal.pop();
            } else if (c != '#') {
                tFinal.push(c);
            }
        }
        
        return sFinal.equals(tFinal);
    }
}