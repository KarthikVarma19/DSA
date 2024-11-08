
/* Directed Graph
* Q) Graphs Represenation in Java
* -> Adjacency Matrix SC:- O(N*N) Costly Space
5 6 (n: vertix) (m: edges)
2 1 
1 3
2 4
3 4
2 5
4 5
//Adjacency Matrix
0 0 0 0 0 0 
0 0 1 1 0 0 
0 0 0 0 1 0 
0 0 0 0 1 1 
0 0 0 0 0 1 
0 0 0 0 0 0 
* -> Adjacency List SC:- O(E) It Take only Space of Number of Edges Only
5 6 (n: vertix) (m: edges)
2 1 
1 3
2 4
3 4
2 5
4 5
//Adjacency List
0->[]
1->[2, 3]
2->[4]
3->[4, 5]
4->[5]
5->[]
*/
import java.util.ArrayList;
import java.util.Scanner;
public class b {
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
        adj[u][v] = 1;
       }
       for(int i=0;i<=n;i++){
        for(int j=0;j<=n;j++){
            System.out.print(adj[i][j] + " ");
        }
        System.out.println();
       }
    }
    public static void adjacencyList(){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int j=0;j<m;j++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
        }
        int key = 0;
        for(ArrayList<Integer> al: graph){
            System.out.println(key + "->" + al);
            key++;
        }
    }
}
