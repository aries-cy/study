package com.cy.study.leetcode.tree;

import org.junit.Test;
import java.util.Stack;

/**
 * 二叉树遍历
 *
 * @author cy
 */
public class BinaryTree {

    /**
     * 前序递归遍历二叉树
     * @param treeNode 树节点
     */
    @Test
    public void preOrderTraverse1(TreeNode treeNode){
        if(null!=treeNode){
            System.out.println(treeNode.getVal());
            preOrderTraverse1(treeNode.getLeft());
            preOrderTraverse1(treeNode.getRight());
        }
    }

    /**
     * 前序非递归遍历二叉树
     * @param root 树根节点
     */
    @Test
    public void preOrderTraverse2(TreeNode root){
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode node = root;
        while (node!=null||!nodeStack.isEmpty()){
            if(node!=null){
                System.out.println(node.getVal());
                nodeStack.push(node);
                node = node.getLeft();
            }else {
                TreeNode tem = nodeStack.pop();
                node = tem.getRight();
            }
        }
    }

    /**
     * 中序非递归遍历二叉树
     * @param root 根节点
     */
    public void inOrderTraverse1(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node!=null||!stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node = node.getLeft();
            }else {
                TreeNode tem = stack.pop();
                System.out.println(tem);
                node = tem.getRight();
            }
        }
    }


}
