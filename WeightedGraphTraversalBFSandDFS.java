// This program is dedicated to understanding of the graph traversal such as BFS and DFS
// Graph will be used as Weighted Un-Directed graph..
import java.util.*;
class WeightedGraphTraversalBFSandDFS{
    // creating the Edge class to define the edge..
    static class Edge{
        int src;
        int dest;
        int wt;

        // creating the constructor to initilize the edge details 
        Edge(int s, int d, int w){
            this.src = s; 
            this.dest = d;
            this.wt = w;
        }
    }

    // creating the create graph function to create the graph 
    static void createGraph(ArrayList <Edge> graph []){
        for (int i =0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }
         // assigning the edges into the graph..
                graph[0].add(new Edge(0, 1, 5));
                graph[0].add(new Edge(0, 2, 10));
                graph[1].add(new Edge(1, 0, 5));
                graph[1].add(new Edge(1, 3, 8));
                graph[2].add(new Edge(2, 0, 10));
                graph[2].add(new Edge(2, 4, 3));
                graph[3].add(new Edge(3, 1, 8));
                graph[3].add(new Edge(3, 4, 5));
                graph[3].add(new Edge(3, 5, 11));
                graph[4].add(new Edge(4, 2, 3));
                graph[4].add(new Edge(4, 3, 5));
                graph[4].add(new Edge(4, 5, 12));
                graph[5].add(new Edge(5, 3, 11));
                graph[5].add(new Edge(5, 4, 12));
                graph[5].add(new Edge(5, 6, 4));
                graph[6].add(new Edge(6, 5, 4));
    }


    // function for BFS...

    static void bfs(ArrayList<Edge> graph [], int v, int start){
        // create Queue to store the node of the graph..
        Queue <Integer> q = new LinkedList<>();

        // create the boolean array visited to mark the node which is actually visited.
        boolean vist [] = new boolean[v];
        // add the start into the queue..
        q.add(start);

        while(!q.isEmpty()){
            // remove an element..
            int cur = q.remove();
            // check either node is visited or not.!! 
            if(vist[cur]== false){ // if not visited then...
                // print the node..
            System.out.print(cur+ " ");
            // mark them visited...
            vist[cur] = true;

            // add their neighbor to the queue..

            for(int i=0; i<graph[cur].size(); i++){
                Edge e  = graph[cur].get(i);
                q.add(e.dest);
            }
            }
        }
    }


    // function for the depth first search traversal in graph ..
    static void dfs(ArrayList <Edge> graph [], int v, int start){
        // creating the stack to store the node of the graph..
        Stack<Integer> s = new Stack<>();

        // create the boolean array visited to mark them visited..
        boolean vist [] = new boolean[v];

        // add the start node into the stack..
        s.push(start);

        while(!s.isEmpty()){
            // pop the current node 
            int cur = s.pop();
            // check either visited or not..

            if(vist[cur] == false){
                // print the cur node
                System.out.print(cur+" ");
                // mark them visited..
                vist[cur] = true;

                // add their neighbor into the stack..
                for(int i =0; i<graph[cur].size(); i++){
                    Edge e = graph[cur].get(i);

                    // push their neighbor into the graph..
                    s.push(e.dest);
                }
            }
        }
    }
    public static void main(String [] args){

        int v = 7;

        ArrayList <Edge> graph [] = new ArrayList [v];
        createGraph(graph);

        int start = 5;
        System.out.println("Breadth First Traversal.");
        bfs(graph, v, start);
        System.out.println("\nDepth First Search Traversal.");
        dfs(graph, v, start);


    }
}