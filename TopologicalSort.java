import java.util.*;
public class TopologicalSort {
    static class Edge{
        int src;
        int dest;
        Edge(int s, int d){
            this.src = s;
            this.dest = d;

        }
    }

    // function to create graph.
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i =0; i<graph.length; i++){
            graph [i] = new ArrayList<>();
        }
        // adding Edge into graph.

        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,1));
        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));
        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    // performing topological sort
    static void topSortUtil(ArrayList<Edge> graph [], int cur, boolean vis[], Stack<Integer> stack){
        vis[cur] = true;
        for(int i=0; i<graph[cur].size(); i++){
            Edge e = graph[cur].get(i);

            if(!vis[e.dest]){
                topSortUtil(graph, e.dest, vis, stack);
            }
        }
        stack.push(cur);
    }



    static void topologicalSort(ArrayList<Edge> graph [], int v){
        boolean vis []  = new boolean [v];
        Stack <Integer> stack = new Stack<>();

        for(int i=0; i<v; i++){
            if(!vis[i]){
                topSortUtil(graph, i, vis , stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }




    public static void main(String [] args){
        int v = 6;
        ArrayList <Edge> graph [] = new ArrayList[v];
        createGraph(graph);

        // topological sort.
        topologicalSort(graph, v);

    }
}
