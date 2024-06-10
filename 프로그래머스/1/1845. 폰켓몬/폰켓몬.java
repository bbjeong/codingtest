import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int max = nums.length / 2;
        if (set.size() > max) {
            return max;
        } else {
            return set.size();
        }
    }
}