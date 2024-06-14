import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answers = new int[commands.length];
        for (int n = 0; n < commands.length; n++) {
            int[] command = commands[n];
            int i = command[0];
            int j = command[1];
            int k = command[2];
            int[] arr = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(arr);
            answers[n] = arr[k - 1];
        }

        return answers;
    }
}