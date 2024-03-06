import java.io.*;
import java.util.Scanner;

public class CRC {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message:");
        String message = sc.nextLine();
        System.out.println("Enter the generator:");
        String generator = sc.nextLine();

        int data[] = new int[message.length() + generator.length() -1];
        int divisor[] = new int[generator.length()];

        for(int i=0;i<message.length();i++)
            data[i] = Integer.parseInt(message.charAt(i)+"");

        for(int i=0;i<generator.length();i++)
            divisor[i]=Integer.parseInt(generator.charAt(i)+"");

        for(int i=0;i<message.length();i++)
        {
            if(data[i]==1)
            {
                for(int j=0;j<divisor.length;j++)
                {
                    data[i+j]^=divisor[j];
                }
            }
        }

        for(int i=0;i<message.length();i++)
            data[i] = Integer.parseInt(message.charAt(i)+"");
        System.out.println("The checksum code is:");
        for(int i=0;i<data.length;i++)
            System.out.print(data[i]);
        System.out.println();

        System.out.println("Enter the checksum code:");
        message = sc.nextLine();
        System .out.println("Enter the generator:");
        generator = sc.nextLine();

        int data1[]= new int[message.length()+generator.length()-1];
        int divisor1[]=new int[generator.length()];

        for(int i=0;i<message.length();i++)
            data1[i] = Integer.parseInt(message.charAt(i)+"");
        for(int i=0;i<generator.length();i++)
            divisor1[i] = Integer.parseInt(generator.charAt(i)+"");

        for(int i=0;i<message.length();i++)
        {
            if(data1[i]==1)
            {
                for(int j=0;j<divisor1.length;j++)
                {
                    data1[i+j]^=divisor1[j];
                }
            }
        }
        boolean valid=true;
        for(int i=0;i<data1.length;i++)
        {
            System.out.print(data1[i]);
        }
        for(int i=0;i<data1.length;i++)
        {
            if(data1[i]==1)
            {
                valid=false;
                break;
            }
        }

        if(valid==true)
        {
            System.out.println("Data stream is valid");
        }
        else {
            System.out.println("Data stream is invalid. CRC obtained");
        }

    }



}
