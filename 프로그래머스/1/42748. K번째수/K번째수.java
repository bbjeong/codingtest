import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answers = new ArrayList<>();
        for (int n = 0; n < commands.length; n++) {
            int[] command = commands[n];
            int i = command[0];
            int j = command[1];
            int k = command[2];
            int[] arr = new int[j - i + 1];
            for (int x = i - 1; x < j; x++) {
                arr[x - i + 1] = array[x];
            }
            Arrays.sort(arr);
            answers.add(arr[k - 1]);
            System.out.println(Arrays.toString(arr));
        }

        return answers.stream().mapToInt(Integer::intValue).toArray();
    }
}