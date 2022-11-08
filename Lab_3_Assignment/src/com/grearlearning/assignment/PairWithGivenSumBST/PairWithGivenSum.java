package com.grearlearning.assignment.PairWithGivenSumBST;

import java.io.*;
import java.util.*;

import com.grearlearning.assignment.PairWithGivenSumBST.Bst.Node;

public class PairWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = null;	
		int[] arr = {40,20,60,10,30,50,70};
		
		
		Bst bst = new Bst();
		
		for(int i = 0; i<arr.length;i++) {
			if( root == null) {
				root = bst.insert(root, arr[i]);
			}else {
				bst.insert(root,arr[i]);
			}
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the sum");
		int sum = sc.nextInt();
		
		
		//Solution 1: Using search in BST and inorder traversal. Assuming tree has n nodes. Time complexity: O(n log(n) ) Space complexity: O( log(n))[Stack space]
		ArrayList<Integer> list = new ArrayList<Integer>();
		System.out.print("Solution wit search in BST:   ");
		bst.findPair(root, sum, list,root);
		
		if(list.size() > 0) {
			System.out.println("Pair is (" + list.get(0) + "," + list.get(1) + ")");
		}else {
			System.out.println("pair nodes are not found");
		}

		System.out.println();
		
		//Solution 2: Using Hashmap and inorder traversal. Assuming tree has n nodes. Time complexity: O(n) Space complexity: O( n )[HashMap] + O (log(n))[Stack space]
		System.out.print("Solution with Hashmap:   ");
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		bst.findPair1(root, sum, list1,map);
		if(list.size() > 0) {
			System.out.println("Pair is (" + list1.get(0) + "," + list1.get(1) + ")");
		}else {
			System.out.println("pair nodes are not found");
		}
		
	}

}
