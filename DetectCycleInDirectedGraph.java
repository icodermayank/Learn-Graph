// This is the Java program to detect the cycle in Directed graph.
import java.util.*;
public class DetectCycleInDirectedGraph {
    static class Edge{
        int src;
        int dest;
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    // function to create graph..
    static void createGraph(ArrayList<Edge> graph []){
        for(int i=0; i<graph.length; i++){
            graph [i]= new ArrayList<>();
        }

        // assigning Edge 
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,3));
        graph[3].add(new Edge(3,0));
    }
    // fucntion to detect cycle.
    static boolean isCycle(ArrayList <Edge> graph [], boolean vist[], int cur, boolean rec[]){
        // at any level mark cur as true.
        vist [cur] = true;
        // add into recursion stack.
        rec [cur] = true;

        // applying loop for all the neighbors.
        for(int i =0; i<graph[cur].size(); i++){
            Edge e = graph[cur].get(i);

            // if this neighbor is exists in recursion stack 
            if(rec[e.dest]){ // if it became true then cycle exists 
                return true;
            }
            else if(!vist[e.dest]){ // vist[neighbor] is false then mark it visited.
                if(isCycle(graph, vist, e.dest, rec)){
                    return true;
                }
                    // time complexity O(E+V);
            }
        }

        // remove from the recursion stack
        rec[cur] = false;
        // retun false means no cycle exists.
        return false;
    }
    // creating main method..
    public static void main(String [] args){
        int v = 4;
        ArrayList<Edge> graph [] = new ArrayList [v];

        // calling the function to create graph.
        createGraph(graph);

        // detection of cycle.

        System.out.println(isCycle(graph, new boolean [v], 0 , new boolean[v]));

    }
}
