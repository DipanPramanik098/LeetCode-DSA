class Solution {
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); // Math.abs handles negative numbers
    }
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        return findGCD(nums[0],nums[nums.length-1]);
    }
}