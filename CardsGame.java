/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardsgame;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Abdul Sammad
 */
public class CardsGame {
    public static int Player_Select()
    {
        System.out.print("Please Enter 1 for Choosing Head and 0 for Tail:-  ");
        Scanner Scan=new Scanner(System.in);
         int turn;
        try
        {
            
            turn=Scan.nextInt();
            if(turn==0||turn==1)
            {
               Random random = new Random();
               int x=random.nextInt(2);
               if(x==turn)
               {
                   System.out.print("If you want to Play First enter 1 otherwise 0:-   ");
                   int play=Scan.nextInt();
                   if(play==1||play==0)
                   {
                       if(play==1)
                       {
                           return 1;
                       }
                       else
                       {
                           return 0;
                       }
                   }
                   else
                   {
                       System.out.println("Please enter Valid Choice");
                       Player_Select();  
                   }
               }
                System.out.println(x);
            }
            else
            {
                System.out.println("Please enter Valid Option");
                Player_Select();  
            }
        }
        catch(Exception ex)
        {
            System.out.println("You have entered invalid Data Type");
          Player_Select();  
        }
        return 0;
    }
    public static void main(String[] args)
    {
        int deck_top=52;
        Player_Node Player_Head=null,Computer_Head=null;
        String[] suit={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] deck=new String[52];
        int count=-1;
        for(int i=0;i<13;i++)
        {
            
            for(int j=0;j<4;j++)
            {
                count=count+1;
                deck[count]=suit[i];
            }
        }
        new Shuffle_Array().shuffleArray(deck);
        for(int i=0;i<4;i++)
        {
            deck_top--;
            Player_Head=new Distribution_Card().Distribute_Card(Player_Head,deck[deck_top]);
            deck_top--;
            Computer_Head=new Distribution_Card().Distribute_Card(Computer_Head,deck[deck_top]);
        }
        System.out.println("Player Cards        Computer Cards");
        while(Player_Head!=null)
        {
            System.out.println(Player_Head.card+"               "+Computer_Head.card);
            Player_Head=Player_Head.link;
            Computer_Head=Computer_Head.link;
            if(Player_Head.link==null)
            {
                System.out.println(Player_Head.card+"               "+Computer_Head.card);
                break;
            }
        }
        System.out.println("Deck ");
        for(int i=0;i<52;i++)
        {
            System.out.print(deck[i]+"    ");
        }
        System.out.println("");
        int playeer_turn=Player_Select();
    }
}
