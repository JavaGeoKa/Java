package telran.recursion.controller;

import telran.recursion.model.BSTree;

public class BSTreeAppl {

	public static void main(String[] args) {
		BSTree<Integer, String> tree = new BSTree<>();
		tree.add(2, "B");
		tree.add(1, "A");
		tree.add(3, "C");
		tree.add(2, "B");
		tree.add(1, "A");
		tree.add(3, "C1");
		System.out.println(tree.get(3));
		tree.traverse((k,v) -> System.out.println(k + " -> " + v));

	}

}
