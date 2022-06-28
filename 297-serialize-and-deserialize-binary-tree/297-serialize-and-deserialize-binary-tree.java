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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String tree = "";
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            
            if (curr!=null)
                tree += curr.val+" ";
            else
                tree += "n ";
            
            if (curr!=null) {
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        
        return tree;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        
        int index = 0;
        if (tokens[index].equals("n")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(tokens[index]));
        q.add(root);
        index++;
        
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            String token1 = tokens[index++];
            String token2 = tokens[index++];
            
            if (token1.equals("n")) {
                curr.left=null;
            }
            else {
                curr.left=new TreeNode(Integer.parseInt(token1));
                q.add(curr.left);
            }
            
            if (token2.equals("n")) {
                curr.right=null;
            }
            else {
                curr.right=new TreeNode(Integer.parseInt(token2));
                q.add(curr.right);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));