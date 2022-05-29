package Test;

import Tree.GraphAdjListDFS;

public class GraphAdjListDFSTest {

    public static void main(String[] args){
        GraphAdjListDFS graphAdjListDFS = new GraphAdjListDFS(4);

        graphAdjListDFS.addEdge(0, 1);
        graphAdjListDFS.addEdge(0, 2);
        graphAdjListDFS.addEdge(1, 2);
        graphAdjListDFS.addEdge(2, 0);
        graphAdjListDFS.addEdge(2, 3);
        graphAdjListDFS.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        graphAdjListDFS.dfs(2);
    }
}
