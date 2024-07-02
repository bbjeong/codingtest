import java.util.*;
import java.util.concurrent.atomic.*;

class Solution {
    public int solution(int[] numbers, int target) {
        AtomicInteger answer = new AtomicInteger(0);
        dfs(numbers, 0, 0, target, answer);
        
        return answer.get();
    }
    
    private void dfs(int[] numbers, int depth, int sum, int target, AtomicInteger result) {

        if (depth == numbers.length) {
            if (sum == target) {
                result.incrementAndGet();
            }
            return;
        }

        int[] inputs = {1, -1};
        for (int i = 0; i < inputs.length; i++) {
            dfs(numbers, depth + 1, (numbers[depth] * inputs[i]) + sum, target, result);
        }
    }
}