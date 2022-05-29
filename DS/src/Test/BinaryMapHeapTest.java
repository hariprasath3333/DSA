package Test;

import Tree.BinaryMapHeap;

public class BinaryMapHeapTest {

    public static void main(String args[]){
        BinaryMapHeapTest binaryMapHeapTest = new BinaryMapHeapTest();
        //binaryMapHeapTest.insert();
        binaryMapHeapTest.delete();
    }

    public void insert(){
        BinaryMapHeap binaryMapHeap = new BinaryMapHeap();
        binaryMapHeap.insert(10);
        binaryMapHeap.insert(20);
        binaryMapHeap.insert(30);
        binaryMapHeap.insert(40);
        binaryMapHeap.insert(50);
        binaryMapHeap.print();
    }

    public void delete(){
        BinaryMapHeap binaryMapHeap = new BinaryMapHeap();
        binaryMapHeap.insert(10);
        binaryMapHeap.insert(20);
        binaryMapHeap.insert(30);
        binaryMapHeap.insert(40);
        binaryMapHeap.insert(50);
        binaryMapHeap.print();
        System.out.println("\n After delete");
        binaryMapHeap.extract();
        binaryMapHeap.print();
        System.out.println("\n After delete");
        binaryMapHeap.extract();
        binaryMapHeap.print();

    }
}
