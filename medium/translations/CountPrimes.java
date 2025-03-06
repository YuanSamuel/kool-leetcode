package medium.translations;

public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(0));
        System.out.println(countPrimes(2));
        System.out.println(countPrimes(20));
    }

    public static int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
}
