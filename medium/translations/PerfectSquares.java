package medium.translations;

public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
        System.out.println(numSquares(71));
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            dp[i] = 100000000;
        }
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            int min = 100000000;
            int j = 1;
            while (i - j*j >= 0) {
                int numWays = dp[i - j*j] + 1;
                if (numWays < min) {
                    min = numWays;
                }
                ++j;
            }
            dp[i] = min;
        }		
        return dp[n];
    }
}
