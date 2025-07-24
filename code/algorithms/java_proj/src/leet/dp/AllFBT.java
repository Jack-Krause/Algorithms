package leet.dp;

import dp.LCSInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllFBT {

    public static List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return Collections.emptyList();
        }

        List<TreeNode>[] dp = new ArrayList[n + 1];

        dp[1] = new ArrayList<>();
        dp[1].add(new TreeNode(0));

        for (int nodes = 3; nodes <= n; nodes += 2) {
            dp[nodes] = new ArrayList<>();

            for (int left = 1; left < nodes; left += 2) {
                int right = nodes - 1 - left;

                for (TreeNode L : dp[left]) {
                    for (TreeNode R : dp[right]) {
                        dp[nodes].add(new TreeNode(0 , L , R));
                    }
                }

            }

        }

        return dp[n];
    }

    public static void main(String[] args) {
        List<TreeNode> trees = allPossibleFBT(7);
        System.out.println("count = " + trees.size()); // expect 5
        for (TreeNode t : trees) {
            System.out.println(serialize(t));
        }
    }


    private static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();

    }

    private static void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) { sb.append("# "); return; }
        sb.append(node.val).append(' ');
        preorder(node.left, sb);
        preorder(node.right, sb);
    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode l, TreeNode r) {
            this.val = val;
            this.left = l;
            this.right = r;
        }

    }
}
