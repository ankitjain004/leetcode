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
    Map<Integer, List<Integer>> map = new HashMap<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root==null) return answer;
        List<Integer> temp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = -1 ;
        while(!queue.isEmpty())
        {
            level++;
            int n = queue.size();
            temp = new ArrayList<>();
            map.putIfAbsent(level, temp);
            for(int i=0;i<n;i++)
            {
                TreeNode node = queue.poll();
                map.get(level).add(node.val);
                if(node.left!=null)
                {
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
            }
        }
        for(int i=level;i>=0;i--)
        {
            answer.add(map.get(i));
        }
        return answer;
    }
}