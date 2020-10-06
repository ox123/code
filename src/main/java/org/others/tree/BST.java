package org.others.tree;

import java.util.ArrayList;

/**
 * https://practice.geeksforgeeks.org/problems/check-for-bst/1/?company[]=Amazon&problemType=functional&page=1&sortBy=submissions&query=company[]AmazonproblemTypefunctionalpage1sortBysubmissions
 * @author Administrator
 *
 */
public class BST {
	// return true if the given tree is a BST, else return false
	ArrayList<Integer> list = new ArrayList<Integer>();
	boolean isBST(Node root) {
		// code here.
		in(root);
		for (int i = 0; i < list.size()-1; i++) {
			if (list.get(i) > list.get(i+1)) {
				return false;
			}
		}
		return true;
	}

	private void in(Node root) {
		if (root == null) {
			return;
		}
		if (root.left !=null) {
			in(root.left);
		}
		list.add(root.data);
		if (root.right !=null) {
			in(root.right);
		}
	}

	class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}
}
