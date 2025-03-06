package easy.translations;

public class CountLargestGroup {
    public static void main(String[] args) {
        System.out.println(countLargestGroup(13));
        System.out.println(countLargestGroup(2));
    }

    public static int countLargestGroup(int n) {
        int[] map = new int[37];
        int maxCount = 0;
        int res = 0;
        for (int i = 1; i <= n; i++) {
          int num = i;
          int sum = 0;
          while (num > 0) {
            sum += num % 10;
            num /= 10;
          }
          
          map[sum] = map[sum] + 1;
          
          if (maxCount < map[sum]) {
            maxCount = map[sum];
            res = 1;
          } else if (maxCount == map[sum]) {
            res++;
          }
        }
        return res;
    }
}
