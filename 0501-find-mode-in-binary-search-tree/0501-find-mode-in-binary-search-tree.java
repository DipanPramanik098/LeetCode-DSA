/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int currentCount = 0;
    private int maxCount = 0;
    private Integer prev = null;

    private List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);

        int [] ans = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            ans[i] = result.get(i);
        }
        return ans;
    }
    private void inorder(TreeNode node){
        if (node == null) {
            return;
        }

        // Left
        inorder(node.left);

        // Process current node
        if (prev == null || node.val != prev) {
            currentCount = 1;
        } else {
            currentCount++;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            result.clear();
            result.add(node.val);
        } else if (currentCount == maxCount) {
            result.add(node.val);
        }

        prev = node.val;

        // Right
        inorder(node.right);
    }
}