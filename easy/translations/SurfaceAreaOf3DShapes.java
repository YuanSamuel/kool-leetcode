package easy.translations;

public class SurfaceAreaOf3DShapes {
    public static void main(String[] args) {
        int n = 3;
        int[][] grid = new int[n][n];
        grid[0][0] = 2;
        grid[0][1] = 2;
        grid[0][2] = 2;
        grid[1][0] = 2;
        grid[1][1] = 1;
        grid[1][2] = 2;
        grid[2][0] = 2;
        grid[2][1] = 2;
        grid[2][2] = 2;

        System.out.println(surfaceArea(grid, n));
    }

    public static int surfaceArea(int[][] grid, int gridLength) {
        int res = 0;
        int n = gridLength;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    res += grid[i][j] * 4 + 2;
                }
                if (i > 0) {
                    if (grid[i][j] < grid[i - 1][j]) {
                        res -= grid[i][j] * 2;
                    } else {
                        res -= grid[i - 1][j] * 2;
                    }
                }
                if (j > 0) {
                    if (grid[i][j] < grid[i][j - 1]) {
                        res -= grid[i][j] * 2;
                    } else {
                        res -= grid[i][j - 1] * 2;
                    }
                }
            }
        }
        return res;
    }
}
