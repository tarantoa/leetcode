import java.util.Stack;

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.left == null ^ current.right == null) {
                return  false;
            } else if (current.left != null && current.right != null) {
                if (current.left.val >= current.val || current.right.val <= current.val) {
                    return false;
                } else {
                    stack.push(current.left);
                    stack.push(current.right);
                }
            }
        }

        return true;
    }

 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
}