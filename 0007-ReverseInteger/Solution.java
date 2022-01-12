class Solution {
    public int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            
            try {
                reversed = Math.multiplyExact(reversed, 10);
                reversed = Math.addExact(reversed, digit);
            } catch (ArithmeticException e) {
                return 0;
            }
            
            x /= 10;
        }
        
        return reversed;
    }
}