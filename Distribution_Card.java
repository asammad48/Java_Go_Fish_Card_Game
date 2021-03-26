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
public class Distribution_Card {
    public static Player_Node Distribute_Card(Player_Node head,int deck_top,String[] deck)
   {
       Player_Node Current;
       Player_Node temp;
       if(head==null)
       {
           head=new Player_Node();
           deck_top=deck_top-1;
           head.card=deck[deck_top];
           head.link=null;
       }
       else
       {
           Current=head;
           while(Current.link!=null)
           {
               Current=Current.link;
           }
           temp=new Player_Node();
           deck_top=deck_top-1;
           temp.card=deck[deck_top];
           temp.link=null;
           Current.link=temp;
       }
       return head;
   }
}
