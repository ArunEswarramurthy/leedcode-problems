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
    public  int sum = 0;
    
    public TreeNode bstToGst(TreeNode root)
    {

        reverseInOrder(root);
  return root ;
    }
    
 public void reverseInOrder(TreeNode node) {
       if (node == null) 
       {return;
       }
reverseInOrder(node.right);    
        sum += node.val;               
 node.val = sum;                
        reverseInOrder(node.left);   
    }
}