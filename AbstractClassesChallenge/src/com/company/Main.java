package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    SearchTree tree = new SearchTree(null);
	    tree.traverse(tree.getRoot());

	    String stringData = "4 7 3 0 1 5 8 2 6 9";
	    String[] data = stringData.split(" ");

	    for(String city : data){
            tree.addItem(new Node(city));
        }

	    tree.traverse(tree.getRoot());
       /* tree.removeItem(new Node("0"));
        tree.removeItem(new Node("1"));
        tree.removeItem(new Node("2"));
        tree.removeItem(new Node("3"));
        tree.removeItem(new Node("4"));
        tree.removeItem(new Node("5"));
        tree.removeItem(new Node("6"));
        tree.removeItem(new Node("7"));
        tree.removeItem(new Node("8"));
        tree.removeItem(new Node("9"));
        tree.traverse(tree.getRoot());*/
    }
}
