class Solution {
    public int rob(int[] nums) {
        int n = nums.length - 1;
        if(n==0) return nums[0];
        if(n==1) return Math.max(nums[0], nums[1]);

        //  first part 0 to n-2
        int p2 = nums[0];
        int p1 = Math.max(nums[0], nums[1]);
        for(int i=2; i<n; i++){
            int curr = Math.max(nums[i] + p2, p1);
            p2 = p1;
            p1 = curr;
        }
        int ans1 = p1;

        // 2nd part --> 1 to n-1
        p2 = nums[1];
        p1 = Math.max(nums[1], nums[2]);
        for(int i=3; i<=n; i++){
            int curr = Math.max(nums[i] + p2, p1);
            p2 = p1;
            p1 = curr;
        }
        return Math.max(ans1, p1);
    }
}