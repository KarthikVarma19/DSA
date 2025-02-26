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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return solve(nums, 0, nums.length-1);
    }
    public TreeNode solve(int arr[], int i, int j){
        if(i > j) return null;
        if(i == j) return new TreeNode(arr[i]);
        int maxInd = getMax(arr, i, j);
        TreeNode root = new TreeNode(arr[maxInd]);
        root.left = solve(arr, i, maxInd-1);
        root.right = solve(arr, maxInd+1, j);
        return root;
    }
    public int getMax(int arr[], int i , int j){
        int max = 0;
        int ind = 0;
        for(int k = i; k <= j; k++){
            if(arr[k] > max){
                max = arr[k];
                ind = k;
            }
        }
        return ind;
    }
}