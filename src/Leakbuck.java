import java.util.Scanner;
import java.io.*;

public class Leakbuck {
    public static void main(String[] args)
    {
        int n,recv,buck_rem=0,sent,clock,buck_cap=4,rate=3;

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of packets:");
        n= sc.nextInt();
        System.out.println("Enter the packets:");
        int a[]=new int[20];
        for(int i=1;i<=n;i++)
        {
            a[i]=sc.nextInt();
        }
        System.out.println("Clock \t Packet Size \t accepted \t sent \t remaining \t");
        for(int i=1;i<=n;i++)
        {
            if(a[i]!=0)
            {
                if(buck_rem+a[i]>buck_cap)
                {
                    recv=-1;

                }
                else{
                    recv=a[i];
                    buck_rem+=a[i];
                }
            }
            else{
                recv=0;
            }
            if(buck_rem!=0)
            {
                if(buck_rem>rate)
                {
                    sent=rate;
                    buck_rem-=rate;
                }
                else{
                    sent=buck_rem;
                    buck_rem=0;
                }

            }
            else{
                sent=0;
            }
            if(recv==-1)
            {
                System.out.println(i+"\t\t\t"+a[i]+"\t\t\t"+"dropped"+"\t\t"+sent+"\t\t\t"+buck_rem);
            }
            else {
                System.out.println(i+"\t\t\t"+a[i]+"\t\t\t"+a[i]+"\t\t\t"+sent+"\t\t\t"+buck_rem);
            }
        }
    }
}
