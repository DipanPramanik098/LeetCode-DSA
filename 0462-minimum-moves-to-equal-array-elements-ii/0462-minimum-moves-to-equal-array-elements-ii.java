class Solution {
    public int minMoves2(int[] nums) {
        // step 1 : sort the array
        Arrays.sort(nums);

        // step 2 : Find the median
        int median = nums[nums.length / 2];

        // step 3 : Calculate Total Moves
        int moves = 0;

        for(int num : nums){
            moves += Math.abs(num - median);
        }

        return moves;
    }
}