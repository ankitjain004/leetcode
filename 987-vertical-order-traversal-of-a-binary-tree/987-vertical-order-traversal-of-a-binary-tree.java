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
    Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<>();
    int minCol = 0;
    int maxCol = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        recurse(root, 0, 0);

        for (int i = minCol; i <= maxCol; i++) {
            List<Pair<Integer, Integer>> ans = map.get(i);
            Collections.sort(ans, (a, b) -> {
                if (a.getKey() != b.getKey())
                    return a.getKey() - b.getKey();
                else {
                    return a.getValue() - b.getValue();
                }
            });
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < ans.size(); j++) {
                temp.add(ans.get(j).getValue());
            }
            sol.add(temp);
        }

        return sol;

    }


    public void recurse(TreeNode root, int row, int hd) {
        if (root == null) return;


        map.putIfAbsent(hd, new ArrayList<>());

        map.get(hd).add(new Pair<Integer, Integer>(row, root.val));
        minCol = Math.min(minCol, hd);
        maxCol = Math.max(maxCol, hd);

        recurse(root.left, row + 1, hd - 1);
        recurse(root.right, row + 1, hd + 1);
    }
}