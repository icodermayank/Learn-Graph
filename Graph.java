import java.util.*;
public class Graph {
    static class Edge{
        int src ;
        int dest;
        int wt;
        // creating constructor 
        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    // function to create graph..

    static void createGraph (ArrayList<Edge> graph []){
        for(int i =0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

            graph[0].add(new Edge(0,1,5));
            graph[0].add(new Edge(0,2,10));
            graph[1].add(new Edge(1,0,5));
            graph[1].add(new Edge(1,3,8));
    
            graph[2].add(new Edge(2,0,10));
            graph[2].add(new Edge(2,4,3));
    
            graph[3].add(new Edge(3,1,8));
            graph[3].add(new Edge(3,4,5));
            graph[3].add(new Edge(3,5,11));
    
            graph[4].add(new Edge(4,2,3));
            graph[4].add(new Edge(4,3,5));
            graph[4].add(new Edge(4,5,12));
    
            graph[5].add(new Edge(5,3,11));
            graph[5].add(new Edge(5,4,12));
            graph[5].add(new Edge(5,6,4));
    
            graph[6].add(new Edge(6,5,4));


    }
    // function for BFS traversal.
    static void bfs(ArrayList <Edge> graph [], int v, int start){
        // create Queue to store the node..
        Queue<Integer> q = new LinkedList<>();

        // create the boolean visited array to mark the visited node as true
        boolean vist [] = new boolean [v];

       // add the start node into the queue..
        q.add(start);

        while(!q.isEmpty()){
            int cur = q.remove();
            
            if(vist[cur] == false){
                // print the node and make them false..
                System.out.print(cur+" ");
                vist[cur]= true;

                // add their neighbor into the queue..
                for(int i =0; i<graph[cur].size(); i++){
                    Edge e = graph[cur].get(i);
                    q.add(e.dest);
                }
            }
        }
    }




    // funtion for DFS traversal
    static void dfs(ArrayList <Edge> graph [], int v, int start){
        // creating the stack for DFS traversal..
        Stack<Integer> s = new Stack<>();
        // creating boolean vist array to mark them visited..
        boolean vist [] = new boolean [v];
        

        // add the start into the stack
        s.push(start);

        while(!s.isEmpty()){
            // remove the cur and  check for..
            int cur = s.pop();
            if(vist [cur] == false){
                System.out.print(cur+" ");
                // mark them visited..
                vist[cur] = true;

                // add their neighbor into the stack..
                for(int i=0;i<graph[cur].size(); i++){
                    Edge e = graph[cur].get(i);

                    // push into the stack ..
                    s.push(e.dest);
                }
            }
        }

    }


    // fucntion to find the nearest neighbor first..

    static void nearestNeighbor(ArrayList<Edge> graph [], int start){
        // first we have to find the all their neighbor and return the nearest ..
        int minDis = Integer.MAX_VALUE;

        int nearestNode = 0;

        for(int i =0; i<graph[start].size(); i++){
            Edge e = graph[start].get(i);
            if(e.wt<minDis){
                minDis = e.wt;
                nearestNode  = e.dest;
            
            }
        }

        System.out.println("Nearest Node of "+start+" is: "+nearestNode);
    }

// function to print all path of the graph..
    static void printAllPath(ArrayList<Edge> graph [], boolean vist [], String path, int cur, int tar ){
        // for the best case if the cur and target became the same
        if(cur == tar){
            // print the path 
            System.out.println(path);
            // return from the function..
            return;
        }

        // start finding their neighbor for possible path..
        for(int i =0; i<graph[cur].size(); i++){
            Edge e = graph[cur].get(i);
// check if not is not visited so make them visited and call the printallpath function
// and make them unvisited again.
            if(!vist[e.dest]){
                vist[cur] = true;
                printAllPath(graph, vist, path+e.dest, e.dest, tar);
                vist[cur] = false;
            }

        }
    }


    public static void main(String [] args){
        int v = 7;
        ArrayList <Edge> graph [] = new ArrayList [v];

        // calling the create graph function to make the graph..
        createGraph(graph);
        System.out.println("BFS traversal of the graph ..");
        
        int start = 3;

        bfs(graph, v, start);

        System.out.println("\nDFS traversal  of the graph ..");
        dfs(graph, v, start);

        System.out.println("\nFinding nearest neighbor in graph..");
        nearestNeighbor(graph, start);

        int cur = 0;
        int tar = 6;
        String path = ""+cur;

        System.out.println("Printing all possible path Between "+cur+" and "+tar);
        printAllPath(graph, new boolean [v], path , cur, tar);
    }
}
