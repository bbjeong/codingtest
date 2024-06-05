import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        
        int[] w = new int[sizes.length];
	    int[] h = new int[sizes.length];

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = tmp;
            }

            w[i] = sizes[i][0];
            h[i] = sizes[i][1];
        }

        Arrays.sort(w);
        Arrays.sort(h);

        return w[w.length - 1] * h[h.length - 1];
    }
}