/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardsgame;

/**
 *
 * @author Abdul Sammad
 */
public class CardsGame {
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
            new Distribution_Card().Distribute_Card(Player_Head,deck[deck_top]);
            deck_top--;
            new Distribution_Card().Distribute_Card(Computer_Head,deck[deck_top]);
        }
        for(int i=0;i<52;i++)
        {
            System.out.println(deck[i]);
        }
    }
}
