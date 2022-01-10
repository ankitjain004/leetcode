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
    Set<Integer> toBeDeletedSet = new HashSet<>();
    List<TreeNode> solution = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int i=0;i<to_delete.length;i++)
        {
            toBeDeletedSet.add(to_delete[i]);
        }
        delete(root, toBeDeletedSet);
        
        if(!toBeDeletedSet.contains(root.val))
        {
            solution.add(root);
        }
        return solution;
    }
    
    public TreeNode delete(TreeNode root, Set<Integer> toBeDeletedSet)
    {
        if(root==null) return null;
        root.left = delete(root.left, toBeDeletedSet);
        root.right = delete(root.right, toBeDeletedSet);
        
        if(toBeDeletedSet.contains(root.val))
        {
            if(root.left != null) solution.add(root.left);
            if(root.right != null) solution.add(root.right);
            return null;
        }
        return root;
    }
}