package Tree;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphAdjListBFS {

    LinkedList<Integer>[]adj;
    int noOfVertices;

    public GraphAdjListBFS(int v){
        noOfVertices = v;
        adj = new LinkedList[v];

        for(int i=0;i<v;i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int from, int to){
        adj[from].add(to);
    }

    public void bfs(int source){
        boolean[] visited = new boolean[noOfVertices];
        LinkedList<Integer> queueList = new LinkedList<>();
        visited[source]=true;
        queueList.add(source);
        while(!queueList.isEmpty()){
            int s = queueList.poll();
            System.out.print(s+ " ");

            Iterator<Integer> iterator = adj[s].iterator();
            while(iterator.hasNext()){
                int vertex = iterator.next();
                if(!visited[vertex]){
                    visited[vertex] = true;
                    queueList.add(vertex);
                }
            }

        }

    }

}
