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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> nodeToBeDeletedSet = new HashSet<>();
        for(int val: to_delete)
        {
            nodeToBeDeletedSet.add(val);
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> solution = new HashSet<>();
        
        queue.offer(root);
        solution.add(root);
        
        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            
            if(nodeToBeDeletedSet.contains(node.val))
            {
                solution.remove(node);
                if(node.left!=null)
                {
                    solution.add(node.left);
                }
                
                if(node.right!=null)
                {
                    solution.add(node.right);
                }
            }
            if(node.left!=null)
            {
                queue.offer(node.left);
                if(nodeToBeDeletedSet.contains(node.left.val))
                {
                    node.left = null;
                }
            }
            if(node.right!=null)
            {
                queue.offer(node.right);
                if(nodeToBeDeletedSet.contains(node.right.val))
                {
                    node.right = null;
                }
            }
        }
        return new ArrayList<>(solution);
        
    }
}