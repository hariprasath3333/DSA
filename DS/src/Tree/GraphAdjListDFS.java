package Tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class GraphAdjListDFS {

    LinkedList<Integer>[] adj;
    int noOfVertices;

    public GraphAdjListDFS(int v){
        noOfVertices = v;
        adj = new LinkedList[v];

        for(int i=0;i<v;i++){
            adj[i]= new LinkedList<>();
        }
    }

    public void addEdge(int fromVertex, int toVertex){
        adj[fromVertex].add(toVertex);
    }

    public void dfs(int sourceVertex){
        boolean[] visited = new boolean[noOfVertices];
        Stack<Integer> stack = new Stack<>();
        visited[sourceVertex]=true;
        stack.push(sourceVertex);

        while(!stack.isEmpty()){
            int currenvertex = stack.pop();
            System.out.print(currenvertex + " ");

            Iterator<Integer> iterator = adj[currenvertex].iterator();
            while(iterator.hasNext()){
                int nextVertex = iterator.next();
                if(!visited[nextVertex]){
                    visited[nextVertex] = true;
                    stack.push(nextVertex);
                }
            }
        }





    }
}
