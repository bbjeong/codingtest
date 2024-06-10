import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] nums) {
        return Arrays.stream(nums).boxed().collect(
                Collectors.collectingAndThen(
                        Collectors.toSet(), resultSet -> Math.min(resultSet.size(), nums.length / 2)
                ));
    }
}