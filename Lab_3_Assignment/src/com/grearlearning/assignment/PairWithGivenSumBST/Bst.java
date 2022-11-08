package com.grearlearning.assignment.PairWithGivenSumBST;

import java.util.ArrayList;
import java.util.HashMap;

public class Bst {
	
	
  static class Node{
	  int data;
	  Node left,right;
  }
  
  public Node newNode(int x) {
	  Node newNode = new Node();
	  newNode.data =  x;
	  newNode.left = null;
	  newNode.right = null;
	  return newNode;
  }
 
	// Insert node into bst. Iterative method.
	public Node insertNode_iterative(Node root,int key) {
	   
		Node newNode = this.newNode(key);
        Node x = root;
        Node currParent = null;
        
        while( x != null) {
        	currParent = x;
        	if(key < x.data) {
        		x = x.left;
        	}else if( key > x.data) {
        		x = x.right;
        	}else {
        		System.out.println("Key is already present");
        		return x;
        	}
       }
        
       if( currParent == null) {
    	   return newNode;
       }else if( currParent.data > key) {
    	   currParent.left = newNode;
       }else if( currParent.data < key) {
    	   currParent.right = newNode;
       }
		
		return newNode;
   }
	
	// Insert node into bst. Recursive method.
	public Node insert(Node root,int key) {
		if(root == null) {
			Node newNode = this.newNode(key);
			return newNode;
		}
		if( key < root.data) {
			root.left = insert(root.left,key);
		}
		else{
			root.right = insert(root.right,key);
		}
		return root;
	}
	
	
	public boolean search(Node root,int key) {
		Node node;
		node = searchRecursive(root,key);
		if( node != null) {
			return true;
		}else {
			return false;
		}
	}
	
	// Search for a given node key in BST
	public Node searchRecursive(Node root, int key) {
		if( root == null || root.data == key) {
			return root;
		}else if( key < root.data) {
			return searchRecursive(root.left,key);
		}
	    return searchRecursive(root.right,key);
	}
	
	
	//Solution 1: Using search in BST and inorder traversal. Assuming tree has n nodes. Time complexity: O(n log(n) ) Space complexity: O( log(n))[Stack space]
	public void findPair(Node root, int sum,ArrayList<Integer> list, Node bstRoot) {
	
		if( root == null) {
			return;
		}
		
		findPair(root.left,sum,list,bstRoot);
		if( search(bstRoot, sum - root.data)) {
			list.add(root.data);
			list.add(sum - root.data);
			return;
		}
		findPair(root.right,sum,list,bstRoot);
		
	}
	
	//Solution 2: Using Hashmap and inorder traversal. Assuming tree has n nodes. Time complexity: O(n) Space complexity: O( n )[HashMap] + O (log(n))[Stack space]
	public void findPair1(Node root, int sum,ArrayList<Integer> list, HashMap<Integer,Integer> map) {
		
		if( root == null) {
			return;
		}
		
		findPair1(root.left,sum,list,map);
		if( map.containsKey(sum - root.data)) {
			list.add(root.data);
			list.add(sum - root.data);
			return;
		}
		map.put(root.data, 1);
		findPair1(root.right,sum,list,map);
		
	}
	
	public void inorder(Node root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	
	
	
}
