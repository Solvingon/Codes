import java.util.Scanner;

public class KnightTour{
    static int N = 8;
    static int[] moveX = {2,1,-1,-2,-2,-1,1,2};
    static int[] moveY = {1,2,2,1,-1,-2,-2,-1};

static boolean isSafe(int x, int y , int[][] board)
{
    return (x>=0 && y>=0 && x<N && y<N && board[x][y]==-1);
}

static void printSol(int[][] board){
    for(int i=0;i<N;i++){
        for(int j=0;j<N;j++){
            System.out.print((board[i][j]+1)+"\t");
        }
        System.out.println();
    }
}

static boolean solveKTUtil(int[][] board, int currX, int currY, int pos){
    if(pos==N*N)
    {
        return true;
    }
    for(int i=0;i<8;i++)
    {
        int newX=currX+moveX[i];
        int newY=currY+moveY[i];
        if(isSafe(newX, newY, board)){
            board[newX][newY]=pos;
            if(solveKTUtil(board,newX,newY,pos+1)){
                return true;
            }
            board[newX][newY] = -1;
        }
    }
    return false;
}

static boolean solveKT(int startr, int startc){
  int[][] board = new int[N][N];
  for(int i=0;i<N;i++)
  {
    for(int j=0;j<N;j++)
    {
        board[i][j]=-1;
    }
  }
  board[startr][startc]=0;
  int pos=1;
  if(!solveKTUtil(board,startr,startc,pos)){
    System.out.println("Solution doesn't exist");
    return false;
  }
  else
  {
    printSol(board);
    return true;
  }
}

public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the starting row : ");
        int startr = sc.nextInt();

        System.out.print("Enter the starting column : ");
        int startc = sc.nextInt();

    solveKT(startr-1,startc-1);
    sc.close();
}

}