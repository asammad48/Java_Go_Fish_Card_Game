//To use this Game Legally Please comment these lines
//193-208
//266-273
//176-183


package cardsgame;

import java.util.Random;
import java.util.Scanner;
public class CardsGame {
    static int player_turn;
    static int deck_top=52;
    static int Player_Pair=0;
    static int Computer_Pair=0;
    static String[] suit={"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    static String[] deck=new String[52];
    static Player_Node Player_Head=null,Computer_Head=null;
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
            //System.out.println("Please enter Value for String "+ i);
            //String new_Value=Scan.next();
            deck_top--;
            Player_Head=new Distribution_Card().Distribute_Card(Player_Head,deck[deck_top]);
            deck_top--;
            Computer_Head=new Distribution_Card().Distribute_Card(Computer_Head,deck[deck_top]);
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
        System.out.println("Deck from top ");
        for(int i=deck_top-1;i>-1;i--)
        {
            System.out.print(deck[i]+"    ");
        }
        System.out.println("");
        player_turn=Player_Select();
        while(deck_top>-1)
        {
          if(player_turn ==1)
        {
            System.out.println("------------- It is Player Turn -----------------");
            
             Player_Node piterate=Player_Head;
            System.out.println("");
            //System.out.println(player_turn);
            System.out.println("Player Cards");
            if(piterate!=null)
            {
               while(piterate.link!=null)
            {
                System.out.println(piterate.card);
                piterate=piterate.link;
                
            } 
            }
            if(piterate!=null)
            {
                System.out.println(piterate.card);
            }
            if(piterate==null&&deck_top==0)
            {
                break;
            }
            System.out.print("Please enter The card you want to request :- ");
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
            }
            
            
            Player_Head=new Player_Turn().Player_Turn(Player_Head);
            if(Player_Head==null)
            {
                for(int i=0;i<4;i++)
                {
                    deck_top--;
                    if(deck_top!=-1)
                    {
                    Player_Head=new Distribution_Card().Distribute_Card(Player_Head,deck[deck_top]);    
                    }
                    else
                    {
                        deck_top++;
                        break;
                    }
                    
                }
            }
           
            System.out.println("");
            System.out.println("Please Donot use this illegally it is just for Checking the Deck");
            System.out.println("-------------------------------------------");
            System.out.println("Deck from top ");
        for(int i=deck_top-1;i>-1;i--)
        {
            System.out.print(deck[i]+"    ");
        }
            System.out.println("-------------------------------------------");
            System.out.println("");
            System.out.println("Total Pair Player:- "+Player_Pair);
        }
        else
        {
            System.out.println("-------- It is Computer Turn -------");
            Player_Node citerate=Computer_Head;
            System.out.println("");
            //System.out.println(player_turn);
            System.out.println("These Card are Displaying Also for Checking the Logic Donot use it Illegally");
            System.out.println("---------------------------------------------------------");
            System.out.println("Computer Cards");
            if(citerate!=null)
            {
                 while(citerate.link!=null)
            {
                System.out.println(citerate.card);
                citerate=citerate.link;
            }
            }
           if(citerate!=null)
                {
                    System.out.println(citerate.card);
                }
            System.out.println("--------------------------------------------------------");
            if(citerate==null&&deck_top==0)
            {
                break;
            }
            Player_Node getCount=Computer_Head;
            int countIndex=-1;
            while(getCount!=null)
            {
                countIndex=countIndex+1;
                getCount=getCount.link;
            }
            //System.out.println("Count Index :- "+countIndex);
           int x=0; 
           if(countIndex>=1)
           {
                Random random = new Random();
              x=random.nextInt(countIndex);
           }
            
              // System.out.println(x);
               countIndex=-1;
               getCount=Computer_Head;
               while(getCount!=null)
               {
                   countIndex++;
                   if(x==countIndex)
                   {
                    break;
                   }
                   
                   getCount=getCount.link;
               }
               //System.out.println(getCount.card);
               Player_Node[] heads=new Player_Node[2];
               heads=new Player_Turn().Search(getCount.card, Player_Head, Computer_Head);
                Player_Head=heads[0];
                Computer_Head=heads[1];
           Computer_Head=new Player_Turn().Player_Turn(Computer_Head);
           if(Computer_Head==null)
            {
                for(int i=0;i<4;i++)
                {
                    deck_top--;
                    if(deck_top!=-1)
                    {
                    Computer_Head=new Distribution_Card().Distribute_Card(Computer_Head,deck[deck_top]);    
                    }
                    else
                    {
                        deck_top++;
                        break;
                    }
                    
                }
            }
            
           System.out.println("");
           System.out.println("Please Donot use this illegally it is just for Checking the Deck");
            System.out.println("-------------------------------------------------------------");
           System.out.println("Deck from top ");
        for(int i=deck_top-1;i>-1;i--)
        {
            System.out.print(deck[i]+"    ");
        }
            System.out.println("--------------------------------------------------------------");
            System.out.println("");
            System.out.println("Total Pair Computer:- "+Computer_Pair);
        }  
      }
        if(Player_Pair>Computer_Pair)
        {
            System.out.println("You Have Won the Game");
        }
        else if(Computer_Pair>Player_Pair)
        {
            System.out.println("Computer Have Won the Game");
        }
        else
        {
            System.out.println("The Game is tied");
        }
       /* System.out.println("Computer Cards");
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
        
         System.out.println("Player_Cards");
         while(Player_Head!=null)
        {
            System.out.println(Player_Head.card);
            Player_Head=Player_Head.link;
           
            if(Player_Head.link==null)
            {
                System.out.println(Player_Head.card);
                break;
            }
        }*/
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
