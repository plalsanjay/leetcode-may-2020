/*In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Note:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.*/

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
class Data
{
    int height;
    int parent;
    Data (int parent, int height)
    {
        this.parent=parent;
        this.height=height;
    }
    
}

class Solution {
    static HashMap<Integer,Data> map =new HashMap<Integer,Data>();

    void preorder(TreeNode node, int height,int parent)
    {
        if (node == null){
        return;
    }
    map.put(node.val, new Data(parent,height));
    if(node.left==null)
    {
        preorder(node.right, height+1, node.val);
    }
    else if(node.right==null)
    {
        preorder(node.left,height+1, node.val);
    }
    else
    {
        preorder(node.left, height+1, node.val);
        preorder(node.right, height+1, node.val);
    }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        preorder(root ,0 , 0);
        Data a = map.get(x);
        Data b = map.get(y);
        //System.out.println("a"+a.parent +"");
        //System.out.println("a"+a.height);
        //System.out.println("b"+b.parent);
        //System.out.println("b"+a.height);
        if(a.parent!=b.parent && a.height==b.height)
        {
            return true;

        }
        return false;
    }
}
 
