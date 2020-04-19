package com.gloria.study.algorithm.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luoxin
 * @version 1.0
 * @date 2020/4/19 9:34 上午
 *
 *
 * 二叉树：树的每个节点最多只能有两个子节点
 *
 * 上图的第一幅图B节点有DEF三个子节点，就不是二叉树，称为多路树；而第二幅图每个节点最多只有两个节点，是二叉树，并且二叉树的子节点称为“左子节点”和“右子节点”。上图的D,E分别是B的左子节点和右子节点。
 *
 * 如果我们给二叉树加一个额外的条件，就可以得到一种被称作二叉搜索树(binary search tree)的特殊二叉树。
 *
 * 　　二叉搜索树要求：若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为二叉排序树。
 *
 *
 */
public class BinaryTree {

    //树的根节点
    Node root;

    /**
     * 增加节点
     * @param current
     * @param value
     * @return
     */
    private Node addNode(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.data) {
            current.left = addNode(current.left, value);
        } else if (value > current.data) {
            current.right = addNode(current.right, value);
        } else {
            return current;
        }
        return current;
    }
    public void addNode(int value) {
        root = addNode(root, value);
    }

    /**
     * 查找一个节点
     * @param current
     * @param value
     * @return
     */
    private boolean containNode(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.data) {
            return true;
        }
        return value < current.data ? containNode(current.left, value) : containNode(current.right, value);
    }
    public boolean containNode(int value) {
        return containNode(root, value);
    }

    /**
     * 删除一个节点
     * @param current
     * @param value
     * @return
     */
    private Node deleteNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.data) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.left == null) {
                return current.right;
            }
            if (current.right == null) {
                return current.left;
            }
            int smallestValue = findSmallestValue(current.right);
            current.data = smallestValue;
            current.right = deleteNode(current.right, smallestValue);
            return current;
        }
        if (value < current.data) {
            current.left = deleteNode(current.left, value);
            return current;
        }
        current.right = deleteNode(current.right, value);
        return current;
    }
    private int findSmallestValue(Node root) {
        return root.left == null ? root.data : findSmallestValue(root.right);
    }


    /**
     * 以Depth-First遍历树
     * 中序遍历
     * in-order遍历是首先遍历左子树，然后root节点，最后是右子树。
     * @param root
     */
    public void traverseInOrder(Node root) {
        if (root != null) {
            traverseInOrder(root.left);
            System.out.println(root.data);
            traverseInOrder(root.right);
        }
    }

    /**
     * 以Depth-First遍历树
     * 前序遍历
     * pre-order遍历首先是root节点，然后是左子树，最后是右子树。
     * @param root
     */
    public void traversePreOrder(Node root) {
        if (root != null) {
            System.out.println(root.data);
            traversePreOrder(root.left);
            traversePreOrder(root.right);
        }
    }

    /**
     * 以Depth-First遍历树
     * post-order遍历首先是遍历左子树，然后是右子树，最后是root节点。
     * @param root
     */
    public void traversePostOrder(Node root) {
        if (root != null) {
            traversePostOrder(root.left);
            traversePostOrder(root.right);
            System.out.println(root.data);
        }
    }

    /**
     * 以Breadth-First遍历
     * 它在遍历下一级的节点之前，会遍历当前级的所有节点。
     * 这种类型的遍历也叫做level-order，遍历树从root节点开始，从左到右。
     * 为了实现，使用队列来存储每个级别的节点。我们将会从列表中获取每个节点。然后添加他的子节点到队列中。
     * @param root 
     */
    public void traverseLevelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(root);
        while(!nodes.isEmpty()) {
            Node node = nodes.remove();
            System.out.println(node.data);
            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.addNode(6);
        bt.addNode(4);
        bt.addNode(8);
        bt.addNode(10);
        bt.addNode(19);
        bt.addNode(30);
        bt.addNode(45);
        bt.addNode(2);
        bt.addNode(9);
        Node node = new Node(6);
        bt.traverseInOrder(node);
        System.out.println(bt);
    }
}
