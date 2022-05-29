package Test;

import Tree.AvlTree;

public class AvlTreeTest {

    public static void main(String args[]){
        AvlTreeTest avlTreeTest = new AvlTreeTest();
        //avlTreeTest.insert();
        avlTreeTest.delete();
    }

    public void insert(){
        AvlTree avlTree = new AvlTree();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);
        avlTree.print();
    }

    public void delete(){
        AvlTree avlTree = new AvlTree();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);
        avlTree.print();
        System.out.println("\n After Delete");
        avlTree.delete(10);
        avlTree.delete(30);
        avlTree.delete(20);
        avlTree.print();
    }
}
