package medium.translations;

public class SuperUglyNumber {
    public static void main(String[] args) {
        int primesLength = 4;
        int[] primes = new int[primesLength];
        primes[0] = 2;
        primes[1] = 7;
        primes[2] = 13;
        primes[3] = 19;

        System.out.println(nthSuperUglyNumber(12, primes, primesLength));
        System.out.println(nthSuperUglyNumber(20, primes, primesLength));
    }

    public static int nthSuperUglyNumber(int n, int[] primes, int primesLength) {
        int[] ugly = new int[n];
        int[] idx = new int[primesLength];
    
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            ugly[i] = 1000000000;
            for (int j = 0; j < primesLength; j++) {
                if (primes[j] * ugly[idx[j]] < ugly[i]) {
                    ugly[i] = primes[j] * ugly[idx[j]];
                }
            }
            
            for (int j = 0; j < primesLength; j++) {
                while (primes[j] * ugly[idx[j]] <= ugly[i]) {
                    idx[j]++;  
                } 
            }
        }
    
        return ugly[n - 1];
    }
}
