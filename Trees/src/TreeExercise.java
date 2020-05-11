/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author csu
 */
public class TreeExercise {
    public static void main(String args[]) {
        //ancestor tree node
        List<TreeNode> AncTree = new LinkedList();
        String[] myStringsChars = new String[26];
        String tempString;
        TreeNode firstNode =  new TreeNode<>();
        TreeNode secondNode =  new TreeNode<>();

        for(int i = 0; i < 26; i++)
        {
            //String[] myStringsChars = new String[26];
            myStringsChars[i] = new String(Character.toChars(i+65));
            System.out.println(myStringsChars[i]);
        }

            //original below in case of emergencies
//        for (int i = 0; i < 26; i++) {
//            String[] myStringChars = new String[0];
//            myStringChars[i] = new String(Character.toChars(i + 65));
////            System.out.println(myStringChars[i]);
//        }

        // create the Tree as a linked structure from the array myStringChars
        //LinkedList<myStringChars> list = new LinkedList<myStringChars>();
        // the Strings are stored using the representation for trees as arrays in the book

        // (e.g. for an element i, the left child is stored in position 2*i + 1, right child is

        // on position 2*(i + 1). Also specify the level of a TreeNode


        // create a traversal by levels and print as you traverse to check that the creation of the tree has happened correctly
        TreeNode tempNode;
        for (int i = 0; i < myStringsChars.length; i++) {
            if (i == 0) {
                tempNode = new TreeNode(myStringsChars[i], null);
            } else {
                tempNode = new TreeNode(myStringsChars[i], AncTree.get((int) ((i - 1) / 2)));
            }
            AncTree.add(tempNode);
            tempNode.setLevel((int) Math.round(Math.sqrt(i)));
        }
        for (int i = 0; i < myStringsChars.length; i++) {

            if (i * 2 + 1 > myStringsChars.length) {
                AncTree.get(i).setLeftChild(null);
            } else {
                AncTree.get(i).setLeftChild(AncTree.get(i * 2 + 1));
            }
            if (((i + 1) * 2) >= myStringsChars.length) {
                AncTree.get(i).setRightChild((null));
            } else {
                AncTree.get(i).setRightChild(AncTree.get((i + 1) * 2));
            }
        }


        // create the code that asks the user for two letters in uppercase and searches for the nodes in the tree that contain
        // such letters     

        // create the code that calls the static method below and finds the lowest common ancestor of two TreeNodes
        //TreeNode firstNode = new TreeNode<>();
        //TreeNode secondNode = new TreeNode<>();

        Scanner scan = new Scanner(System.in);// prompts user for letters
        System.out.println("Enter The First Letter ");
        tempString = scan.nextLine();
        for (int i = 0; i < AncTree.size(); i++) {
            if (tempString.equalsIgnoreCase((String) AncTree.get(i).getContents())) {
                firstNode = AncTree.get(i);
            }
        }
        System.out.println("Enter The Second Letter ");
        tempString = scan.nextLine();
        for (int i = 0; i < AncTree.size(); i++) {
            if (tempString.equalsIgnoreCase((String) AncTree.get(i).getContents())) {
                secondNode = AncTree.get(i);
            }
        }


        TreeNode commonAncestor = findLowestCommonAncestor(firstNode, secondNode);

        if (commonAncestor != null) {
            System.out.println(commonAncestor.getContents());
        }
    }

    public static TreeNode findLowestCommonAncestor(TreeNode node1, TreeNode node2) {

        TreeNode commonNode = new TreeNode<>();
        if (node1.getContents() == node2.getContents()) {
            return node1;
        } else {
            if (node1.getLevel() > node2.getLevel()) {
                commonNode = findLowestCommonAncestor(node1.getParent(), node2);
            }
            if (node2.getLevel() >= node1.getLevel()) {
                commonNode = findLowestCommonAncestor(node1, node2.getParent());
            }
            //if(node1.getLevel()
        // Given two nodes on the same tree, this method should return the lowest common ancestor.
        // if no common ancestor is found, this method returns null .
    }
    return commonNode;
}
}
