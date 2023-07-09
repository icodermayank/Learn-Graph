/*
 * Kosaraju's Alogorithm is used to find the strongly connected component in grpah
 * Strongly connected component are subsets of vertices in a grpah where there is a 
 * directed path from any vertix in the subset to any other vertex in the same 
 * component,
 * 
 * Steps;-
 *  1) Gets nodes in stack(Topological sort)
 *  2) Transpose the graph.
 *  3) Do DFS according to stack nodes on the transpose graph.
 */

 import java.util.*;
public class Kosaraju {
 
    // creating Edge class
    static class Edge{
        int src;
        int dest;
      //  int wt;

        // constructor.
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
           
        }
    }


    // function to create graph ..
    static void createGraph(ArrayList<Edge> graph[], int V){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // assigning Nodes to the grpah .
        graph[0].add(new Edge(0,3));
        graph[0].add(new Edge(0,2));
        
        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));
    }
    // Topological sorting here..

    static void topologicalSort(ArrayList<Edge> graph[], int curr, boolean vis [], Stack<Integer> s){

        vis[curr]=true;

        // performing DFS 
        for(int i =0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topologicalSort(graph, e.dest, vis, s);
            }
        }
        // add into the stack
        s.push(curr);
    }


    // code for DFS
    public static void dfs(ArrayList<Edge>graph[], int curr, boolean vis []){
        vis [curr] = true;
        System.out.print(curr+" ");

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }

    // Kosaraju Algorithm here..

    static void kosarajuAlgo(ArrayList<Edge> graph [], int V){
        //step 1; 
        // Time complexity O(V+E);

        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[V];

        for(int i=0; i<V; i++){
            if(!vis[i]){
                topologicalSort(graph, i, vis, s);
            }
        }

        //step 2 create transpose graph.
        // Time complexity: O(V+E);

        ArrayList <Edge> transpose [] = new ArrayList[V];

        for(int i=0; i<graph.length; i++){

            vis[i] =false; // to make empty again

            transpose[i] = new ArrayList<Edge>();
        }

        for(int i =0; i<V; i++){
            for(int j =0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j); // e.src(i) --> e.dest.

                transpose[e.dest].add(new Edge(e.dest, e.src));
            }
        }

        // step 3
        // Time Complexity: O(V+E);

        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]){
                dfs(transpose, curr, vis);

                 // after completing one SCC it will change the line.
                 System.out.println();
            }
           
        }

    }


    // main method here..
    public static void main(String [] args){
        int V = 5;

        ArrayList<Edge> graph [] = new ArrayList[V];

        createGraph(graph, V);

        // calling Kosaraju's Algorithm.
        kosarajuAlgo(graph, V);

    }


}
