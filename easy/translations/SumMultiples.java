package easy.translations;

public class SumMultiples {
    public static void main(String[] args) {
        System.out.println(sumOfMultiples(7));
        System.out.println(sumOfMultiples(10));
        System.out.println(sumOfMultiples(9));
    }

    public static int sumOfMultiples(int n) {
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                ans += i;
            }
        }
        return ans;
    }
}
