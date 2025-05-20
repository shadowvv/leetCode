package questions;

public class Q3024 {
    public String triangleType(int[] nums) {
        if(nums.length != 3) {
            return "none";
        }
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        if(a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }
        if(a == b && b == c) {
            return "equilateral";
        }
        if(a == b || b == c || a == c) {
            return "isosceles";
        }
        return "scalene";
    }

    public static void main(String[] args) {
        Q3024 q = new Q3024();
        System.out.println(q.triangleType(new int[]{3, 4, 5})); // scalene
        System.out.println(q.triangleType(new int[]{3, 3, 3})); // equilateral
    }
}
