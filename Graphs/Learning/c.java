
/* Weighted Undirected Graph
* Q) Graphs Represenation in Java
* -> Adjacency Matrix SC:- O(N*N) Costly Space
5 6 (n: vertix) (m: edges)
2 1 2 (u,v,weight)
1 3 3
2 4 1
3 4 4
2 5 6
4 5 3
//Adjacency Matrix
0 0 0 0 0 0 
0 0 2 3 0 0 
0 2 0 0 1 6 
0 3 0 0 4 0 
0 0 1 4 0 3 
0 0 6 0 3 0
* -> Adjacency List SC:- O(2E) 
5 6 (n: vertix) (m: edges)
2 1 2 (u,v,weight)
1 3 3
2 4 1
3 4 4
2 5 6
4 5 3
//Adjacency List
0->[]
1->[(2,2), (3,3)]
2->[(1,2), (4,1), (5,6)]
3->[(1,3), (4,4)]
4->[(3,4), (2,1), (5,3)]
5->[(4,3), (2,6)]
*/
import java.util.ArrayList;
import java.util.Scanner;
public class c {
    public static Scanner sc;
    public static void main(String[] args){
       adjacencyMatrix();
       adjacencyList();
    }
    public static void adjacencyMatrix(){
       int n,m;
       sc = new Scanner(System.in);
       n = sc.nextInt();
       m = sc.nextInt();
       int adj[][] = new int[n+1][n+1];
       for(int i = 0; i < m; i++){
        int u = sc.nextInt();
        int v = sc.nextInt();
        int w = sc.nextInt();
        adj[u][v] = w;
        adj[v][u] = w;
       }
       for(int i=0;i<=n;i++){
        for(int j=0;j<=n;j++){
            System.out.print(adj[i][j] + " ");
        }
        System.out.println();
       }
    }
    public static void adjacencyList(){
        class Pair{
            int v;
            int w;
            Pair(int v, int w){
                this.v = v;
                this.w = w;
            }
            @Override
            public String toString(){
                return "(" + this.v + "," + this.w + ")";
            }
        }
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Pair>());
        }
        for(int j=0;j<m;j++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph.get(u).add(new Pair(v,w));
            graph.get(v).add(new Pair(u,w));
        }
        int key = 0;
        for(ArrayList<Pair> al: graph){
            System.out.println(key + "->" + al);
            key++;
        }
    }
}
