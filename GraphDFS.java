import java.util.*;
class GraphDFS{

    // creating the Edge class to store the Edge into the ArrayList 
    static class Edge{
        int src;
        int dest;

        // creating constructor to assign the edge's value.
        Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    // creating the fucntion createGraph to create the graph ..

    static void createGraph(ArrayList <Edge> graph []){
        for(int i=0; i<graph.length; i++){
            // assign an empty Arraylist to each of the position of the graph array..
            graph[i]= new ArrayList<>();
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

    // creating the function for depth first search..
    static void dfs(ArrayList<Edge> graph [], int v, int start){
        // first create the stack to store the node into the stack..
        Stack<Integer> s = new Stack<>();

        // creating the boolean array for marking the node as visited..

        boolean vist [] = new boolean [v];

        // push the start into the stack.
        s.push(start);

        //
        while(!s.isEmpty()){
            int cur = s.pop();

            if(vist[cur] == false){
                // print the current node ..
                System.out.print(cur+" ");
                // mark them visited.
                vist[cur] = true;

                // add their neighbor into the stack..
                for(int i=0; i<graph[cur].size(); i++){
                    Edge e = graph[cur].get(i);
                    s.push(e.dest);
                }
                
            }

        }
    }
    public static void main(String [] args){
        int v = 7;
        ArrayList<Edge> graph [] = new ArrayList[v];
        int start = 3;

        // calling the function createGraph () to make the graph.
        createGraph(graph);
        dfs(graph, v, start);

    }
}