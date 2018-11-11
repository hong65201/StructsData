package com.BinarySearchTree;
import java.util.LinkedList;
import java.util.Queue;

public class BST <E extends Comparable<E>> { //传入的元素需要具有比较性
	private class Node{
		public E e;
		public Node left,right;
		
		public Node(E e) {
			this.e = e;
			left = null;
			right = null;
		}
	}
	private int size;
	private Node root;
	public BST() {
		size = 0;
		root = null;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public int size() {
		return size;
	}
	//添加元素
	public void add(E e) {
		root = add(root,e);
	}
	private Node add(Node node , E e) {
		if(node == null) {
			size++;
			return new Node(e);
		}
		
		if(e.compareTo(node.e) < 0) {
			node.left = add(node.left,e);
		}else if (e.compareTo(node.e) > 0) {
			node.right = add(node.right,e);
		}
		return node;
	}
	//查询二分搜索树是否包此元素
	public boolean contains(E e) {
		return contains(root,e);
	}
	private boolean contains(Node node , E e) {
		if(node == null)
			return false;
		if(e.compareTo(node.e) < 0)
			return contains(node.left,e);
		if(e.compareTo(node.e) > 0)
			return contains(node.right,e);
		else
			return true;
	}
	//前序遍历二分搜索树
	public void preOrder() {
		preOrder(root);
	}
	private void preOrder(Node node) {
		if(node == null) {
			return;
		}
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}
	//层次遍历二分搜索树
	public void levelOrder() {
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			Node cur = q.remove();
			System.out.println(cur.e);
			if(cur.left != null)
				q.add(cur.left);
			if(cur.right != null)
				q.add(cur.right);
			
		}
	}
	//获取二分搜索树的最小值
	public E getMin() {		
		return getMin(root).e;
	}
	private Node getMin(Node node) {
		if(node.left == null) {
			return node;
		}
		return getMin(node.left);
	}
	//删除二分搜索树最小值
	public E removeMin() {		
		removeMin(root);
		return getMin();
	}
	private Node removeMin(Node node) {
		if(node.left == null) {
			Node right = node.right;
			node.right = null;
			size--;
			return right;
		}
		//node.left接收Node
		node.left = removeMin(node.left);
		return node;
	}
	public void remove(E e) {
		root = remove(root,e);
	}
	private Node remove(Node node , E e) {
		if(node == null) {
			return null;
		}
		if(e.compareTo(node.e) < 0) {
			node.left = remove(node.left,e);
			return node;
		}else if(e.compareTo(node.e) > 0) {
			node.right = remove(node.right,e);
			return node;
		}else { //此时e==node.e 为找到
			
			//node左子树为空
			if(node.left == null) {
				Node right = node.right;
				node.right = null;
				size--;
				return right;
			}
			//node右子树为空
			if(node.right == null) {
				Node left = node.left;
				node.left = null;
				size--;
				return left;
			}
			//node左右子树都不为空
			
			//从node.right找到最小节点替换node
			Node sucessor = getMin(node.right);
			sucessor.left = node.left;
			sucessor.right = removeMin(node.right);
			//去除node节点
			node.left = node.right = null;
			
			return sucessor;
		}	
	}
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBSTString(root,0,res);
		return res.toString();
	}
	private void generateBSTString(Node node,int depth,StringBuilder res) {
		if(node == null) {
			res.append(generaDepthString(depth) + "null\n");
			return;
		}
		res.append(generaDepthString(depth) + node.e + "\n");
		generateBSTString(node.left, depth + 1, res);
		generateBSTString(node.right, depth + 1, res);
	}
	private String generaDepthString(int depth) {
		StringBuilder res = new StringBuilder();
		for(int i = 0 ; i < depth ; i++) {
			res.append("--");
		}
		return res.toString();
	}
}
