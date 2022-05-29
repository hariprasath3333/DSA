package Test;

import Tree.GraphAdjListBFS;

public class GraphAdjListBFSTest {

    public static  void main(String args[]){
        GraphAdjListBFS graphAdjListBFS = new GraphAdjListBFS(4);

        graphAdjListBFS.addEdge(0, 1);
        graphAdjListBFS.addEdge(0, 2);
        graphAdjListBFS.addEdge(1, 2);
        graphAdjListBFS.addEdge(2, 0);
        graphAdjListBFS.addEdge(2, 3);
        graphAdjListBFS.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        graphAdjListBFS.bfs(2);
    }
}
