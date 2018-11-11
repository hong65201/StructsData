package com.BinarySearchTree;
public class test {
	public static void main(String[] args) {
		BST<Integer> tree = new BST<>();
		int nums[] = {5,3,6,8,4,2};
		for(int num:nums) {
			tree.add(num);
		}
		System.out.println(tree);
		System.out.println("------------------------");
		/*System.out.println("最小值为:" + tree.getMin());
		System.out.println(tree);*/
		tree.remove(2);
		System.out.println(tree);
		/*
		 * 输出结果
		 *  5
			--3
			----2
			------null
			------null
			----4
			------null
			------null
			--6
			----null
			----8
			------null
			------null
			
			------------------------
			5
			--3
			----null
			----4
			------null
			------null
			--6
			----null
			----8
			------null
			------null

		 */
	}
}
