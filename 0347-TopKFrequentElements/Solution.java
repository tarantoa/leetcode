import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Long> inputFrequencices = Arrays.stream(nums)
            .mapToObj(Integer::valueOf)
            .collect(
                Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
                )
            );
        List<Entry<Integer, Long>> sortedFrequencies = new ArrayList<Entry<Integer, Long>>(
            inputFrequencices.entrySet()
        );

        int[] topK = new int[k];
        int n = nums.length;
        for (int count = 0; count < k; ++count) {
            topK[count] = sortedFrequencies.get(n - count - 1).getKey();
        }

        return topK;
    }
}