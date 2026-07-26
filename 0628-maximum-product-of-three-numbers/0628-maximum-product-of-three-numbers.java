import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int withNeg = nums[0] * nums[1] * nums[n - 1];
        int withoutNeg = nums[n - 1] * nums[n - 2] * nums[n - 3];

        return Math.max(withNeg, withoutNeg);
    }
}