package medium.translations;

public class RectangleArea {
    public static void main(String[] args) {
        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int areaOfSqrA = (C-A) * (D-B);
        int areaOfSqrB = (G-E) * (H-F);
        
        int left;
        if (A > E) {
            left = A;
        } else {
            left = E;
        }

        int right;
        if (G < C) {
            right = G;
        } else {
            right = C;
        }

        int bottom;
        if (F > B) {
            bottom = F;
        } else {
            bottom = B;
        }

        int top;
        if (D < H) {
            top = D;
        } else {
            top = H;
        }
        
        int overlap = 0;
        if (right > left && top > bottom) {
            overlap = (right - left) * (top - bottom);
        }
        
        return areaOfSqrA + areaOfSqrB - overlap;
    }
}
