package FloydWarshall;

//A Java program for Floyd Warshall All Pairs Shortest
//Path algorithm.
import java.util.*;
import java.lang.*;
import java.io.*;


class AllPairShortestPath
{
 final static int INF = 99999, V = 62;

 int[][] floydWarshall(int graph[][]) throws IOException {
     int dist[][] = new int[V][V];
     int i, j, k;

     /* Initialize the solution matrix same as input graph matrix.
        Or we can say the initial values of shortest distances
        are based on shortest paths considering no intermediate
        vertex. */
     for (i = 0; i < V; i++)
         for (j = 0; j < V; j++)
             dist[i][j] = graph[i][j];

     /* Add all vertices one by one to the set of intermediate
        vertices.
       ---> Before start of a iteration, we have shortest
            distances between all pairs of vertices such that
            the shortest distances consider only the vertices in
            set {0, 1, 2, .. k-1} as intermediate vertices.
       ----> After the end of a iteration, vertex no. k is added
             to the set of intermediate vertices and the set
             becomes {0, 1, 2, .. k} */
     for (k = 0; k < V; k++)
     {
         // Pick all vertices as source one by one
         for (i = 0; i < V; i++)
         {
             // Pick all vertices as destination for the
             // above picked source
             for (j = 0; j < V; j++)
             {
                 // If vertex k is on the shortest path from
                 // i to j, then update the value of dist[i][j]
            	 if (dist[i][k] != INF && dist[k][j] != INF) {
	                if (dist[i][k] + dist[k][j] < dist[i][j])
	                     dist[i][j] = dist[i][k] + dist[k][j];
            	 	}
	             }
         }
     }

     // Print the shortest distance matrix
     printSolution(dist);
     
     return dist;
 }

 void printSolution(int dist[][]) throws IOException {
 
	 
	 Writer output;
	 output = new BufferedWriter(new FileWriter("ResultatFloydWarshall.txt", true));  //clears file every time
	 
     System.out.println("Following matrix shows the shortest "+
                      "distances between every pair of vertices");
     for (int i=0; i<V; ++i)
     {
         for (int j=0; j<V; ++j)
         {
             if (dist[i][j]==INF) {
            	 output.append("INF ");
                 System.out.print("INF ");
             }	
             else {
            	 output.append(dist[i][j]+"   ");
                 System.out.print(dist[i][j]+"   ");
             }
 				 
         }
         output.append("\n");
         System.out.println();
     }
     
	output.close();

 }
}

//Contributed by Aakash Hasija