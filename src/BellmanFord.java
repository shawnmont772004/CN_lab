import java.util.Scanner;
import java.io.*;


public class BellmanFord {
    private int num_ver;
    private int D[];
    public static final int MAX_VALUE=999;
    public BellmanFord(int num_ver)
    {
        this.num_ver=num_ver;
        D=new int[num_ver+1];
    }
    public void  BellmanFordEvaluation(int src,int A[][])
    {
        for(int node=1;node<=num_ver;node++)
        {
            D[node]=MAX_VALUE;
        }
        D[src]=0;
        for(int node=1;node<=num_ver-1;node++)
        {
            for(int sn=1;sn<=num_ver;sn++)
            {
                for(int dn=1;dn<=num_ver;dn++)
                {
                    if(A[sn][dn]!=MAX_VALUE)
                    {
                        if(D[dn] > D[sn]+A[sn][dn])
                        {
                            D[dn] = D[sn]+A[sn][dn];
                        }
                    }
                }
            }
        }
        for(int sn=1;sn<=num_ver;sn++)
        {
            for(int dn=1;dn<=num_ver;dn++)
            {
                if(A[sn][dn]!=MAX_VALUE)
                {
                    if(D[dn] > D[sn]+A[sn][dn])
                    {
                        System.out.println("The graph contains negative edge cycle");
                        return;

                    }
                }
            }
        }
        for(int vertex=1;vertex<=num_ver;vertex++)
        {
            System.out.println("The distance from source"+src+"to"+vertex+"is"+D[vertex]);
        }
    }
    public static void main(String[] args)
    {
        int num_ver=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        num_ver=sc.nextInt();
        int A[][]=new int[num_ver+1][num_ver+1];
        System.out.println("Enter the adacent matrix:");
        for(int sn=1;sn<=num_ver;sn++)
        {
            for(int dn=1;dn<=num_ver;dn++)
            {
                A[sn][dn]=sc.nextInt();
                if(sn==dn)
                {
                    A[sn][dn]=0;
                    continue;
                }

                if(A[sn][dn]==0)
                {
                    A[sn][dn]=MAX_VALUE;
                }

            }
        }
        System.out.println("Enter the source vertex:");
        int src=sc.nextInt();
        BellmanFord b=new BellmanFord(num_ver);
        b.BellmanFordEvaluation(src,A);
        sc.close();


    }
}
