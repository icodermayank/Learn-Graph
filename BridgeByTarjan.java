/*
 * Bridge in graph, using the Tarjan's algo to find the bridges in the graph,
 * 
 * Bridge is an edge whose deletion increses the graphs number of
 * connected components.
 * 
 * In Simple words if we break the Bridge grpah will break in multiple components.
 * 
 */

import java.util.*;
public class BridgeByTarjan {

    static class Edge{
        int src; 
        int dest;

        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }


    // create graph.

    static void createGraph(ArrayList<Edge> graph [], int V){
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,3));
        
    }


    // this is the tarjan's algorithm which is used to find the bridge in graph.
    public static void dfs(ArrayList<Edge>graph[],int curr,boolean vis[],int dt[],int low[],int time,int par){
        vis[curr]= true;
        dt[curr] = low[curr] = ++time;
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            // there may be three case occurs 
            // 1st condition
            if(e.dest == par){
                continue;
            }

            // second condition.
            else if(!vis[e.dest]){
                dfs(graph, e.dest, vis, dt, low, time, curr);
                low[curr] = Math.min(low[curr], low[e.dest]);

                // is this edge is bridge or not which through passed.
                if(dt[curr]<low[e.dest]){
                    System.out.println("Bridge is :"+ curr+" --- "+ e.dest);
                }

            }
            // third case of visited neighbor.
            else{
                low[curr] = Math.min(low[curr], dt[e.dest]);
            }
        }
    }

    public static void getBridge(ArrayList<Edge>graph[], int V){
        // discovery time,
        int dt [] = new int [V];
        // lowest discovery time,
        int low [] = new int[V];
        int time = 0;
        // Visited array.
        boolean vis [] = new boolean [V];

        for(int i=0; i<V; i++){
            if(!vis[i]){
                dfs(graph, i, vis, dt , low, time, -1);
            }
        }
    }
    

    // main method here..
    public static void main(String [] args){

        int V = 6;
        ArrayList<Edge> graph [] = new ArrayList[V];

        createGraph(graph, V);

        getBridge(graph, V);

    }
}
