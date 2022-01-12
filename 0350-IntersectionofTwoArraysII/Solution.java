class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] freqs = new int[1001];
        for (int n : nums1) {
            freqs[n] += 1;
        }
        
        List<Integer> output = new ArrayList<>();
        for (int n : nums2) {
            if (freqs[n] > 0) {
                output.add(n);
                freqs[n] -= 1;
            }
        }
        
        int[] outputa = new int[output.size()];
        for (int idx = 0; idx < outputa.length; ++idx) {
            outputa[idx] = output.get(idx);
        }
        return outputa;
    }
}