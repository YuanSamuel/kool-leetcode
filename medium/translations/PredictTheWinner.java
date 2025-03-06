package medium.translations;

public class PredictTheWinner {
    public static void main(String[] args) {
        int[] numsA = new int[3];
        int[] numsB = new int[4];

        numsA[0] = 1;
        numsA[1] = 5;
        numsA[2] = 2;

        numsB[0] = 1;
        numsB[1] = 5;
        numsB[2] = 233;
        numsB[3] = 7;

        System.out.println(predictTheWinner(numsA, 3));
        System.out.println(predictTheWinner(numsB, 4));
    }

    public static boolean predictTheWinner(int[] nums, int numsLength) {
        int n = numsLength;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) { 
            dp[i][i] = nums[i]; 
        }
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                int a = nums[i] - dp[i + 1][j];
                int b = nums[j] - dp[i][j - 1];
                if (a > b) {
                    dp[i][j] = a;
                } else {
                    dp[i][j] = b;
                }
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
