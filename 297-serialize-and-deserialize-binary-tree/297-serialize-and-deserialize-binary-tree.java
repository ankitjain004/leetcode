/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int index=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String ans = "";
        ans = serializeUtils(root, ans);
        return ans;
    }
    
    public String serializeUtils(TreeNode root, String ans)
    {
        if(root==null) 
        {
            if(ans.length()==0)
                ans = ans + "null";
            else
                ans = ans + ","+ "null";
        }

        else
        {
            if(ans.length()==0)
                ans = ans + String.valueOf(root.val);
            else
                ans = ans +  "," + String.valueOf(root.val);
            ans = serializeUtils(root.left, ans);    
            ans = serializeUtils(root.right, ans);
        }
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data1) 
    {
        String[] arr = data1.split(",");
        List<String> data = new LinkedList<String>(Arrays.asList(arr));
        return deserializeUtils(data);
    }
    
    public TreeNode deserializeUtils(List<String> data)
    {
        if(data.get(0).equals("null"))
        {
            data.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(data.get(0)));
        data.remove(0);
        node.left = deserializeUtils(data);
        node.right = deserializeUtils(data);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));