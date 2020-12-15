import java.util.*;

class TreeNode implements Comparable {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
};

class LevelOrderTraversal {

    public static List<List<Integer>> traverse(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null)
            return null;

        // TODO: Write your code here
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int s = q.size();
        while(s > 0){
            List<Integer> level = new ArrayList<Integer>();
            for(int i=0; i < s; i++){
                TreeNode node = q.remove();
                if(node.left !=null)
                    q.add(node.left);
                if(node.right !=null)
                    q.add(node.right);
                level.add(node.val);
            }
            result.add(level);
            s = q.size();
        };
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}
