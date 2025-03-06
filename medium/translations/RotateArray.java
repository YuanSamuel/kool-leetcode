package medium.translations;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[8];
        nums[0] = 1;
        nums[1] = 2;
        nums[2] = 3;
        nums[3] = 4;
        nums[4] = 5;
        nums[5] = 6;
        nums[6] = 7;
        nums[7] = 8;
        rotate(nums, 3, 8);
        for (int i = 0; i < 8; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void rotate(int[] nums, int k, int length) {
        k %= length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
