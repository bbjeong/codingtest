import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String numbers) {
        char[] chars = numbers.toCharArray();

        int[] nums = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            nums[i] = chars[i] - '0';
        }

        int len = nums.length;
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int[] result = new int[i+1];
            boolean[] isVisited = new boolean[len];
            int depth = 0;
            int count = i+1;
            int level = len;

            permutation(nums, result, isVisited, depth, level, count, strings);
        }

        return (int) strings.stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet())
            .stream().filter(o -> isPrimeNumber(o)).count();
    }
    
    private boolean isPrimeNumber(int n) {
        if (n == 0 || n == 1) return false;
        if (n == 2) return true;

        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    private void permutation(int[] numbers, int[] result, boolean[] isVisited, int depth, int level, int count, List<String> strings) {

        if (count == 0) {
            strings.add(Arrays.stream(result).mapToObj(m -> Integer.toString(m)).collect(Collectors.joining()));
            return;
        }

        for (int i  = 0; i < level; i++) {

            if (!isVisited[i]) {
                isVisited[i] = true;
                result[depth] = numbers[i];
                permutation(numbers, result, isVisited, depth + 1, level, count -1, strings);
                isVisited[i] = false;
            }

        }
    }
}