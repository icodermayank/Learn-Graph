import java.util.*;
public class GraphBFS {
    // creating the Edge class to define the Edge of the graph.
    static class Edge{
        int src;
        int dest;
        // creating constructor to initilize the data of the edge.
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    // function to create graph is used to create the graph and assign the edge into the graph..

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i =0; i<graph.length; i++){
            // assgnining an empty ArrayList to the graph array..
            graph[i] = new ArrayList<Edge>();
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

    // creating the fucntion BFS 
    public static void bFS(ArrayList <Edge> graph [], int v){

        // first of all we have to do two things 
        // 1st create the Queue to perform BFS
        // 2nd create the Visited boolean array to identify the visited nodes.
        Queue<Integer> q = new LinkedList<>();

        boolean vist [] = new boolean [v];

        // we have to add the starting point of the graph..
        q.add(0);
        while(!q.isEmpty()){
            int cur = q.remove();

            if(vist[cur]== false){
                // three rule for visiting, first print the node, mark as visited, add their neighbor,
                // step first printing.
                System.out.print(cur+" ");
                //step 2 marks as true(visited).
                vist[cur] = true;
                // step 3 add their neighbours..
                for(int i =0; i<graph[cur].size(); i++){
                    Edge e = graph[cur].get(i);
                    // all of the neighbor will add into the queue.
                    q.add(e.dest);
                }


            }
        }



    }
    


    public static void main(String [] args){
        int v =7;
        ArrayList<Edge> graph [] = new ArrayList[v];
        
        // creating the grpah...
        createGraph(graph);

        bFS(graph, v);

    }
    
}
/*
 * BFS breadth first search is a traversal algorithm that starts at the root
 *  (or another arbitrarily selected node) and explores all the neighbors nodes at the current depth 
 * before moving on the next depth.
 * This algorithm uses a queue to keep track of the nodes to visit next.
 * 
 * steps --
 *  1) Create Queue and add the starting node to it
 *  2) while the queue is not empty, remove the node from the queue and make it as visited.
 *  3) Add all unvisited neighbors of the node to the queue.
 *  4) Repeat steps 2 and 3 untill the queue is empty.
 */
