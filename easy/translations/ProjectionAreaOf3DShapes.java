package easy.translations;

public class ProjectionAreaOf3DShapes {
    public static void main(String[] args) {
        int n = 2;
        int[][] grid = new int[n][n];
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[1][0] = 3;
        grid[1][1] = 4;

        System.out.println(projectionArea(grid, n));
    }

    public static int projectionArea(int[][] grid, int gridLength) {
        int res = 0;
        int n = gridLength;
        for (int i = 0; i < n; ++i) {
            int x = 0;
            int y = 0;
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > x) {
                    x = grid[i][j];
                }
                if (grid[j][i] > y) {
                    y = grid[j][i];
                }
                if (grid[i][j] > 0) {
                    ++res;
                }
            }
            res += x + y;
        }
        return res;
    }
}
