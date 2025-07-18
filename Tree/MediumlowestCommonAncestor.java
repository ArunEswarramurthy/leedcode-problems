/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> ps = new ArrayList<>();
        build(root, p, ps);

        List<TreeNode> qs = new ArrayList<>();
        build(root, q, qs);
        System.out.println(ps.stream().mapToInt(d -> d.val).boxed().collect(Collectors.toList()));
        System.out.println(qs.stream().mapToInt(d -> d.val).boxed().collect(Collectors.toList()));
        for(int i=0;i<qs.size();i++) {
            if(ps.contains(qs.get(i))) {
                return qs.get(i);
            }
        }
return null;
    }

    private boolean build(TreeNode root, TreeNode s, List<TreeNode> ls) {
        if(root == null) {
            return false;
        }
        if(root == s) {
            ls.add(root);
            return true;
        }
        

        if(build(root.left, s, ls)) {
            ls.add(root.left);
            ls.add(root);
            return true;
        }
        if(build(root.right, s, ls)) {
            ls.add(root.right);
            ls.add(root);
            return true;
        }
        return false;
    }
}