import java.util.*;

class JobScheduling{

    int index, deadline, profit;
    public JobScheduling(){}

    public JobScheduling(int index, int deadline, int profit){
           this.index=index;
           this.deadline=deadline;
           this.profit=profit;
    }

    void printFinal(ArrayList <JobScheduling> arr){
           int n=arr.size();
           Collections.sort(arr,(a,b) -> (b.profit/b.deadline) - (a.profit/a.deadline));

           int maxDeadline=0;
           for(JobScheduling itr:arr)
           {maxDeadline=Math.max(maxDeadline,itr.deadline);}
           
           int jobOrder[]=new int[maxDeadline];
           int maxProfit=0;

           for(int i=0;i<n;i++)
           {
            for(int j=Math.min(maxDeadline - 1,arr.get(i).deadline - 1);j>=0;j--){
                if(jobOrder[j]==0)
                {
                    jobOrder[j] = arr.get(i).index;
                    maxProfit += arr.get(i).profit;
                    break;
                }
            }
           }

           System.out.print("Schedule of Jobs: ");
           for(int jb:jobOrder){
              if(jb!=0)
              {System.out.print((jb+1)+" ");}
           }
           System.out.println();
           System.out.print("The maximum profit is "+maxProfit);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of jobs: ");
        int n = sc.nextInt();
        ArrayList <JobScheduling> arr = new ArrayList <JobScheduling>();
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the profit for job "+(i+1)+":");
            int profit = sc.nextInt();
            System.out.println("Enter the deadline for job "+(i+1)+":");
            int deadline = sc.nextInt();
            arr.add(new JobScheduling(i,deadline,profit));
        }
        JobScheduling job = new JobScheduling();
        job.printFinal(arr);
        sc.close();
    }
}