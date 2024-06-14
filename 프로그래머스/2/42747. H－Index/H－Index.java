import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n - i;
            int remain = n - i - 1;
            if (citations[i] >= h && remain <= h) {
                return h;
            }
        }
        return 0;
    }
}