/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    Map<Integer, List<Pair<Integer,Integer>>> map = new HashMap<>();
    int minColumn = 0;
    int maxColumn = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        recurse(root, 0, 0);
        for(int i=minColumn;i<=maxColumn;i++)
        {
            List<Pair<Integer,Integer>> list = map.get(i);
            Collections.sort(list, (a,b)->
                             {return a.getValue()-b.getValue();}
                            );
            
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<list.size();j++)
            {
                temp.add(list.get(j).getKey());
            }
            ans.add(temp);
        }
        return ans;
    }


    public void recurse(TreeNode root, int hd, int row) {
        if (root == null) return;

        if (!map.containsKey(hd))
            map.putIfAbsent(hd, new ArrayList<>());

        map.get(hd).add(new Pair<Integer, Integer>(root.val,row));
        minColumn = Integer.min(minColumn, hd);
        maxColumn = Integer.max(maxColumn, hd);

        recurse(root.left, hd - 1, row+1);
        recurse(root.right, hd + 1, row+1);
    }
}