package easy.translations;

public class CellsWithOddValues {
    public static void main(String[] args) {
        int m = 2;
        int n = 3;
        int[][] indices = new int[m][n];
        indices[0][0] = 0;
        indices[0][1] = 1;
        indices[1][0] = 1;
        indices[1][1] = 1;
        int numOdd = oddCells(m, n, indices, 2);
        System.out.println(numOdd);
    }

    public static int oddCells(int m, int n, int[][] indices, int numIndices) {
        int count = 0;
        int[] row = new int [m];
        int[] col = new int [n];
        for (int i = 0; i < numIndices; i++) {
            row[indices[i][0]]++;
            col[indices[i][1]]++;
        }
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if((row[i] + col[j]) % 2 != 0) {
                    count++;
                }
            }        
        }
        return count;
    }
}
