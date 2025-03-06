package easy.translations;

public class TypeOfTriangle {
    public static void main(String[] args) {
        int[] traingleA = new int[3];
        traingleA[0] = 3;
        traingleA[1] = 3;
        traingleA[2] = 3;

        int[] traingleB = new int[3];
        traingleB[0] = 3;
        traingleB[1] = 4;
        traingleB[2] = 5;

        int[] traingleC = new int[3];
        traingleC[0] = 3;
        traingleC[1] = 4;
        traingleC[2] = 3;

        System.out.println(triangleType(traingleA));
        System.out.println(triangleType(traingleB));
        System.out.println(triangleType(traingleC));
    }

    public static String triangleType(int[] nums) {
        if (!(nums[0] + nums[1] > nums[2] && nums[0] + nums[2] > nums[1] && nums[2] + nums[1] > nums[0])) {
            return "none";
        }

        if (nums[0] == nums[1] && nums[1] == nums[2]) {
            return "equilateral";
        } else if (nums[0] != nums[1] && nums[0] != nums[2] && nums[1] != nums[2]) {
            return "scalene";
        }

        return "isosceles";
    }
}
