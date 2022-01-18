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
    TreeNode lca = null;
    public int findDistance(TreeNode root, int p, int q) {
        lca = null;
        findLCA(root, p, q);
        return findDistanceUtil(lca, p, 0) + findDistanceUtil(lca,q, 0);
    }
    
    public int findDistanceUtil(TreeNode root, int node, int dist)
    {
        if(root==null) return 0;
        if(root.val==node) return dist;
        int distance = findDistanceUtil(root.left,node, dist+1);
        if(distance!=0) return distance; 
        else{
        distance =  findDistanceUtil(root.right,node, dist+1);
        return distance; }
    }
    public boolean findLCA(TreeNode root, int p, int q)
    {
        
        if(root == null) return false;
        
        int first = findLCA(root.left, p, q)?1:0;
        int second = findLCA(root.right, p, q)?1:0;
        int third = (root.val == p || root.val == q) ?1 :0;
        
        
        if(first+second+third>1)
        {
            this.lca = root;
        }
        
        return first+second+third>0;
        
        
    }
}