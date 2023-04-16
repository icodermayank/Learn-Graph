import java.security.GeneralSecurityException;
import java.util.*;

public class GraphTraversal {
    //creating the Edge class to define the edge..
    static class Edge{
        int src;
        int dest;
        // creating the constructor
        Edge(int s, int d){
            this.src = s;
            this.dest = d;

        }
    }

    // function to create graph..

    static void createGraph(ArrayList <Edge> graph[]){
        for(int i =0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
                // assigning the edge into the graph..
                graph[0].add(new Edge(0,1));
                graph[0].add(new Edge(0,2));
                graph[1].add(new Edge(1,0));
                graph[1].add(new Edge(1,3));
        
                graph[2].add(new Edge(2,0));
                graph[2].add(new Edge(2,4));
        
                graph[3].add(new Edge(3,1));
                graph[3].add(new Edge(3,4));
                graph[3].add(new Edge(3,5));
        
                graph[4].add(new Edge(4,2));
                graph[4].add(new Edge(4,3));
                graph[4].add(new Edge(4,5));
        
                graph[5].add(new Edge(5,3));
                graph[5].add(new Edge(5,4));
                graph[5].add(new Edge(5,6));
        
                graph[6].add(new Edge(6,5));
    }


        // creating the function for BFS traversal..
        static void bfs(ArrayList <Edge> graph [], int v, int start){
            // creating the queue to store the node
            Queue<Integer> q = new LinkedList<>();

            // creating the boolean array 
            boolean vist []  = new boolean [v];

            q.add(start);

            while(!q.isEmpty()){
                int cur = q.remove();

                if(vist[cur] == false){
                    System.out.print(cur+" ");
                    vist[cur] = true;

                    // add their neighbour into the queue.
                    for(int i=0; i<graph[cur].size(); i++){
                        Edge e = graph[cur].get(i);
                        q.add(e.dest);
                    }
                }
            }
        }


        // creating the fucntion for depth first traversal..
        
        static void dfs(ArrayList<Edge> graph [], int v, int start){
            // first create the stack for dfs traversal..
            Stack<Integer> s = new Stack();

            // create the boolean type array visited..
            boolean vist [] = new boolean [v];

            // add the start into stack 
            s.push(start);

            while(!s.isEmpty()){
                
                int cur = s.pop();

                if(vist[cur] == false){
                    // print the top of the stack and make them visited..
                    System.out.print(cur+" ");
                    vist[cur] = true;

                    // add their neighbour into the stack..

                    for(int i =0; i<graph[cur].size(); i++){
                        Edge e = graph[cur].get(i);

                        s.push(e.dest);
                    }
                }
            }
        }


    public static void main(String [] args){
        int v = 7;
        ArrayList <Edge> graph [] = new ArrayList [v];

        // calling the function createGraph to create graph..
        createGraph(graph);

        int start = 4;
        System.out.println("Breadth First Search Traversal.");
        bfs(graph, v, start);


        System.out.println();

        System.out.println("Depth First Search Traversal");
        dfs(graph, v, start);


    }
}
