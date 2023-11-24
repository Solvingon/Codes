import java.util.*;

public class Dijkstra {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int ver = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int edg = sc.nextInt();

        int[][] graph= new int[ver][ver];

        System.out.println("Node 1 | Node 2 | Weight");
        for(int i=0;i<edg;i++)
        {
            int n1=sc.nextInt();
            int n2=sc.nextInt();
            int weight=sc.nextInt();

            graph[n1][n2]=weight;
        }

        System.out.println("The graph is -");
        for(int i=0;i<ver;i++)
        {
            for(int j=0;j<ver;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
        
        System.out.print("Enter the source vertex: ");
        int sv=sc.nextInt();

        dijsktraAlgo(graph,sv);
        sc.close();
}

public static void dijsktraAlgo(int[][] graph, int sv){
    int INF = (int)1e9;
    int dist[] = new int[graph.length];
    Arrays.fill(dist, INF);

    ArrayList <Integer> seqArray = new ArrayList<>();

    boolean[] visited = new boolean[graph.length];
    dist[sv]=0;


    for(int i=0;i<graph.length;i++)
    {
      int nextv=findNextMin(graph,dist,visited,seqArray);
      System.out.println("Next min vertex : "+nextv);
      visited[nextv]=true;
      seqArray.add(nextv);

      for (int j = 0; j < graph.length; j++) {
        if(!visited[j] && graph[nextv][j]!=0 && dist[nextv]!=INF && dist[nextv]+graph[nextv][j] < dist[j])
        {
            dist[j]= dist[nextv]+graph[nextv][j];
        }
      }
    }
    
    System.out.println("Vertex | Dist from SourceVertex");
    for(int i=0;i<graph.length;i++){
       System.out.println(i+ " " +dist[i]);
    }
    System.out.println("Sequence : "+seqArray);
}

    public static int findNextMin(int[][] graph, int[] dist, boolean[] visited, ArrayList <Integer> seqArray){
    int nextv=-1;
    for(int i=0;i<graph.length;i++)
    {
        if(!visited[i] && (nextv==-1 || dist[i]<dist[nextv]))
        {
            nextv = i;
        }
    }
    return nextv;
   }
}


