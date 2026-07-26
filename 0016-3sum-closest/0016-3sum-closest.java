class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int cs = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {
            int lo = i + 1;
            int hi = n - 1;

            while (lo < hi) {
                int curr = nums[i] + nums[lo] + nums[hi];

                if (Math.abs(curr - target) < Math.abs(cs - target)) {
                    cs = curr;
                }

                if (curr == target) return curr;
                else if (curr < target) lo++;
                else hi--;
            }
        }

        return cs;
    }
}