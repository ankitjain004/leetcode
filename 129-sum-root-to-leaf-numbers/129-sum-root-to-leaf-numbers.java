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
    int solution = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        sumNumbersUtil(root, 0);
        return solution;
    }
    
    public void sumNumbersUtil(TreeNode root, int sum)
    {
        if(root!=null){
        if(root.left==null && root.right == null) 
        {
            solution = solution + (sum*10+root.val);
            return ;
        }
        
        
        sumNumbersUtil(root.left, sum*10+root.val);
        sumNumbersUtil(root.right, sum*10+root.val);
        
    }
    }
}