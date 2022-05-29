package Tree;

public class AvlTree {

    Node root;

    private int height(Node node) {
        if (node == null)
            return 0;

        return node.height;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private Node rightRotate(Node currentDisbalancedNode){
        Node newRoot = currentDisbalancedNode.left;
        currentDisbalancedNode.left = newRoot.right;
        newRoot.right = currentDisbalancedNode;

        currentDisbalancedNode.height = max(height(currentDisbalancedNode.left), height(currentDisbalancedNode.right)) + 1;
        newRoot.height = max(height(newRoot.left), height(newRoot.right)) + 1;

        return newRoot;
    }


    private Node leftRotate(Node currentDisbalancedNode){
        Node newRoot = currentDisbalancedNode.right;
        currentDisbalancedNode.right = newRoot.left;
        newRoot.left = currentDisbalancedNode;

        currentDisbalancedNode.height = max(height(currentDisbalancedNode.left), height(currentDisbalancedNode.right)) + 1;
        newRoot.height = max(height(newRoot.left), height(newRoot.right)) + 1;

        return newRoot;
    }

    private int getBalance(Node node) {
        if (node == null)
            return 0;

        return height(node.left) - height(node.right);
    }

    private Node insert(Node node, int data) {
        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new Node(data));

        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);
        else // Duplicate keys not allowed
            return node;

        /* 2. Update height of this ancestor node */
        node.height = max(height(node.left), height(node.right)) + 1;

        /* 3. Get the balance factor of this ancestor node to check whether this node became unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if(balance > 1 && data < node.left.data){
            return rightRotate(node);
        }

        // Right Right Case
        if(balance < -1 && data > node.right.data){
            return leftRotate(node);
        }

        // Left Right Case
        if(balance > 1 && data > node.left.data){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if(balance < -1 && data < node.right.data){
            node.right = rightRotate(node.right);
            return  leftRotate(node);
        }

        return node;
    }

    private Node delete(Node node, int data){

        if(node == null){
            return null;
        }

        if(data < node.data){
            node.left = delete(node.left, data);
        }else if(data > node.data){
            node.right = delete(node.right, data);
        }else{
            if(node.left == null && node.right == null){
                return null;
            }else if(node.right == null){
                return node.left;
            }else if(node.left == null){
                return node.right;
            }else{
                node.data = min(node.right);
                node.right = delete(node.right, node.data);
            }
        }

        node.height = max(height(node.left), height(node.right))+1;

        /* 3. Get the balance factor of this ancestor node to check whether this node became unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if(balance > 1 &&  getBalance(node.left) >= 0){
            return rightRotate(node);
        }

        // Right Right Case
        if(balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }

        // Left Right Case
        if(balance > 1 && getBalance(node.left) < 0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if(balance < -1 && getBalance(node.right) > 0){
            node.right = rightRotate(node.right);
            return  leftRotate(node);
        }


        return node;
    }

    private int min(Node node){
        int min = node.data;
        while(node != null){
            min = node.data;
            node = node.left;
        }
        return min;
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void print(){
        inOrder(root);
    }

    public void insert(int d){
        root = insert(root, d);
    }

    public void delete(int d){
        root = delete(root, d);
    }

    class Node{
        int data, height;
        Node right, left;

        Node(){
            height=1;
        }

        Node(int d){
            data = d;
            height =1;
        }
    }
}
