package easy.translations;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(31));
        System.out.println(isPowerOfTwo(32));  
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        
        while (n > 0) {
            if (n == 1) {
                return true;
            }
            if (n % 2 != 0) {
                break;
            }
            n /= 2;
        }
        return false;
    }

}
