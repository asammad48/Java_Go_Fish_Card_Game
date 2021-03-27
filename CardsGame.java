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
    static int deck_top=52;
    static String[] suit={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    static String[] deck=new String[52];
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
                System.out.println("Toss Value is :- "+x);
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
               else
               {
                 return 0;  
               }
               
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
        Scanner Scan=new Scanner(System.in);
        
        Player_Node Player_Head=null,Computer_Head=null;
        
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
            System.out.println("Please enter Value for String "+ i);
            String new_Value=Scan.next();
            //deck_top--;
            Player_Head=new Distribution_Card().Distribute_Card(Player_Head,new_Value);
            //deck_top--;
            Computer_Head=new Distribution_Card().Distribute_Card(Computer_Head,new_Value);
        }
        System.out.println("Player Cards        Computer Cards");
        Player_Node p=Player_Head,c=Computer_Head;
        while(p!=null)
        {
            System.out.println(p.card+"                   "+c.card);
            p=p.link;
            c=c.link;
            if(p.link==null)
            {
                System.out.println(p.card+"                   "+c.card);
                break;
            }
        }
        System.out.println("Deck ");
        for(int i=0;i<52;i++)
        {
            System.out.print(deck[i]+"    ");
        }
        System.out.println("");
        int player_turn=Player_Select();
        if(player_turn ==1)
        {
           /* Player_Head=new Player_Turn().Player_Turn(Player_Head);
            System.out.println("Please enter The card you want to request :- ");
            String card_Request=Scan.next();
            int check_card=Check_card(card_Request,suit);
            Player_Node[] heads=new Player_Node[2];
            if(check_card==1)
            {
                heads=new Player_Turn().Search(card_Request, Computer_Head, Player_Head);
                Computer_Head=heads[0];
                Player_Head=heads[1];
            }
            else
            {
                System.out.println("Please enter Right Value");
            }*/
        }
        else
        {
            Computer_Head=new Player_Turn().Player_Turn(Computer_Head);
        }
         while(Computer_Head!=null)
        {
            System.out.println(Computer_Head.card);
            Computer_Head=Computer_Head.link;
           
            if(Computer_Head.link==null)
            {
                System.out.println(Computer_Head.card);
                break;
            }
        }
        
    }
    public static int Check_card(String card_Request,String[] suit)
    {
        int check_card=0;
            for(int k=0;k<13;k++)
            {
                if(card_Request.equals(suit[k]))
                {
                    check_card=1;
                    break;
                }
            }
        return check_card;
    }
}
