class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = 0, k = nums.length - 1;

        while (j <= k) {
            if (nums[j] == 2) {
                // Swap nums[j] and nums[k]
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                k--; // Do not increment j here
            } else if (nums[j] == 0) {
                // Swap nums[j] and nums[i]
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            } else {
                j++;
            }
        }
    }
}