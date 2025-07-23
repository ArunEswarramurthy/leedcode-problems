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

    public int preIndex = 0;

    public TreeNode bstFromPreorder(int[] preorder) 
    {
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public  TreeNode build(int[] preorder, int lower, int upper)
     {
    if (preIndex == preorder.length) 
        return null;

    int val = preorder[preIndex];
        if (val < lower || val > upper) 
return null;

  TreeNode root = new TreeNode(val);
      preIndex++;
    root.left = build(preorder, lower, val - 1);
     root.right = build(preorder, val + 1, upper);
        return root;
    }
}
