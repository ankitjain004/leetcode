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
    Map<Integer, Integer> map = new HashMap<>();
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i], i);
        }

        this.postIndex = postorder.length-1;
        return buildTree(postorder, 0 , this.postIndex);
    }

    public TreeNode buildTree(int[] postorder, int left, int right)
    {
        if(left>right) return null;
        TreeNode root = new TreeNode(postorder[postIndex]);
        int index = map.get(postorder[postIndex]);
        this.postIndex--;
        
        root.right = buildTree(postorder,  index+1, right);
        root.left = buildTree(postorder, left, index-1);
        return root;
    }
}