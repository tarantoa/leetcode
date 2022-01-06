class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> uniqueValues = new HashSet<>();
        for (int value : nums) {
            if (!uniqueValues.add(value)) {
                return true;
            }
        }
        
        return false;
    }
}