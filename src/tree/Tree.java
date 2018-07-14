package tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    //minimum-depth-of-binary-tree
    public int run(TreeNode root) {
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return 1;
        else if (root.left == null)
            return 1 + run(root.right);
        else if (root.right == null)
            return 1 + run(root.left);
        else
            return 1 + Math.min(run(root.left), run(root.right));
    }

    //postOrder without recursive solution.
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null)
            return list;

        stack.push(root);
        while (!stack.empty()) {
            TreeNode current = stack.pop();
            if (current.left != null) {
                stack.push(current.left);
                list.add(current.left.val);
                current.left = null;
            } else if (current.right != null) {
                stack.push(current.right);
                list.add(current.right.val);
                current.right = null;
            } else {
                stack.pop();
                list.add(current.val);
            }
        }
        return list;
    }

    //preOrder without recursive solution.
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null)
            return list;

        stack.push(root);
        list.add(root.val);
        while (!stack.empty()) {
            TreeNode current = stack.peek();
            if (current.left == null && current.right == null) {
                stack.pop();
            }

            if (current.left != null) {
                stack.push(current.left);
                list.add(current.left.val);
                current.left = null;
            } else if (current.right != null) {
                stack.push(current.right);
                list.add(current.right.val);
                current.right = null;
            }
        }

        return list;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = null;
        int length = pre.length;
        if (length != 0)
            root = new TreeNode(pre[0]);

        int index = 1;
        while (index < length) {
            TreeNode unKnow = new TreeNode(pre[index]);
            setNode(unKnow, root, in);
            index++;
        }

        return root;
    }

    private void setNode(TreeNode unKnow, TreeNode root, int[] in) {
        if (compare(unKnow.val, root.val, in) < 0) {
            if (root.left == null)
                root.left = unKnow;
            else
                setNode(unKnow, root.left, in);
        } else if (compare(unKnow.val, root.val, in) > 0) {
            if (root.right == null)
                root.right = unKnow;
            else
                setNode(unKnow, root.right, in);
        }

    }

    private int compare(int val1, int val2, int[] in) {
        for (int value : in) {
            if (value == val1)
                return -1;
            else if (value == val2)
                return 1;
        }
        return 0;
    }


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            result.add(current.val);
            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> PrintFromTopToBottomDiff(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        queue.add(root);

        while (!queue.isEmpty()) {
            int length = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            while (length > 0) {
                TreeNode current = queue.poll();
                tmp.add(current.val);
                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);
                length--;
            }
            result.add(tmp);
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> allPath = new ArrayList<>();
        if (root == null) {
            return allPath;
        } else if (root.left == null && root.right == null && root.val == target) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(root.val);
            allPath.add(path);
        } else if (root.left != null) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(root.val);
            find(root.left, (target - root.val), path, allPath);
        } else {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(root.val);
            find(root.right, (target - root.val), path, allPath);
        }

        return allPath;
    }

    private void find(TreeNode root, int target,
                      ArrayList<Integer> path,
                      ArrayList<ArrayList<Integer>> allPath) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                allPath.add(path);
            }
            return;
        }

        if (root.left != null) {
            path.add(root.val);
            find(root.left, target - root.left.val, path, allPath);
        }

        ArrayList<Integer> rightPath = new ArrayList<>();
        rightPath.addAll(path);
        if (root.right != null) {
            path.add(root.val);
            find(root.right, target - root.right.val, rightPath, allPath);
        }
    }


    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        boolean isLeft = true;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot != null) {
            queue.add(pRoot);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> rowResult = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (isLeft) {
                    rowResult.add(node.val);
                } else {
                    stack.push(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }

            while (!stack.isEmpty()) {
                rowResult.add(stack.pop());
            }

            isLeft = !isLeft;
            result.add(rowResult);
        }

        return result;
    }

//    public TreeNode Convert(TreeNode pRootOfTree) {
//        if (pRootOfTree == null) return null;
//    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        Tree tree = new Tree();
        tree.Print(root);
    }

}
