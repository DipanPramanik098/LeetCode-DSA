class Solution {
    public int minMoves(int[] nums) {
        // s1: find minimum element 
        int mini = nums[0];

        for(int i=1; i<nums.length; i++){
            mini  = Math.min(mini, nums[i]);
        }

        // s2: calculate total moves
        int moves = 0;

        for(int i=0; i<nums.length; i++){
            moves += nums[i] - mini;
        }

        return moves;
    }
}