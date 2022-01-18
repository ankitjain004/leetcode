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
    ArrayList<Integer> inorder = new ArrayList<>();
    public void recoverTree(TreeNode root) {
        inorder(root);
        
        int index1 = -1;
        int index2 = -1;
        int index3 = -1;
        
        for(int i=0;i<inorder.size()-1;i++)
        {
            if(inorder.get(i)>inorder.get(i+1))
            {
                if(index1==-1)
                {
                    index1 = i;
                    index2 = i+1;
                }
                else
                {
                    index2 = i+1;
                }
            }
        }
        
        
        swap(root, inorder.get(index1), inorder.get(index2));
        
        
        
    }
    
    void swap(TreeNode root, int l, int r)
    {
        if(root == null ) return;
        
        swap(root.left, l , r);
        if(root.val == l)    
            root.val = r;
        else if(root.val == r)
        {
            root.val =l;
        }
        swap(root.right, l , r);
    }
    
    public void inorder(TreeNode root)
    {
        if(root == null) return;
        inorder(root.left);
        inorder.add(root.val);
        inorder(root.right);
    }
}