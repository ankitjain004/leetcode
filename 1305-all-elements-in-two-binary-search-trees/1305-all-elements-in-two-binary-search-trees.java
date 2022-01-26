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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);
        
        List<Integer> sol = new ArrayList<>();
        int n1 = list1.size();
        int n2 = list2.size();
        
        int i=0,j=0;
        while(i<n1 && j<n2)
        {
            if(list1.get(i)<list2.get(j))
            {
                sol.add(list1.get(i));
                i++;
            }
            else if(list1.get(i)> list2.get(j))
            {
                sol.add(list2.get(j));
                j++;
            }
            else
            {
                sol.add(list1.get(i));
                sol.add(list1.get(i));
                i++;
                j++;
            }
        }
        while(i<n1)
        {
            sol.add(list1.get(i++));
        }
        while(j<n2)
        {
            sol.add(list2.get(j++));
        }
        
        return sol;
        
    }
    
    public void inorder(TreeNode root, List<Integer> list)
    {
        if(root == null)
            return ;
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}