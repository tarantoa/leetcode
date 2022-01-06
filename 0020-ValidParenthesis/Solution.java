class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char current : s.toCharArray()) {
            switch (current) {
                case '{':
                case '[':
                case '(':
                    stack.push(current);
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
            }
        }
        
        return stack.isEmpty();
    }
}