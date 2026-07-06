import java.util.*;

class Solution {

    private void p(int[] nums, List<List<Integer>> ans, int i) {
        if (i == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            ans.add(temp);
            return;
        }

        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            p(nums, ans, i + 1);
            swap(nums, i, j); // backtrack
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        p(nums, ans, 0);
        return ans;
    }
}