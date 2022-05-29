package Tree;

public class BinaryMapHeap {

    private int[] heap;
    private int size, maxSize;

    public BinaryMapHeap(){
        maxSize = 10;
        size=0;
        heap = new int[maxSize];
    }

    public BinaryMapHeap(int maxSize){
        this.maxSize = maxSize;
        size=0;
        heap = new int[maxSize];
    }

    private int parent(int pos){
        return (pos-1)/2;
    }

    private boolean isLeaf(int pos){

        if(pos <= size && pos > (size/2)){
            return true;
        }
        return false;
    }

    private int leftChild(int pos){
        return (2 * pos) + 1;
    }

    private int rightChild(int pos){
        return (2 * pos) + 2;
    }

    private void swap(int fpos, int spos){
        int temp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = temp;
    }


    private void heapify(int pos){
        if(isLeaf(pos)){
            return;
        }

        if(heap[pos] < heap[leftChild(pos)]  || heap[pos] < heap[rightChild(pos)] ){
            if(heap[leftChild(pos)] > heap[rightChild(pos)]){
                swap(pos, leftChild(pos));
                heapify(leftChild(pos));
            }else{
                swap(pos, rightChild(pos));
                heapify(rightChild(pos));
            }
        }
    }

    public void insert(int data){
        heap[size] = data;
        int current  = size;
        while(heap[current] > heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    public int extract(){
        int extracted = heap[0];
        heap[0] = heap[size--];
        heapify(0);
        return extracted;
    }

    public void print(){

        System.out.print(heap[0] +", ");
        for(int i=0;i<(size/2);i++){
            if(leftChild(i)<size){
                System.out.print(heap[leftChild(i)]+", ");
            }
            if (rightChild(i)<size){
                System.out.print(heap[rightChild(i)]+", ");
            }
        }
    }




}
