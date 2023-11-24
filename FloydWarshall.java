import java.util.Scanner;

public class FloydWarshall{

    public void shortestdist(int[][] mat)
    {
        int n = mat.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==-1)
                {
                    mat[i][j]= (int)(1e9);
                }
                if(i==j)
                mat[i][j]=0;
            }
        }

        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    mat[i][j]=Math.min(mat[i][j], mat[i][k]+mat[k][j]);
                }
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==(int)(1e9))
                {
                    mat[i][j]=-1;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int v=sc.nextInt();

        int[][] mat=new int[v][v];

        System.out.println("Enter the adjacency matrix (Enter -1 for infinity/self):");
        for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                System.out.print("Enter the value for row "+(i+1)+" and column "+(j+1)+":");
                mat[i][j] = sc.nextInt();
            }
        }
        FloydWarshall obj = new FloydWarshall();
        obj.shortestdist(mat);

        System.out.println("Shortest Distance Matrix:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();

    }
}