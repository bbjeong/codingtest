import java.math.BigInteger;
class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
       
        int numer3 = numer1 * denom2 + numer2 * denom1;
        int denom3 = denom1 * denom2;

        int gcd = BigInteger.valueOf(numer3).gcd(BigInteger.valueOf(denom3)).intValue();

        return new int[]{numer3/gcd, denom3/gcd};
    }
}