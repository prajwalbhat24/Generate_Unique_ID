package com.company;

import java.util.Random;
import java.util.Scanner;

public class generate_id
{

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        String custy="";
        System.out.println("Enter the SIZE of the string : ");
        int x=sc.nextInt();

        System.out.println("Enter the NUMBER of string : ");
        int n=sc.nextInt();

        System.out.println("1. ONLY UPPER-CASE.\n2. ONLY LOWER-CASE.\n3. UPPER-CASE & LOWER-CASE" +
                "\n4. NUMBERS.\n5. ALPHABETS & NUMBERS.\n69.CUSTOM string ");

        System.out.println("Enter the TYPE of string : ");

        int t=sc.nextInt();

        if (t==69)
        {
            System.out.println("Enter the CUSTOM string : ");
            custy=sc.next();
        }
        generate_id obj1=new generate_id();




        obj1.generateRandKey(x,n,t,custy);


    }


    public void generateRandKey(int x,int n,int t,String custy) {


        String SALTCHARS;
        if (t==1)
        {
            SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        else if (t==2)
        {
            SALTCHARS = "abcdefghijklmnopqrstuvwxyz";
        }
        else if (t==3)
        {
            SALTCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        }
        else if (t==4)
        {
            SALTCHARS = "1234567890";
        }
        else if (t==69)
        {
            SALTCHARS = custy;
        }
        else if (t==5)
        {
            SALTCHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        }
        else
        {
            SALTCHARS = "PRAJWAL";
        }

        String saltStr;


        String[] myArray=new String[n];
        boolean unq;

        for(int i=0;i<n;i++) {

            unq=true;
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();


            while (salt.length() < x) { // length of the random string.
                int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                salt.append(SALTCHARS.charAt(index));
            }

           saltStr = salt.toString();

           for (int j=0;j<n;j++)
           {
               if (saltStr.equals(myArray[j]))
               {
                   unq=false;
               }
           }

           if (unq==true)
           {
               myArray[i]=saltStr;
           }
           else
           {
               i--;
           }

         //   System.out.println(i+"] "+saltStr);



        }
        for (int i=0;i<n;i++)
        {
            System.out.println(i+1+"] "+myArray[i]);
        }



    }
}
