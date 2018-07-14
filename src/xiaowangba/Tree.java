package xiaowangba;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public ArrayList<ArrayList<Integer>> PrintFromTopToBottomDiff(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int num = 1;
        while (!queue.isEmpty()) {
            ArrayList<Integer> array = new ArrayList<>();
            int tmp = 0;
            while (num-- > 0) {
                TreeNode node = queue.poll();
                array.add(node.val);
                if (node.left != null) {
                    tmp++;
                    queue.add(node.left);
                }

                if (node.right != null) {
                    tmp++;
                    queue.add(node.right);
                }
            }
            num = tmp;
            result.add(array);
        }

        return result;
    }
}
